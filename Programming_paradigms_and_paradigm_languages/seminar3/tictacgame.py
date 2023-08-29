class TicTacToe:
    def __init__(self):
        self.board = [[" " for _ in range(3)] for _ in range(3)]
        self.current_player = "X"

    def print_board(self):
        for i, row in enumerate(self.board, start=1):
            print(" | ".join(row))
            if i < 3:
                print("-" * 9)
        print("1   2   3")

    def check_winner(self):
        for row in self.board:
            if all(cell == self.current_player for cell in row):
                return True
        
        for col in range(3):
            if all(self.board[row][col] == self.current_player for row in range(3)):
                return True
        
        if all(self.board[i][i] == self.current_player for i in range(3)) or all(self.board[i][2 - i] == self.current_player for i in range(3)):
            return True
        
        return False

    def is_board_full(self):
        return all(all(cell != " " for cell in row) for row in self.board)

    def play(self):
        while True:
            self.print_board()
            row = int(input(f"Игрок {self.current_player}, введите номер строки (1, 2, 3): ")) - 1
            col = int(input(f"Игрок {self.current_player}, введите номер столбца (1, 2, 3): ")) - 1

            if self.board[row][col] == " ":
                self.board[row][col] = self.current_player

                if self.check_winner():
                    self.print_board()
                    print(f"Игрок {self.current_player} победил!")
                    break
                elif self.is_board_full():
                    self.print_board()
                    print("Ничья!")
                    break
                else:
                    self.current_player = "O" if self.current_player == "X" else "X"
            else:
                print("Эта ячейка уже занята. Попробуйте снова.")

if __name__ == "__main__":
    game = TicTacToe()
    game.play()

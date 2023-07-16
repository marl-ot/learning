package object_oriented_java_programming.seminar3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> history = new ArrayList<>();
        Game game = new WordGame(); // Изменено на общий тип Game
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите язык игры: (1 - русский, 2 - английский)");
        int languageChoice = scanner.nextInt();
        if (languageChoice == 1) {
            game = new WordGame();
        } else if (languageChoice == 2) {
            // Добавить класс для английской версии, если необходимо.
            // game = new EnglishWordGame();
        } else {
            System.out.println("Неправильный выбор языка. Игра будет запущена с русским языком.");
            game = new WordGame();
        }

        System.out.println("Введите размер слова:");
        int sizeWord = scanner.nextInt();

        System.out.println("Введите максимальное количество попыток:");
        int maxTry = scanner.nextInt();

        game.start(sizeWord, maxTry);
        scanner.nextLine();

        while (!game.getGameStatus().equals(GameStatus.FINISH)) {
            System.out.println("Введите слово:");
            String value = scanner.nextLine();
            Answer answer = game.inputValue(value);
            if (answer != null) {
                System.out.println("answer = " + answer);
                history.add("Ход " + answer.getNumTry() + ": " + value + " -> " + answer);
            }
        }

        // Просмотр истории игры
        System.out.println("Показать историю игры? (1 - да, 0 - нет)");
        int showHistory = scanner.nextInt();
        if (showHistory == 1) {
            System.out.println("История игры:");
            for (String entry : history) {
                System.out.println(entry);
            }
        }
    }
}
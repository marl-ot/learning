# Задача 10: На столе лежат n монеток. Некоторые из них лежат вверх решкой, а некоторые – гербом. 
# Определите минимальное число монеток, которые нужно перевернуть, чтобы все монетки были повернуты 
# вверх одной и той же стороной. Выведите минимальное количество монет, которые нужно перевернуть. С 
# клавиатуры вводятся число монет и сами монеты построчно.
# Пример:
# Ввод: 1 1 1 1 0 0 -> 2 

n = int(input("Введите сколько монеток на столе: "))
coin_head = 0
coin_tail = 0

for i in range(n):
    
    x = input(f"Введите сторону {i+1}-й монеты (орел = 1 или решка = 0): ")

    if ((x.lower() == 'орел') or (x.lower() == 'орёл') or (x == str(1))):
        coin_head += 1
    elif ((x.lower() == 'решка') or (x == str(0))):
        coin_tail += 1
    else:
        print("Вы ввели неверное значение")

if (coin_head > coin_tail > 0):
    print(f"Необходимо перевернуть {coin_tail} монет")
elif (0 < coin_head <= coin_tail):
    print(f"Необходимо перевернуть {coin_head} монет")
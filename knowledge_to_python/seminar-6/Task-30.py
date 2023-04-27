# Задача 30:  Заполните массив элементами арифметической прогрессии. Её первый 
# элемент(a1), разность(d) и количество элементов(n) нужно ввести с клавиатуры. 
# Формула для получения n-го члена прогрессии: an = a1 + (n-1) * d.
# Каждое число вводится с новой строки.

# Input:
# 1 - a1
# 2 - d
# 5 - n
# Output:
# 1, 3, 5, 7, 9

a1 = int(input("Введите первый элемент арифметической прогрессии: "))
d = int(input("Введите разность элементов: "))
n = int(input("Введите количество элементов: "))
count = 1
array = list()

def arithmetic_progression(a1, d, n, count):
    if count <= n:
        an = a1 + (count-1) * d
        array.append(an)
        return arithmetic_progression(a1, d, n, count+1)
    else:
        return array
    
print(arithmetic_progression(a1, d, n, count))
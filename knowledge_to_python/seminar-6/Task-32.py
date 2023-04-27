# Задача 32: Определить индексы элементов массива (списка), значения 
# которых принадлежат заданному диапазону (т.е. не меньше заданного 
# минимума и не больше заданного максимума)

# Input:
# 1, 3, 7, 10, 5, 8 - рассматриваемый список
# 4 - начало диапазона
# 8 - конец
# Output:
# 2(7), 4(5), 5(8)

array = list()
N = int(input("Введите количество элементов в массиве: "))
for i in range(N):
    array.append(int(input(f"Введите {i+1}-й элемент массива: ")))

start = int(input("Введите начало диапазона: "))
end = int(input("Введите конец диапазона: "))

def find_array(array, start, end):
    for i in range(len(array)):
        if start <= array[i] <= end:
            print(f"{i}({array[i]})")


find_array(array, start, end)


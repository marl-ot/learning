# Задача 26:  Напишите программу, которая на вход принимает два числа 
# A и B, и возводит число А в целую степень B с помощью рекурсии.
# *Пример:*
# A = 3; B = 5 -> 243 (3⁵)
#     A = 2; B = 3 -> 8 

A = int(input("Введите возводимое в степень число: "))
B = int(input("Введите степень: "))
count = 1
result = 1

def row(A, B, count, result):
    if count <= B:
        return row(A, B, count + 1, result * A)
    else:
        return result
    
print(f"Число {A} в степени {B} будет равно {row(A, B, count, result)}")
        
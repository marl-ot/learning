# Задача 12: Петя и Катя – брат и сестра. Петя – студент, а Катя – школьница. Петя помогает Кате по математике. 
# Он задумывает два натуральных числа X и Y (X,Y≤1000), а Катя должна их отгадать. Для этого Петя делает две подсказки. 
# Он называет сумму этих чисел S и их произведение P. Помогите Кате отгадать задуманные Петей числа.
# Пример:
# Ввод: 5 6 -> 2 3

sum_input = int(input("Введите сумму чисел: "))
work_input = int(input("Введите произведение чисел: "))

if work_input % 2 == 1:
    for i in range(1, sum_input, 2):
        for j in range(1, sum_input, 2):
            if (i+j == sum_input) and (i*j == work_input):
                num1 = i
                num2 = j
else:
    for i in range(sum_input):
        for j in range(sum_input):
            if (i+j == sum_input) and (i*j == work_input):
                num1 = i
                num2 = j

print(f"Одно число: {num1}")
print(f"Другое число: {num2}")


# Программа для определения допустимых делителей для числа

def available_devider():
    number = int(input("Введите число: "))
    result = []
    for i in range(1, number+1):
        if number % i == 0:
            result.append(i)

    return result


print(available_devider())

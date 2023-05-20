import time

# Поиск простых чисел в диапазоне

start = time.time()

# код программы


def find_simple_numbers():
    max = int(input("Введите максимальное число: "))
    result = []
    for i in range(1, max+1):
        simple = True
        for j in range(2, i):
            if (i % j == 0):
                simple = False
                break
        if simple:
            result.append(i)

    return result


print(find_simple_numbers())

end = time.time() - start

print(end)

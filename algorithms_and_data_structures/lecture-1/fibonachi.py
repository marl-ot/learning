import time

# Функция вычисления чисел Фибоначчи

start = time.time()
count = 0


def fib(position):
    global count
    count += 1
    if position == 1:
        return 0
    elif position == 2:
        return 1
    return fib(position - 1) + fib(position - 2)


n = int(input("Введите число: "))
f = fib(n)
end = time.time() - start
print(f"Последовательность Фибоначи для {n}-го элемента равна {fib(n)} \
при количестве операций {count} и его подсчет занимает {end} секунд")

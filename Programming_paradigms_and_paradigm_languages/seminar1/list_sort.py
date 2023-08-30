'''
Дан список целых чисел numbers. Необходимо написать в императивном стиле процедуру для
сортировки числа в списке в порядке убывания. Можно использовать любой алгоритм сортировки.
'''

def bubble_sort_descending(numbers):
    n = len(numbers)
    for i in range(n):
        for j in range(0, n-i-1):
            if numbers[j] < numbers[j+1]:
                numbers[j], numbers[j+1] = numbers[j+1], numbers[j]

# Пример использования
numbers = [5, 2, 9, 1, 5, 6]
bubble_sort_descending(numbers)
print(numbers)  # Вывод: [9, 6, 5, 5, 2, 1]

'''
Написать точно такую же процедуру, но в декларативном стиле
'''

def sort_descending(numbers):
    return sorted(numbers, reverse=True)

# Пример использования
numbers = [5, 2, 9, 1, 5, 6]
sorted_numbers = sort_descending(numbers)
print(sorted_numbers)  # Вывод: [9, 6, 5, 5, 2, 1]

# Бинарный поиск
# (Сложность алгоритма = O(log n)

def binary_search(data, value, min, max):
    midpoint = 0
    if max < min:
        return -1
    else:
        midpoint = (max - min) // 2 + min

    if data[midpoint] < value:
        return binary_search(data, value, midpoint + 1, max)
    elif data[midpoint] > value:
        return binary_search(data, value, min, midpoint - 1)
    else:
        return midpoint


array = [1, 2, 3, 4, 5, 6, 9]
print(binary_search(array, 9, min(array), len(array) - 1))

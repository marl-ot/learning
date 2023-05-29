# Сортировка пузырьком
# Сложность алгоритма = O(n^2)


def bubble_sort(data):
    for i in range(len(data)-1):
        for j in range(len(data)-i-1):
            if data[j] > data[j+1]:
                data[j], data[j+1] = data[j+1], data[j]
    return data


array = [3, 5, 1, 8, 2, 9, 0, 4, 6]
print(bubble_sort(array))

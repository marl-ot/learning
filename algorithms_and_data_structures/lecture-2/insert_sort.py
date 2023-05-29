# Сортировка вставками
# Сложность алгоритма = O(n^2)

def insertion(data):
    for i in range(len(data)):
        j = i - 1
        key = data[i]
        while data[j] > key and j >= 0:
            data[j + 1] = data[j]
            j -= 1
        data[j + 1] = key
    return data


array = [3, 5, 1, 8, 2, 9, 0, 4, 6]
print(insertion(array))

# Алгоритм простого поиска
# Сложность алгоритма = O(n)

def find(array, value):
    for i in range(len(array)):
        if array[i] == value:
            return i
    return -1


array = [3, 5, 1, 8, 2, 9, 0, 4, 6]
print(find(array, 7))

# Задача поиска шанса выпадения определенной суммы на 3х игральных костях

def find_sum():
    result = int(input("Введите необходимую сумму: "))
    success_result = 0
    count = 0
    for i in range(1, 7):
        for j in range(1, 7):
            for k in range(1, 7):
                if (i + j + k == result):
                    success_result += 1
                count += 1
    return (success_result/count)


print(find_sum())

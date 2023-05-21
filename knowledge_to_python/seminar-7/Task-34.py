# Задача 34:  Винни-Пух попросил Вас посмотреть, есть ли в его стихах 
# ритм. Поскольку разобраться в его кричалках не настолько просто, насколько 
# легко он их придумывает, Вам стоит написать программу. Винни-Пух считает, 
# что ритм есть, если число слогов (т.е. число гласных букв) в каждой фразе 
# стихотворения одинаковое. Фраза может состоять из одного слова, если во фразе 
# несколько слов, то они разделяются дефисами. Фразы отделяются друг от друга 
# пробелами. Стихотворение  Винни-Пух вбивает в программу с клавиатуры. В ответе 
# напишите “Парам пам-пам”, если с ритмом все в порядке и “Пам парам”, если с 
# ритмом все не в порядке

# # *Пример:*

# # **Ввод:** пара-ра-рам рам-пам-папам па-ра-па-да    
# #     **Вывод:** Парам пам-пам 


# разные слова - дефис; фразы - пробел;
# если в каждой фразе одинаковое количество слогов (гласных) - “Парам пам-пам”;


def riphm(data):
    data = list(data.split())
    vowels = ['у', 'е', 'э', 'о', 'а', 'ы', 'ю', 'и', 'я', 'ё']
    count = 0
    res = list()
    for i in data:
        for j in i:
            if j.lower() in vowels:
                count += 1
        res.append(count)
        count = 0

    if len(set(res)) == 1:
        return (print('Парам пам-пам'))
    return (print('Пам парам'))


data = str(input("Введите стихотворение: "))
riphm(data)

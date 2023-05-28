# Задача 38: Дополнить телефонный справочник возможностью изменения и удаления 
# данных. Пользователь также может ввести имя или фамилию, и Вы должны 
# реализовать функционал для изменения и удаления данных
# Простой вариант:
# Пронумеровать контакты и выбрать изменяемый по номеру.
# Интересный вариант:
# Вызвать поиск, найти единственное вхождение и его менять.


def show_data():
    """Выводит информацию из справочника"""
    with open('book.txt', 'r', encoding='utf-8') as book:
        return book.read()


def add_data():
    """Добавляет информацию в справочник."""
    fio = input('Введите ФИО: ')
    phone_num = input('Введите номер телефона: ')
    with open('book.txt', 'a', encoding='utf-8') as book:
        return book.write(f'\n{fio} | {phone_num}')


def find_data():
    """Печатает результат поиска по справочнику."""
    with open('book.txt', 'r', encoding='utf-8') as book:
        data = book.read()
    context_to_find = input('Введите, что хотите найти: ')
    result = search(data, context_to_find)
    return result


def search(book, info):
    """Находит в списке записи по определенному критерию поиска"""
    book = book.split('\n')
    return list(filter(lambda context: info.lower() in context.lower(), book))


def replace_data():
    """Удаляет строку с данными в справочнике"""       
    rd_book = open('book.txt', 'r', encoding='utf-8')
    data = show_data()
    print(data)
    context_to_change = input('Введите, что хотите заменить: ')
    while True:
        srch = search(data, context_to_change)
        if len(srch) == 1:
            context_to_replace = input('Введите то, на что хотите перезаписать: ')
            data = data.replace(context_to_change, context_to_replace)
            break
        elif len(srch) > 1:
            context_to_change = input('Слишком много вхождений. \nСкорректируйте заменяемую информацию: ')
        elif len(srch) == 0:
            context_to_change = input('Нет вхождений. \nСкорректируйте заменяемую информацию: ')
        else:
            break
    rd_book.close()
    wrt_book = open('book.txt', 'w', encoding='utf-8')
    wrt_book.write(data)
    wrt_book.close()
    return data


def delete_data():
    """Удаляет строку с данными в справочнике"""       
    rd_book = open('book.txt', 'r', encoding='utf-8')
    data = show_data()
    context_to_del = input('Введите, что хотите удалить: ')
    while True:
        srch = search(data, context_to_del)
        if len(srch) == 1:
            data = data.replace(context_to_del, '')
            break
        elif len(srch) > 1:
            context_to_del = input('Слишком много вхождений. \nСкорректируйте заменяемую информацию: ')
        elif len(srch) == 0:
            context_to_del = input('Нет вхождений. \nСкорректируйте заменяемую информацию: ')
        else:
            break

    rd_book.close()
    wrt_book = open('book.txt', 'w', encoding='utf-8')
    wrt_book.write(data)
    wrt_book.close()

    return data


while True:
    print("1. вывод \n2. добавление \n3. поиск \n4. изменение через поиск \n5. удаление записей \n6. выход")
    mode = int(input("Выберите режим: "))
    if mode == 1:
        print(show_data())
    elif mode == 2:
        print(add_data())
    elif mode == 3:
        print(find_data())
    elif mode == 4:
        print(replace_data())
    elif mode == 5:
        print(delete_data())
    elif mode == 6:
        break
    else:
        print('Указан несуществующий режим')
        break

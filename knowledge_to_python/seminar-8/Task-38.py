# Задача 38: Дополнить телефонный справочник возможностью изменения и удаления 
# данных. Пользователь также может ввести имя или фамилию, и Вы должны 
# реализовать функционал для изменения и удаления данных
# Простой вариант:
# Пронумеровать контакты и выбрать изменяемый по номеру.
# Интересный вариант:
# Вызвать поиск, найти единственное вхождение и его менять.


def show_data(file_name) -> None:
    """Выводит информацию из справочника"""
    with open(f'{str(file_name)}', 'r', encoding='utf-8') as book:
        return book.read()


def add_data(file_name) -> None:
    """Добавляет информацию в справочник."""
    fio = input('Введите ФИО: ')
    phone_num = input('Введите номер телефона: ')
    with open(f'{str(file_name)}', 'a', encoding='utf-8') as book:
        book.write(f'\n{fio} | {phone_num}')
    return 0


def find_data(file_name) -> None:
    """Печатает результат поиска по справочнику."""
    with open(f'{str(file_name)}', 'r', encoding='utf-8') as book:
        data = book.read()
    context_to_find = input('Введите, что хотите найти: ')
    result = search(data, context_to_find)
    return result


def search(book, info) -> list[str]:
    """Находит в списке записи по определенному критерию поиска"""
    book = book.split('\n')
    return list(filter(lambda context: info.lower() in context.lower(), book))


def replace_data(file_name) -> None:
    """Удаляет строку с данными в справочнике"""       
    rd_book = open(f'{str(file_name)}', 'r', encoding='utf-8')
    data = show_data(f'{str(file_name)}')
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
    wrt_book = open(f'{str(file_name)}', 'w', encoding='utf-8')
    wrt_book.write(data)
    wrt_book.close()
    return 0


def delete_data(file_name) -> None:
    """Удаляет строку с данными в справочнике"""       
    rd_book = open(f'{str(file_name)}', 'r', encoding='utf-8')
    data_lines = rd_book.readlines()
    data = show_data('book.txt')
    print('Выберите режим: \n1. удалить часть строки \n2. удалить всю строку')
    mod = int(input("Введите необходимый режим: "))
    context_to_del = input('Введите, что хотите удалить: ')
    wrt_book = open(f'{str(file_name)}', 'w', encoding='utf-8')
    while True:
        srch = search(data, context_to_del)
        if len(srch) == 1:
            if mod == 1:
                data = data.replace(context_to_del, '')
                wrt_book.write(data)
                break
            elif mod == 2:
                for line in data_lines:
                    if context_to_del not in line:
                        wrt_book.write(line)
                break
            else:
                print('Введен несуществующий режим')
                break
        elif len(srch) > 1:
            context_to_del = input('Слишком много вхождений. \nСкорректируйте заменяемую информацию: ')
        elif len(srch) == 0:
            context_to_del = input('Нет вхождений. \nСкорректируйте заменяемую информацию: ')
        else:
            break
        rd_book.close()
        wrt_book.close()
    return 0


while True:
    print("1. вывод \n2. добавление \n3. поиск \n4. изменение через поиск \n5. удаление записей \n6. выход")
    mode = int(input("Выберите режим: "))
    if mode == 1:
        print(show_data('book.txt'))
    elif mode == 2:
        add_data('book.txt')
    elif mode == 3:
        print(find_data('book.txt'))
    elif mode == 4:
        replace_data('book.txt')
    elif mode == 5:
        delete_data('book.txt')
    elif mode == 6:
        break
    else:
        print('Указан несуществующий режим')
        break

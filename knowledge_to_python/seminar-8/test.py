from (Task-38) import show_data, search

# # создание файла
# myfile = open("hello.txt", "w")

# # запись в файл
# res = myfile.write("Hello friends, how are you?")
# print(res, len('Hello friends, how are you?'), "bytes written to the file.")
# # закрытие файла
# myfile.close()

# # чтение содержимого из файла
# myfile = open("hello.txt", "r")
# print("file content...")
# print(myfile.read())

# # устанавливает текущее местоположение файла на позицию 6 
# print("file content from 6th position...")
# myfile.seek(6)
# print(myfile.read())

# # устанавливает текущее местоположение файла на позицию 0
# print("file content from 0th position...")
# myfile.seek(0)
# print(myfile.read())

# # устанавливает текущее местоположение файла на позицию 12
# print("file content from 12th position...")
# myfile.seek(15)
# print(myfile.read())

# def replace_data():
#     """Удаляет строку с данными в справочнике"""       
#     rd_book = open('book.txt', 'r+', encoding='utf-8')
#     data = rd_book.read()
#     contact_to_change = input('Введите, что хотите заменить: ')
#     while True:
#         srch = search(data, contact_to_change)
#         if len(srch) == 1:
#             contact_to_replace = input('Введите то, на что хотите перезаписать: ')
#             data = data.replace(contact_to_change, contact_to_replace)
#             print(data)
#             rd_book.close()
#             break
#         elif len(srch) > 1:
#             contact_to_change = input('Слишком много вхождений. \nСкорректируйте заменяемую информацию: ')
#         elif len(srch) == 0:
#             contact_to_change = input('Нет вхождений. \nСкорректируйте заменяемую информацию: ')
#         else:
#             break
#     wrt_book = open('book.txt', 'w', encoding='utf-8').write(data)
    
#     return wrt_book

# replace_data()


def delete_data(file_name):
    """Удаляет строку с данными в справочнике"""       
    rd_book = open(f'{str(file_name)}', 'r', encoding='utf-8')
    data_lines = rd_book.readlines()
    data = show_data('book.txt')
    print('Выберите режим: \n1. удалить часть строки \n2. удалить всю строку')
    mod = int(input("Введите необходимый режим: "))
    context_to_del = input('Введите, что хотите удалить: ')
    while True:
        srch = search(data, context_to_del)
        if len(srch) == 1:
            if mod == 1:
                data = data.replace(context_to_del, '')
                wrt_book = open(f'{str(file_name)}', 'w', encoding='utf-8')
                wrt_book.write(data)
                break
            elif mod == 2:
                wrt_book = open(f'{str(file_name)}', 'w', encoding='utf-8')
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
        wrt_book.close()  
    return 0


def delete_data(file_name):
    """Удаляет строку с данными в справочнике"""       
    rd_book = open(f'{str(file_name)}', 'r', encoding='utf-8')
    data_lines = rd_book.readlines()
    data = show_data('book.txt')
    print('Выберите режим: \n1. удалить часть строки \n2. удалить всю строку')
    mod = int(input("Введите необходимый режим: "))
    context_to_del = input('Введите, что хотите удалить: ')
    
    while True:
        if mod == 1:
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
            wrt_book = open(f'{str(file_name)}', 'w', encoding='utf-8')
            wrt_book.write(data)
            wrt_book.close()
        elif mod == 2:
            wrt_book = open(f'{str(file_name)}', 'w', encoding='utf-8')
            for line in data_lines:
                if context_to_del not in line:
                    wrt_book.write(line)
            break
        else:
            print('Введен несуществующий режим')
            break
        
        wrt_book.close()
    return data
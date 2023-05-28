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


# def search(book, info):
#     """Находит в списке записи по определенному критерию поиска"""
#     book = book.split('\n')
#     return list(filter(lambda contact: info.lower() in contact.lower(), book))


# replace_data()

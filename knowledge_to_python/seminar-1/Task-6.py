# Задача 6: Вы пользуетесь общественным транспортом? 
# Вероятно, вы расплачивались за проезд и получали билет с номером. 
# Счастливым билетом называют такой билет с шестизначным номером, где 
# сумма первых трех цифр равна сумме последних трех. Т.е. билет с номером 
# 385916 – счастливый, т.к. 3+8+5=9+1+6. Вам требуется написать программу, 
# которая проверяет счастливость билета.
# *Пример:*
# 385916 -> yes
# 123456 -> no

ticket_number = str(input("Введите шестизначное число: "))
flag = bool(int(ticket_number))
start_sum = 0
end_sum = 0
if flag and 99999 < int(ticket_number) < 1000000:
    for s_n in ticket_number[:int(len(ticket_number)/2)]:
        start_sum += int(s_n)
    for e_n in ticket_number[int(len(ticket_number)/2):]:
        end_sum += int(e_n)
    if start_sum == end_sum:
        print(f"Билет с новером {ticket_number} - счастливый")
    else:
        print(f"Билет с новером {ticket_number} - НЕсчастливый")
else:
    print('Вы ввели строку или не шестизначное чилсо')
// Задача 13: Напишите программу, которая выводит третью цифру 
// заданного числа или сообщает, что третьей цифры нет.
// 645 -> 5
// 78 -> третьей цифры нет
// 32679 -> 6

int InputValue(string message)
{
    Console.Write($"{message} > ");
    return Convert.ToInt32(Console.ReadLine());
}

int Value = InputValue("Введите число: ");

int ThirdNumber = Value % 10;

if (Value/1000 >= 1)
{
    while (Value/1000 >= 1)
    {
        Value = Value/10;
        ThirdNumber = Value % 10;
    }
System.Console.WriteLine($"Третья цифра: {ThirdNumber}");
}
else {System.Console.WriteLine($"Нет третьей цифры");}


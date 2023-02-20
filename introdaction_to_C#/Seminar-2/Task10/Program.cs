// Задача 10: Напишите программу, которая принимает на вход трёхзначное число и 
// на выходе показывает вторую цифру этого числа.
// 456 -> 5
// 782 -> 8
// 918 -> 1

int InputValue(string message)
{
    Console.Write($"{message} > ");
    return Convert.ToInt32(Console.ReadLine());
}

int number = InputValue("Введите трехзначное число");

if (number / 1000 < 1 & number / 100 >= 1) // проверка числа на трехзначность
{   
    int result = number % 100;
    result = result / 10;
    System.Console.WriteLine($"Вторая цифра числа: {result}");
}
else {System.Console.WriteLine($"Введено не трехзначное число");}
// Напишите программу, которая принимает на вход пятизначное число и проверяет, 
// является ли оно палиндромом. Проверка без применения строк
// 14212 -> нет
// 12821 -> да
// 23432 -> да

int InputValue(string message)
{
    Console.Write($"{message} > ");
    int Value;
    bool isCorrect = int.TryParse(Console.ReadLine(), out Value);
    if (isCorrect) {return Value;}
    System.Console.WriteLine("Вы ввели не число");
    Environment.Exit(1);
    return 0;
}

int Value = InputValue("Введите пятизначное число: ");

if (Value >= 10000 && Value < 100000)
{
    int num1 = Value / 10000;
    int num2 = (Value / 1000) % 10;
    int num4 = (Value % 100) / 10;
    int num5 = Value % 10;

    if (num1 == num5 && num2 == num4) {System.Console.WriteLine("Число является палиндромом");}
    else {System.Console.WriteLine("Число НЕ палиндром");}
}
else {System.Console.WriteLine("Введено не пятизначное число");}



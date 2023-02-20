// Задача 15: Напишите программу, которая принимает на вход цифру, 
// обозначающую день недели, и проверяет, является ли этот день выходным.
// 6 -> да
// 7 -> да
// 1 -> нет

Console.WriteLine("Введите число от 1 до 7 обозначающую день недели: ");
string inputValue = Console.ReadLine();
int Value = Convert.ToInt32(inputValue);

if (Value > 0 & Value < 8)
{
    if (Value == 6 || Value == 7) {System.Console.WriteLine($"Этот день недели выходной");}
    else {System.Console.WriteLine($"Этот день недели буний");}
}
else {System.Console.WriteLine($"Эта цифра находится вне недели");}
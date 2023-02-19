// Напишите программу, которая на вход принимает число (N), 
// а на выходе показывает все чётные числа от 1 до N.
// 5 -> 2, 4
// 8 -> 2, 4, 6, 8

Console.WriteLine("Введите любое число: ");
string inputValue = Console.ReadLine();
int Value = Convert.ToInt32(inputValue);
int cnt = 1;

while (cnt <= Value)
    {
    if (cnt == 1) {System.Console.WriteLine("Начало набора четных чисел между 1 и заданным числом");}
        if (cnt % 2 == 0)
            {
                System.Console.WriteLine(cnt);
            }
        if (cnt == Value) {System.Console.WriteLine("Конец набора четных чисел между 1 и заданным числом");}
        cnt = cnt + 1;
    }

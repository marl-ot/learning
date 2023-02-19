// Напишите программу, которая на вход принимает число и выдаёт, 
// является ли число чётным (делится ли оно на два без остатка).
// 4 -> да
// -3 -> нет
// 7 -> нет

Console.WriteLine("Введите любое число: ");
string inputValue = Console.ReadLine();
int Value = Convert.ToInt32(inputValue);

if (Value % 2 == 0)
    {
        System.Console.WriteLine($"Число {Value} чётное!");
    }
else
    {
        System.Console.WriteLine($"Число {Value} нечетное!");
    }
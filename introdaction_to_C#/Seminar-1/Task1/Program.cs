// Напишите программу, которая на вход принимает два числа и выдаёт, 
// какое число большее, а какое меньшее.
// a = 5; b = 7 -> max = 7
// a = 2 b = 10 -> max = 10
// a = -9 b = -3 -> max = -3

Console.WriteLine("Введите первое число: ");
string inputValue1 = Console.ReadLine();

Console.WriteLine("Введите второе число: ");
string inputValue2 = Console.ReadLine();

int Value1 = Convert.ToInt32(inputValue1);
int Value2 = Convert.ToInt32(inputValue2);

if (Value1 > Value2)
    {
        System.Console.WriteLine($"Наибольшее число {Value1}, а наименьшее число {Value2}");
    }
else if (Value1 < Value2)
    {
        System.Console.WriteLine($"Наибольшее число {Value2}, а наименьшее число {Value1}");
    }
else
    {
        System.Console.WriteLine("Оба числа равны");
    }

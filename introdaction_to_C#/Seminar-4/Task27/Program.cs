// Задача 27: Напишите программу, которая принимает 
// на вход число и выдаёт сумму цифр в числе.
// 452 -> 11
// 82 -> 10
// 9012 -> 12

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

int IntLength(int Value)
{
    int div = 10;
    int len = 1;
    while (true)
    {
        if (((Value) / div) > 0)
        {
            div = div * 10;
            len++;
        }
        else
        {
            break;
        }
    }
    return len;
}

int IntDiv(int Value)
{
    int div = 10;
    int len = 1;
    while (true)
    {
        if (((Value) / div) > 0)
        {
            div = div * 10;
            len++;
        }
        else
        {
            break;
        }
    }
    return div;
}

int SumNumbers(int Value, int len, int div)
{
    int index = 0;
    int sum = 0;
    while (len >= index)
    {
        sum = sum + Value / div;
        Value = Value % div;
        div = div / 10;
        index++;
    }
    return sum;
}

int Value = InputValue("Ввыедите число: ");
int len = IntLength(Value); 
int div = IntDiv(Value);
System.Console.WriteLine($"Сумма всех цифр числа равна {SumNumbers(Value, len, div)}");
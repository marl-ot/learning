// Задача 2: Задайте одномерный массив, заполненный случайными числами. 
// Найдите сумму элементов, стоящих на нечётных позициях.
// [3, 7, 23, 12] -> 19
// [-4, -6, 89, 6] -> 0

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

int[] GenerateArray(int length)
{
    int[] array = new int[length];
    Random random = new Random();
    for (int i = 0; i < length; i++)
    {
        array[i] = random.Next();
    }
    return array;
}

void PrintArray(int[] array)
{
    System.Console.Write('[');
    for (int i = 0; i < array.Length - 1; i++)
    {
        System.Console.Write($"{array[i]}, ");
    }
    System.Console.Write($"{array[array.Length - 1]}");
    System.Console.WriteLine(']');
}

int SumOdd(int[] array)
{
    int sum = 0;
    for (int index = 0; index < array.Length; index++)
    {
        if (index % 2 == 1) sum = sum + array[index];
    }
    return sum;
}

int length = InputValue("Длина массива: ");
int[] array = GenerateArray(length);
int OddSum = SumOdd(array);
PrintArray(array);
System.Console.WriteLine($"Сумма элементов массива, сотящих на нечетных местах, равна {OddSum}");
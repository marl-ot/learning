// Задача 3: Задайте массив вещественных чисел. 
// Найдите разницу между максимальным и минимальным 
// элементов массива.
// [3 7 22 2 78] -> 76

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

double[] GenerateArray(int length)
{
    double[] array = new double[length];
    Random random = new Random();
    for (int i = 0; i < length; i++)
    {
        array[i] = random.NextDouble() * 100;
    }
    return array;
}

void PrintArray(double[] array)
{
    System.Console.Write('[');
    for (int i = 0; i < array.Length - 1; i++)
    {
        System.Console.Write($"{array[i]}, ");
    }
    System.Console.Write($"{array[array.Length - 1]}");
    System.Console.WriteLine(']');
}

double MaxFind(double[] array)
{
    double max = array[0];
    for (int index = 0; index < array.Length; index++)
    {
        if (array[index] > max) max = array[index];
    }
    return max;
}

double MinFind(double[] array)
{
    double min = array[0];
    for (int index = 0; index < array.Length; index++)
    {
        if (array[index] < min) min = array[index];
    }
    return min;
}

int length = InputValue("Длина массива: ");
double[] array = GenerateArray(length);
double diff = MaxFind(array) - MinFind(array);
PrintArray(array);
System.Console.WriteLine($"Разница между максимальным и минимальным элементами массива равна {diff}");
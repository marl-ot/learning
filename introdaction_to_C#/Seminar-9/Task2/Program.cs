// Задача 2: Задайте значения M и N. Напишите программу, которая 
// найдёт сумму натуральных элементов в промежутке от M до N.
// M = 1; N = 15 -> 120
// M = 4; N = 8 -> 30

int M = InputValue("Введите стартовое значение: ");
int N = InputValue("Введите финальное значение: ");

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

int SumNumbers(int M, int N)
{
    int sum = 0;
    for (int i = M; i <= N; i++)
	{
		sum += i;
	}
    return sum;
}

Console.WriteLine($"Сумма элементов от {M} до {N} равна {SumNumbers(M, N)}");
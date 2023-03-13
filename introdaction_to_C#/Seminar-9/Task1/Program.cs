// Задача 1: Задайте значения M и N. Напишите программу, которая выведет 
// все чётные натуральные числа в промежутке от M до N с помощью рекурсии.
// M = 1; N = 5 -> "2, 4"
// M = 4; N = 8 -> "4, 6, 8"

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

void EvenBetweenNumbers(int M, int N)
{
    if (M % 2 == 1) M++;

    for (int i = M; i <= N; i+=2)
	{
		Console.Write($"{i} ");
	}
}

EvenBetweenNumbers(M, N);
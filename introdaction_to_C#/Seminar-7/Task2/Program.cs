// Задача 2. Напишите программу, которая на вход принимает позиции элемента в 
// двумерном массиве, и возвращает значение этого элемента или же указание, что такого элемента нет.
// Например, задан массив:
// 1 4 7 2
// 5 9 2 3
// 8 4 2 4
// 1, 7 -> такого числа в массиве нет

int m = new Random().Next(1, 10);
int n = new Random().Next(1, 10);
int input_m = InputValue("Укажите номер строки: ");
int input_n = InputValue("Укажите столбец: ");
int[,] matrix = GenerateMatrix(m, n);
PrintMatrix(m, n, matrix);
ValueReturn(m, n, input_m, input_n, matrix);

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

int[,] GenerateMatrix(int m, int n)
{
    int[,] matrix = new int[m, n];
    Random random = new Random();
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            matrix[i, j] = random.Next(-10, 10) * random.Next(-10, 10);
        }
    }
    return matrix;
}

void PrintMatrix(int m, int n, int[,] matrix)
{
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            Console.Write($"{matrix[i, j]} ");
        }
    Console.WriteLine();
    }
}

void ValueReturn(int m, int n, int input_m, int input_n, int[,] matrix)
{
    if (input_m-1 < m & input_n-1 < n) {Console.Write($"Значение в указанных координатах матрицы равно {matrix[input_m-1, input_n-1]}");}
    else {Console.Write($"Не существует значения по указанным координатам");}
}
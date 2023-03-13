// Задача 3. Задайте двумерный массив из целых чисел. 
// Найдите среднее арифметическое элементов в каждом столбце.
// Например, задан массив:
// 1 4 7 2
// 5 9 2 3
// 8 4 2 4
// Среднее арифметическое каждого столбца: 4,6; 5,6; 3,6; 3.

int m = InputValue("Укажите количество строк: ");
int n = InputValue("Укажите количество столбцов: ");
int[,] matrix = GenerateMatrix(m, n);
PrintMatrix(m, n, matrix);
AveregeCount(m, n, matrix);

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

void AveregeCount(int m, int n, int[,] matrix)
{
    double sum = 0;
    int count_rows = matrix.GetLength(0);
    int count_colomns = matrix.GetLength(1);
    for (int colomn = 0; colomn < n; colomn++)
    {
        sum = 0;
        for (int row = 0; row < m; row++)
        {
            sum += matrix[row, colomn];
        }
    // Console.WriteLine($"Сумма {row}-й строки равна {sum/count_rows}");
    Console.WriteLine($"Сумма {colomn+1}-й строки равна {sum/count_colomns}");
    }
}
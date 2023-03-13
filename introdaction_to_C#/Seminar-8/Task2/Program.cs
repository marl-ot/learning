// Задача 2: Задайте прямоугольный двумерный массив. 
// Напишите программу, которая будет находить строку с наименьшей суммой элементов.

int m = InputValue("Укажите количество строк: ");
int n = InputValue("Укажите количество столбцов: ");
int[,] matrix = GenerateMatrix(m, n);
PrintMatrix(matrix);
int min_sum = SearchMinSumString(matrix);
Console.WriteLine($"Минимальная сумма строки равна {min_sum}");


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
    for (int row = 0; row < m; row++)
    {
        for (int colomn = 0; colomn < n; colomn++)
        {
            matrix[row, colomn] = random.Next(-10, 10) * random.Next(-10, 10);
        }
    }
    return matrix;
}

void PrintMatrix(int[,] matrix)
{
    for (int row = 0; row < matrix.GetLength(0); row++)
    {
        for (int colomn = 0; colomn < matrix.GetLength(1); colomn++)
        {
            Console.Write($"{matrix[row, colomn]} ");
        }
    Console.WriteLine();
    }
}

int SearchMinSumString(int[,] matrix)
{
    int min_sum = 101*matrix.GetLength(1);
    int sum = 0;
    for (int row = 0; row < matrix.GetLength(0); row++)
    {
        for (int colomn = 0; colomn < matrix.GetLength(1); colomn++)
        {
            sum += matrix[row, colomn];
        }
        if (sum < min_sum) min_sum = sum;
    }
    return min_sum;
}
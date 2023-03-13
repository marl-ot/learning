// Задача 1: Задайте двумерный массив. Напишите программу, которая упорядочивает 
// по убыванию элементы каждой строки двумерного массива.

int m = InputValue("Укажите количество строк: ");
int n = InputValue("Укажите количество столбцов: ");
int[,] matrix = GenerateMatrix(m, n);
Console.WriteLine("Сгенерированная матрица:");
PrintMatrix(matrix);
SortMatrix(matrix);
Console.WriteLine();
Console.WriteLine("Отсортированная матрица:");
PrintMatrix(matrix);

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

int[,] SortMatrix(int[,] matrix)
{
    for (int row = 0; row < matrix.GetLength(0); row++)
    {
        for (int colomn = 0; colomn < matrix.GetLength(1); colomn++)
        {
            for (int index = 0; index < matrix.GetLength(1)-colomn-1; index++)
            {
                if (matrix[row, index] < matrix[row, index+1])
                {
                    int x = matrix[row, index];
                    matrix[row, index] = matrix[row, index+1];
                    matrix[row, index+1] = x;
                }
            }
            
        }
    }
    return matrix;
}

        // int colomn_sum = 0;
        // for (int colomn = 0; colomn < matrix.GetLength(1); colomn++)
        // {
        //     colomn_sum += matrix[row, colomn];
        // }
        // Console.Write($"Сумма {row}-й строки равна {colomn_sum}");
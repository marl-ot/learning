// Задача 3 * : Задайте две матрицы. Напишите программу, 
// которая будет находить произведение двух матриц.

int m1 = InputValue("Укажите количество строк: ");
int n1 = InputValue("Укажите количество столбцов: ");
int m2 = m1;
int n2 = n1;
int[,] matrix1 = GenerateMatrix(m1, n1);
int[,] matrix2 = GenerateMatrix(m2, n2);
int[,] multyMatrix = MultiplicationMatrix(matrix1, matrix2);

Console.WriteLine("Результат перемножения матрицы 1:");
PrintMatrix(matrix1);
Console.WriteLine("с матрицей 2:");
PrintMatrix(matrix2);
Console.WriteLine("выдает результат");
PrintMatrix(multyMatrix);





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

int[,] MultiplicationMatrix(int[,] matrix1, int[,] matrix2)
{
    int[,] multyMatrix = new int[matrix1.GetLength(0), matrix1.GetLength(1)];
    for (int row = 0; row < matrix1.GetLength(0); row++)
    {
        for (int colomn = 0; colomn < matrix1.GetLength(1); colomn++)
        {
            multyMatrix[row, colomn] = matrix1[row, colomn] * matrix2[row, colomn];
        }
    }
    return multyMatrix;
}
    

// Задача 4 * : Напишите программу, которая заполнит спирально квадратный массив.

int m = InputValue("Введите размеры массива: ");
int[,] matrix = GenerateMatrix(m);
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

int[,] GenerateMatrix(int m)
{
    int[,] matrix = new int[m, m];
    int i = 0;
    int j = 0;
    int count = 1;
    while (count <= matrix.GetLength(0) * matrix.GetLength(1))
    {
        matrix[i, j] = count;
        count++;
        if (i <= j + 1 && i + j < matrix.GetLength(1) - 1) j++;
        else if (i < j && i + j >= matrix.GetLength(0) - 1) i++;
        else if (i >= j && i + j > matrix.GetLength(1) - 1) j--;
        else i--;
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
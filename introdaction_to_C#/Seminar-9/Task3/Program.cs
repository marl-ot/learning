// Задача 3: Напишите программу вычисления функции Аккермана с помощью рекурсии. 
// Даны два неотрицательных числа m и n.
// m = 2, n = 3 -> A(m,n) = 9
// m = 3, n = 2 -> A(m,n) = 29

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

int akkerman(int M, int N)
{
    if (M == 0) return N + 1;
    else if (N == 0) return akkerman(M - 1, 1);
    else return akkerman(M - 1, akkerman(M, N - 1));
}

Console.Write($"Функция Аккермана равно {akkerman(M, N)}");
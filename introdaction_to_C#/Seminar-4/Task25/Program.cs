// Задача 25: Напишите цикл, который принимает на вход два числа 
// (A и B) и возводит число A в натуральную степень B.
// 3, 5 -> 243 (3⁵)
// 2, 4 -> 16

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

int A = InputValue("Введите основание числа: ");
int B = InputValue("Введите степень числа: ");

int Degree(int A, int B)
{
    int local_result = 1;
    for (int i = 0; i < B; i++)
    {
        local_result = A*B;
    }
    return local_result;
}

int result = Degree(A, B);
System.Console.WriteLine($"Число {A} в степени {B} будет равно {result}");
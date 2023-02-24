// Напишите программу, которая принимает на вход координаты двух точек и находит 
// расстояние между ними в 3D пространстве.
// A (3,6,8); B (2,1,-7), -> 15.84
// A (7,-5, 0); B (1,-1,9) -> 11.53

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

int X1 = InputValue("Введите ПЕРВУЮ координату по оси X");
int Y1 = InputValue("Введите ПЕРВУЮ координату по оси Y");
int Z1 = InputValue("Введите ПЕРВУЮ координату по оси Z");

int X2 = InputValue("Введите ВТОРУЮ координату по оси X");
int Y2 = InputValue("Введите ВТОРУЮ координату по оси Y");
int Z2 = InputValue("Введите ВТОРУЮ координату по оси Z");

double d = Math.Sqrt(Math.Pow(X2 - X1, 2) + Math.Pow(Y2 - Y1, 2) + Math.Pow(Z2 - Z1, 2));
System.Console.WriteLine($"Расстояние между точками X и Y равно {d}");

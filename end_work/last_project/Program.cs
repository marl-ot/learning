// Написать программу, которая из имеющегося массива строк формирует массив строк, длина которых
// меньше либо равна 3 символа. Первоначальный массив можно ввести с клавиатуры, либо задать
// на старте выполнения алгоритма. При решении не рекомендуется пользоваться коллекциями
// лучше обойтись исключительно массивами.

string[] strings1 = {"hello", "2", "world", ":-)"};
string[] strings2 = {"1234", "1567", "-2", "computer science"};
string[] strings3 = {"Russia", "Denmark", "Kazan"};

void StringsResilt(string[] strings)
{
    string[] result = {};

    Console.Write("[");
    for (int i = 0; i < strings.Length; i++)
    {
        if (strings[i].Length < 4)
        {
            Console.Write($"'{strings[i]}',");
        }
    }
    Console.Write("]");
}

StringsResilt(strings3);
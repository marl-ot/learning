package knowledge_to_java.seminar2;

// Дана последовательность N целых чисел. Найти сумму простых чисел.

import java.util.Scanner;

public class SumSmileNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел в последовательности: ");
        int n = scanner.nextInt();

        int[] sequence = new int[n];

        System.out.println("Введите числа последовательности:");
        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int num : sequence) {
            if (isPrime(num)) {
                sum += num;
            }
        }

        System.out.println("Сумма простых чисел: " + sum);
    }

    // Метод для проверки, является ли число простым
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
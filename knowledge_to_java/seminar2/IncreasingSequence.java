package knowledge_to_java.seminar2;

// Дана последовательность из N целых чисел. Верно ли, что последовательность является возрастающей.

import java.util.Scanner;

public class IncreasingSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество чисел в последовательности: ");
        int n = scanner.nextInt();

        int[] sequence = new int[n];

        System.out.println("Введите числа последовательности:");
        for (int i = 0; i < n; i++) {
            sequence[i] = scanner.nextInt();
        }

        boolean isIncreasing = true;
        for (int i = 1; i < n; i++) {
            if (sequence[i] <= sequence[i - 1]) {
                isIncreasing = false;
                break;
            }
        }

        if (isIncreasing) {
            System.out.println("Последовательность является возрастающей.");
        } else {
            System.out.println("Последовательность не является возрастающей.");
        }
    }
}

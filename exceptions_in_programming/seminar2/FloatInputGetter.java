package exceptions_in_programming.seminar2;

import java.util.Scanner;

public class FloatInputGetter {
    public static void main(String[] args) {
        float userFloat = getFloatInput("Введите дробное число: ");
        System.out.println("Вы ввели: " + userFloat);
    }

    public static float getFloatInput(String prompt) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.print(prompt);
                    return Float.parseFloat(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Введите дробное число (например, 3.14). Попробуйте еще раз.");
                }
            }
        }
    }
}

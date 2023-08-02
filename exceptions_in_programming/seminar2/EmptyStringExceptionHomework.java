package exceptions_in_programming.seminar2;

import java.util.Scanner;

public class EmptyStringExceptionHomework {
    public static void main(String[] args) {
        try {
            String userInput = getStringInput("Введите текст: ");
            System.out.println("Вы ввели: " + userInput);
        } catch (EmptyStringException e) {
            System.out.println("Ошибка: Пустые строки вводить нельзя!");
        }
    }

    public static String getStringInput(String prompt) throws EmptyStringException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                throw new EmptyStringException();
            }
            return input;
        }
    }
}

class EmptyStringException extends Exception {
    public EmptyStringException() {
        super("Введена пустая строка.");
    }
}


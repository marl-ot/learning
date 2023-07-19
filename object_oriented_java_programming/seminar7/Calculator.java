package object_oriented_java_programming.seminar7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public static void main(String[] args) {
        System.out.println("Калькулятор для работы с рациональными и комплексными числами:");
        System.out.println("1. Сложение рациональных чисел");
        System.out.println("2. Вычитание рациональных чисел");
        System.out.println("3. Умножение рациональных чисел");
        System.out.println("4. Деление рациональных чисел");
        System.out.println("5. Сложение комплексных чисел");
        System.out.println("6. Вычитание комплексных чисел");
        System.out.println("7. Умножение комплексных чисел");
        System.out.println("8. Деление комплексных чисел");
        System.out.println("0. Выход");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice;
        do {
            System.out.print("Выберите операцию (введите номер): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    performRationalOperation(new RationalAddition());
                    break;
                case 2:
                    performRationalOperation(new RationalSubtraction());
                    break;
                case 3:
                    performRationalOperation(new RationalMultiplication());
                    break;
                case 4:
                    performRationalOperation(new RationalDivision());
                    break;
                case 5:
                    performComplexOperation(new ComplexAddition());
                    break;
                case 6:
                    performComplexOperation(new ComplexSubtraction());
                    break;
                case 7:
                    performComplexOperation(new ComplexMultiplication());
                    break;
                case 8:
                    performComplexOperation(new ComplexDivision());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте еще раз.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void performRationalOperation(RationalOperation operation) {
        RationalNumber num1 = new RationalNumber(1, 2);
        RationalNumber num2 = new RationalNumber(3, 4);
        RationalNumber result = operation.execute(num1, num2);
        System.out.println(operation);
        logger.debug("Операция " + operation.getOperationName() + " выполнена");
    }

    private static void performComplexOperation(ComplexOperation operation) {
        ComplexNumber num1 = new ComplexNumber(2, 3);
        ComplexNumber num2 = new ComplexNumber(1, -2);
        ComplexNumber result = operation.execute(num1, num2);
        System.out.println(operation);
        logger.debug("Операция " + operation.getOperationName() + " выполнена");
    }
}

package object_oriented_java_programming.seminar5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {
    private static final Logger logger = LogManager.getLogger(Calculator.class);

    public static void main(String[] args) {
        System.out.println("Калькулятор для работы с рациональными и комплексными числами:");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");
        System.out.println("0. Выход");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice;
        do {
            System.out.print("Выберите операцию (введите номер): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNumbers();
                    break;
                case 2:
                    subtractNumbers();
                    break;
                case 3:
                    multiplyNumbers();
                    break;
                case 4:
                    divideNumbers();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте еще раз.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void addNumbers() {
        // Рациональные числа: a/b + c/d = (ad + bc) / bd
        RationalNumber num1 = new RationalNumber(1, 2);
        RationalNumber num2 = new RationalNumber(3, 4);
        RationalNumber result = num1.add(num2);
        System.out.println(num1 + " + " + num2 + " = " + result);

        // Комплексные числа: (a + bi) + (c + di) = (a + c) + (b + d)i
        ComplexNumber cNum1 = new ComplexNumber(2, 3);
        ComplexNumber cNum2 = new ComplexNumber(1, -2);
        ComplexNumber cResult = cNum1.add(cNum2);
        System.out.println(cNum1 + " + " + cNum2 + " = " + cResult);

        logger.debug("Операция добавления выполнена");
    }

    private static void subtractNumbers() {
        // Рациональные числа: a/b - c/d = (ad - bc) / bd
        RationalNumber num1 = new RationalNumber(5, 7);
        RationalNumber num2 = new RationalNumber(2, 7);
        RationalNumber result = num1.subtract(num2);
        System.out.println(num1 + " - " + num2 + " = " + result);

        // Комплексные числа: (a + bi) - (c + di) = (a - c) + (b - d)i
        ComplexNumber cNum1 = new ComplexNumber(3, 4);
        ComplexNumber cNum2 = new ComplexNumber(1, -2);
        ComplexNumber cResult = cNum1.subtract(cNum2);
        System.out.println(cNum1 + " - " + cNum2 + " = " + cResult);

        logger.debug("Операция вычитания выполнена");
    }

    private static void multiplyNumbers() {
        // Рациональные числа: a/b * c/d = (ac) / (bd)
        RationalNumber num1 = new RationalNumber(2, 3);
        RationalNumber num2 = new RationalNumber(4, 5);
        RationalNumber result = num1.multiply(num2);
        System.out.println(num1 + " * " + num2 + " = " + result);

        // Комплексные числа: (a + bi) * (c + di) = (ac - bd) + (ad + bc)i
        ComplexNumber cNum1 = new ComplexNumber(1, 2);
        ComplexNumber cNum2 = new ComplexNumber(3, -1);
        ComplexNumber cResult = cNum1.multiply(cNum2);
        System.out.println(cNum1 + " * " + cNum2 + " = " + cResult);

        logger.debug("Операция умножения выполнена");
    }

    private static void divideNumbers() {
        // Рациональные числа: (a/b) / (c/d) = (a/b) * (d/c) = (ad) / (bc)
        RationalNumber num1 = new RationalNumber(3, 4);
        RationalNumber num2 = new RationalNumber(2, 5);
        RationalNumber result = num1.divide(num2);
        System.out.println(num1 + " / " + num2 + " = " + result);

        // Комплексные числа: (a + bi) / (c + di) = ((a + bi) * (c - di)) / (c^2 + d^2)
        ComplexNumber cNum1 = new ComplexNumber(1, 2);
        ComplexNumber cNum2 = new ComplexNumber(1, 1);
        ComplexNumber cResult = cNum1.divide(cNum2);
        System.out.println(cNum1 + " / " + cNum2 + " = " + cResult);

        logger.debug("Операция деления выполнена");
    }
}

class RationalNumber {
    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Метод для получения строкового представления рационального числа
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    // Методы для сложения, вычитания, умножения и деления рациональных чисел
    public RationalNumber add(RationalNumber other) {
        int commonDenominator = this.denominator * other.denominator;
        int sumNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
        return new RationalNumber(sumNumerator, commonDenominator);
    }

    public RationalNumber subtract(RationalNumber other) {
        int commonDenominator = this.denominator * other.denominator;
        int diffNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
        return new RationalNumber(diffNumerator, commonDenominator);
    }

    public RationalNumber multiply(RationalNumber other) {
        int resultNumerator = this.numerator * other.numerator;
        int resultDenominator = this.denominator * other.denominator;
        return new RationalNumber(resultNumerator, resultDenominator);
    }

    public RationalNumber divide(RationalNumber other) {
        int resultNumerator = this.numerator * other.denominator;
        int resultDenominator = this.denominator * other.numerator;
        return new RationalNumber(resultNumerator, resultDenominator);
    }
}

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    // Метод для получения строкового представления комплексного числа
    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }

    // Методы для сложения, вычитания, умножения и деления комплексных чисел
    public ComplexNumber add(ComplexNumber other) {
        double sumReal = this.real + other.real;
        double sumImaginary = this.imaginary + other.imaginary;
        return new ComplexNumber(sumReal, sumImaginary);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        double diffReal = this.real - other.real;
        double diffImaginary = this.imaginary - other.imaginary;
        return new ComplexNumber(diffReal, diffImaginary);
    }

    public ComplexNumber multiply(ComplexNumber other) {
        double resultReal = this.real * other.real - this.imaginary * other.imaginary;
        double resultImaginary = this.real * other.imaginary + this.imaginary * other.real;
        return new ComplexNumber(resultReal, resultImaginary);
    }

    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double resultReal = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double resultImaginary = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new ComplexNumber(resultReal, resultImaginary);
    }
}

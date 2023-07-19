package object_oriented_java_programming.seminar7;

public class RationalNumber {
    private int numerator;
    private int denominator;

    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Методы для выполнения операций с рациональными числами
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

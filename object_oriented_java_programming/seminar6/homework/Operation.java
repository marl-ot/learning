package object_oriented_java_programming.seminar6.homework;

abstract class Operation {
    protected String operationName;

    public abstract String getOperationName();
}

abstract class RationalOperation extends Operation {
    public abstract RationalNumber execute(RationalNumber num1, RationalNumber num2);
}

abstract class ComplexOperation extends Operation {
    public abstract ComplexNumber execute(ComplexNumber num1, ComplexNumber num2);
}

// Класс для сложения рациональных чисел
class RationalAddition extends RationalOperation {
    public RationalAddition() {
        operationName = "сложения рациональных чисел";
    }

    @Override
    public RationalNumber execute(RationalNumber num1, RationalNumber num2) {
        int commonDenominator = num1.getDenominator() * num2.getDenominator();
        int sumNumerator = num1.getNumerator() * num2.getDenominator() + num2.getNumerator() * num1.getDenominator();
        return new RationalNumber(sumNumerator, commonDenominator);
    }

    @Override
    public String getOperationName() {
        return operationName;
    }

    @Override
    public String toString() {
        return "Результат " + operationName + ": ";
    }
}

// Класс для вычитания рациональных чисел
class RationalSubtraction extends RationalOperation {
    public RationalSubtraction() {
        operationName = "вычитания рациональных чисел";
    }

    @Override
    public RationalNumber execute(RationalNumber num1, RationalNumber num2) {
        int commonDenominator = num1.getDenominator() * num2.getDenominator();
        int diffNumerator = num1.getNumerator() * num2.getDenominator() - num2.getNumerator() * num1.getDenominator();
        return new RationalNumber(diffNumerator, commonDenominator);
    }

    @Override
    public String getOperationName() {
        return operationName;
    }

    @Override
    public String toString() {
        return "Результат " + operationName + ": ";
    }
}

// Класс для умножения рациональных чисел
class RationalMultiplication extends RationalOperation {
    public RationalMultiplication() {
        operationName = "умножения рациональных чисел";
    }

    @Override
    public RationalNumber execute(RationalNumber num1, RationalNumber num2) {
        int resultNumerator = num1.getNumerator() * num2.getNumerator();
        int resultDenominator = num1.getDenominator() * num2.getDenominator();
        return new RationalNumber(resultNumerator, resultDenominator);
    }

    @Override
    public String getOperationName() {
        return operationName;
    }

    @Override
    public String toString() {
        return "Результат " + operationName + ": ";
    }
}

// Класс для деления рациональных чисел
class RationalDivision extends RationalOperation {
    public RationalDivision() {
        operationName = "деления рациональных чисел";
    }

    @Override
    public RationalNumber execute(RationalNumber num1, RationalNumber num2) {
        int resultNumerator = num1.getNumerator() * num2.getDenominator();
        int resultDenominator = num1.getDenominator() * num2.getNumerator();
        return new RationalNumber(resultNumerator, resultDenominator);
    }

    @Override
    public String getOperationName() {
        return operationName;
    }

    @Override
    public String toString() {
        return "Результат " + operationName + ": ";
    }
}

// Класс для сложения комплексных чисел
class ComplexAddition extends ComplexOperation {
    public ComplexAddition() {
        operationName = "сложения комплексных чисел";
    }

    @Override
    public ComplexNumber execute(ComplexNumber num1, ComplexNumber num2) {
        double sumReal = num1.getReal() + num2.getReal();
        double sumImaginary = num1.getImaginary() + num2.getImaginary();
        return new ComplexNumber(sumReal, sumImaginary);
    }

    @Override
    public String getOperationName() {
        return operationName;
    }

    @Override
    public String toString() {
        return "Результат " + operationName + ": ";
    }
}

// Класс для вычитания комплексных чисел
class ComplexSubtraction extends ComplexOperation {
    public ComplexSubtraction() {
        operationName = "вычитания комплексных чисел";
    }

    @Override
    public ComplexNumber execute(ComplexNumber num1, ComplexNumber num2) {
        double diffReal = num1.getReal() - num2.getReal();
        double diffImaginary = num1.getImaginary() - num2.getImaginary();
        return new ComplexNumber(diffReal, diffImaginary);
    }

    @Override
    public String getOperationName() {
        return operationName;
    }

    @Override
    public String toString() {
        return "Результат " + operationName + ": ";
    }
}

// Класс для умножения комплексных чисел
class ComplexMultiplication extends ComplexOperation {
    public ComplexMultiplication() {
        operationName = "умножения комплексных чисел";
    }

    @Override
    public ComplexNumber execute(ComplexNumber num1, ComplexNumber num2) {
        double resultReal = num1.getReal() * num2.getReal() - num1.getImaginary() * num2.getImaginary();
        double resultImaginary = num1.getReal() * num2.getImaginary() + num1.getImaginary() * num2.getReal();
        return new ComplexNumber(resultReal, resultImaginary);
    }

    @Override
    public String getOperationName() {
        return operationName;
    }

    @Override
    public String toString() {
        return "Результат " + operationName + ": ";
    }
}

// Класс для деления комплексных чисел
class ComplexDivision extends ComplexOperation {
    public ComplexDivision() {
        operationName = "деления комплексных чисел";
    }

    @Override
    public ComplexNumber execute(ComplexNumber num1, ComplexNumber num2) {
        double denominator = num2.getReal() * num2.getReal() + num2.getImaginary() * num2.getImaginary();
        double resultReal = (num1.getReal() * num2.getReal() + num1.getImaginary() * num2.getImaginary()) / denominator;
        double resultImaginary = (num1.getImaginary() * num2.getReal() - num1.getReal() * num2.getImaginary()) / denominator;
        return new ComplexNumber(resultReal, resultImaginary);
    }

    @Override
    public String getOperationName() {
        return operationName;
    }

    @Override
    public String toString() {
        return "Результат " + operationName + ": ";
    }
}

package object_oriented_java_programming.seminar4.homework;

import java.util.List;

public class Calculator {

    /**
     * @param numbers - массив всех чисел
     * @return - сумма всех чисел
     * @apiNote - 3) Написать класс калькулятор, принимающий
     * List целочисленных значений,
     * возвращающий сумму элементов коллекции (метод sum)
     */

     public Double sum(List<? extends Number> numbers) {
        Double res = 0.0;
        for (Number number : numbers) {
            res += number.doubleValue();
        }
        return res;
    }

    /**
     * @param numbers - массив всех чисел
     * @return - произведение всех чисел
     * @apiNote - Расширяем класс калькулятор на умножение
     */

     public Double multiply(List<? extends Number> numbers) {
        Double res = 1.0;
        for (Number number : numbers) {
            res *= number.doubleValue();
        }
        return res;
    }

    /**
     * @param dividend - делимое
     * @param divisor  - делитель
     * @return - результат деления
     * @apiNote - Расширяем класс калькулятор на деление
     */

    public Double divide(Number dividend, Number divisor) {
        if (divisor.doubleValue() == 0) {
            throw new IllegalArgumentException("Не может быть нулем");
        }
        return dividend.doubleValue() / divisor.doubleValue();
    }

    /**
     * @param input - входное значение как String или Integer
     * @return - строковое представление бинарного значения числа
     * @apiNote - Расширяем класс калькулятор на бинарный перевод (принимаемые значения как String, так и Integer)
     */

     public String binaryConvert(Object input) {
        if (input instanceof String) {
            int num = Integer.parseInt((String) input);
            return Integer.toBinaryString(num);
        } else if (input instanceof Integer) {
            return Integer.toBinaryString((Integer) input);
        } else {
            throw new IllegalArgumentException("Не поддерживается тип ввода. Разрашены только число или строка.");
        }
    }
}

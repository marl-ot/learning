package object_oriented_java_programming.seminar4.classwork;

import java.util.List;

public class Calculator {

    /**
     * @param numbers - массив всех чисел
     * @resturn - сумма всех чисел
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
}

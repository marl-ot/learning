package object_oriented_java_programming.seminar4.classwork;

import java.util.ArrayList;
import java.util.List;

public class Main {
    // 3) Написать класс калькулятор, принимающий 
    // List целочисленных значений,
    // возвращающий сумму элементов коллекции (метод sum)
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        List<Double> doubleList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            doubleList.add((double) i);
            integerList.add(i);
        }
        System.out.println("calc.sum(doubleList) = " + calc.sum(doubleList));
        System.out.println("calc.sum(integerList) = " + calc.sum(integerList));
    }
}

package object_oriented_java_programming.seminar4.homework;

import java.util.ArrayList;
import java.util.List;

public class Main {
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

        System.out.println("calc.multiply(doubleList) = " + calc.multiply(doubleList));
        System.out.println("calc.multiply(integerList) = " + calc.multiply(integerList));

        Double result = calc.divide(10.0, 2.0);
        System.out.println("calc.divide(10.0, 2.0) = " + result);

        String binaryStr1 = calc.binaryConvert(10);
        String binaryStr2 = calc.binaryConvert("20");
        System.out.println("Binary representation of 10: " + binaryStr1);
        System.out.println("Binary representation of 20: " + binaryStr2);
    }
}
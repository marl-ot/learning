package knowledge_to_java.seminar3;

import java.util.ArrayList;

public class ArrayListMinMaxAverage4 {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(5);
        numbers.add(8);
        numbers.add(12);
        numbers.add(3);

        int min = findMin(numbers);
        int max = findMax(numbers);
        double average = findAverage(numbers);

        System.out.println("Минимальное значение: " + min);
        System.out.println("Максимальное значение: " + max);
        System.out.println("Среднее значение: " + average);
    }

    public static int findMin(ArrayList<Integer> numbers) {
        int min = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            if (currentNumber < min) {
                min = currentNumber;
            }
        }
        return min;
    }

    public static int findMax(ArrayList<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            if (currentNumber > max) {
                max = currentNumber;
            }
        }
        return max;
    }

    public static double findAverage(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.size();
    }
}
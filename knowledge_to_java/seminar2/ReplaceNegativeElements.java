package knowledge_to_java.seminar2;

// Дан массив целых чисел. Заменить отрицательные элементы на сумму 
// индексов двузначных элементов массива.

public class ReplaceNegativeElements {
    public static void main(String[] args) {
        int[] array = { 10, -5, 25, -8, 15, -12, 20 };

        int sumOfIndices = calculateSumOfIndices(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = sumOfIndices;
            }
        }

        System.out.println("Массив после замены:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static int calculateSumOfIndices(int[] array) {
        int sum = 0;

        for (int j = 0; j < array.length; j++) {
            if (isTwoDigitNumber(array[j])) {
                sum += j;
            }
        }
        return sum;
    }

    public static boolean isTwoDigitNumber(int number) {
        return (number >= 10 & number <= 99) | (-number >= 10 & -number <= 99);
    }
}

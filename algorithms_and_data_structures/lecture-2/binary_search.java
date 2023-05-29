public class binary_search {
    public static void main(String[] args) {
        int[] array = new int[] {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        };

        System.out.println(binary_searching(array, 5, 0, array.length - 1));
    }

    public static int binary_searching(int[] array, int value, int min, int max) {
        int midpoint;

        if (max < min) {
            return -1;
        } else {
            midpoint = (max - min) / 2 + min;
        }

        if (array[midpoint] < value) {
            return binary_searching(array, value, midpoint + 1, max);
        } else {
            if (array[midpoint] > value) {
                return binary_searching(array, value, min, midpoint - 1);
            } else {
                return midpoint;
            }
        }
    }
}

public class selection_sort {
    public static void main(String[] args) {
        int[] array = new int[] {
                4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5
        };

        selection_sorting(array);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void selection_sorting(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min_position = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min_position]) {
                    min_position = j;
                }
            }
            if (i != min_position) {
                int temp = array[i];
                array[i] = array[min_position];
                array[min_position] = temp;
            }
        }
    }
}

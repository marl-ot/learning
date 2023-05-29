public class quick_sort {
    public static void main(String[] args) {
        // int[] array = new int[] {
        //     4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5
        // };

        // System.out.print(array);
        // System.out.print(quick_sorting(array, 0, array.length-1));
        // System.out.print(array);
    }

    public static void quick_sorting(int[] array, int start_position, int end_position) {
        int left_position = start_position;
        int right_position = end_position;
        int pivot = array[(start_position + end_position) / 2];
        do {
            while (array[left_position] < pivot) {
                left_position++;
            }
            while (array[right_position] > pivot) {
                right_position--;
            }
            if (left_position <= right_position) {
                if (left_position < right_position) {
                    int temp = array[left_position];
                    array[left_position] = array[right_position];
                    array[right_position] = temp;
                }
                left_position++;
                right_position--;
            }
        } while (left_position <= right_position);

        if (left_position < end_position){
            quick_sorting(array, left_position, end_position);
        }
        if (start_position < right_position){
            quick_sorting(array, start_position, right_position);
        }
    }
}

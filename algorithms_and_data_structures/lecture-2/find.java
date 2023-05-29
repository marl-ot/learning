public class find {
    public static void main(String[] args) {
        int[] array = new int[] {
                4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5
        };

        System.out.println(finding(array, 5));
        
    }

    public static int finding(int[] array, int value) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value){
                return i;
            }
        }
        return -1;
    }
}

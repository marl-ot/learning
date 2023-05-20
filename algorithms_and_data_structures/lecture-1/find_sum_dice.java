// Задача поиска шанса выпадения определенной суммы на игральный костях

public class find_sum_dice {
    public static void main(String[] args){
        System.out.println(findSum(5));
    }
    public static double findSum(int sum) {
        int count = 0;
        int successResult = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (i + j + k == sum) {
                        successResult++;
                    }
                    count++;
                }
            }
        }
        return ((double) successResult) / ((double) count);
    }
}

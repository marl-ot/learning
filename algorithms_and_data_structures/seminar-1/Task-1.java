public class Task 1 {
    public static void main(String[] args){
        System.out.println(findSumOfArray(n:10));
    }

    public static int findSumOfArray(int n){
        int result = 0;
        for (int i = 1; i <= n; i++) result += i;
        return result;
    }
}
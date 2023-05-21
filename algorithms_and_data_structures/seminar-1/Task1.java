public class Task1 {
    public static void main(String[] args){
        System.out.println(findSumOfArray(10));
    }
    public static int findSumOfArray(int n){
        int result = 0;
        for (int i = 1; i <= n; i++) result += i;
        return result;
    }
}
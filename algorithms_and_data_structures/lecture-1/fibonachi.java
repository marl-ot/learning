public class fibonachi {
    public static void main(String[] args){
        System.out.println(fib(15));
    }
    public static int fib(int position) {
        if (position == 1) {
            return 0;
        }
        if (position == 2) {
            return 1;
        }
        return fib(position - 1) + fib(position - 2);
    }
}

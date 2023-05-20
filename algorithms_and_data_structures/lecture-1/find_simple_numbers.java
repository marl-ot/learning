import java.util.ArrayList;
import java.util.List;

public class find_simple_numbers {
    public static void main(String[] args){
        System.out.println(findSimpleNumbers(20));
    }
    public static List<Integer> findSimpleNumbers(int max) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        return result;
    }
}

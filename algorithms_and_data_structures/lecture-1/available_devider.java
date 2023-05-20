import java.util.ArrayList;
import java.util.List;

public class available_devider {
    public static void main(String[] args){
        System.out.println(availableDevider(15));
    }
    public static List<Integer> availableDevider(int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }
        return result;
    }
}

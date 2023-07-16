package object_oriented_java_programming.seminar3;

import java.util.ArrayList;
import java.util.List;

public class NumWordGame extends AbstractGame {
    @Override
    List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            result.add(String.valueOf(i));
        }
        return result;
    }
}
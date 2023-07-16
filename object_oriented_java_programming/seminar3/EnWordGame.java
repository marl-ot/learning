package object_oriented_java_programming.seminar3;

import java.util.ArrayList;
import java.util.List;

public class EnWordGame extends AbstractGame {
    @Override
    List<String> generateCharList() {
        List<String> result = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            result.add(String.valueOf(ch));
        }
        return result;
    }
}

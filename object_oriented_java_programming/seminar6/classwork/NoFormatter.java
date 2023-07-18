package object_oriented_java_programming.seminar6.classwork;

import java.util.List;

public class NoFormatter implements Formatter{
    @Override
    public void formatted(List<Book> books) {
        for (Book book : books) {
            System.out.println(book + " была переведенна в формат: " + Format.NOFORMAT);
        }
    }
}

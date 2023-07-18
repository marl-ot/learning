package object_oriented_java_programming.seminar6.classwork;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Lib libLib = new Lib(Arrays.asList(
                new Book("qwe", "Ваня", 1995, new BookGenre("комедия")),
                new Book("qwe2", "Петя", 2000, new BookGenre("триллер")),
                new Book("qwe3", "Коля", 2008, new BookGenre("триллер"))));

        System.out.println("libLib.searcAutor(\"qwe\") = " + libLib.searcAutor("Ваня"));
        System.out.println("libLib.searcAutor(\"qwe\") = " + libLib.searcAutor("Коля"));

        Formatter formatter = new JsonFormatter();
        formatter.formatted(libLib.getBooks());
    }
}
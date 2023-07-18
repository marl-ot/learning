package object_oriented_java_programming.seminar6.classwork;

import java.util.ArrayList;
import java.util.List;

public class Lib implements Searchable{
    List<Book> books;

    public Lib(List<Book> books) {
        this.books = books;
    }
    public Lib() {
    }
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
    @Override
    public List<Book> searcAutor(String autorName) {
        List<Book> resBook = new ArrayList<>();
        for (Book book : books) {
            if(book.getAutor().equals(autorName)){
                resBook.add(book);
            }
        }
        return resBook;
    }
}

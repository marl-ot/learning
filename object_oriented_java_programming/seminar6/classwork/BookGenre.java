package object_oriented_java_programming.seminar6.classwork;
public class BookGenre implements Genre{
    String genre;

    public BookGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String getJanrName() {
        return genre;
    }

    @Override
    public String toString() {
        return genre;
    }
}
package object_oriented_java_programming.seminar6.classwork;

public class ElectronBook extends Book{
    String format;
    Integer size;

    public ElectronBook(String name, String autor, int age, String format, int size, BookGenre bookGenre) {
        super(name, autor, age, bookGenre);
        this.format = format;
        this.size = size;
    }

    public ElectronBook(String format, int size) {
        this.format = format;
        this.size = size;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

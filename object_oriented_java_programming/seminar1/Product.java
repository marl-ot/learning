package object_oriented_java_programming.seminar1;


// Создать класс Товар, имеющий переменные имя, цена, рейтинг.

public class Product {
    private String name;
    private double price;
    private int rating;

    public Product(String name, double price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    // Геттеры и сеттеры для переменных класса
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public static void main(String[] args) {
        // Пример использования класса
        Product product = new Product("Ноутбук", 1500.0, 4);
        System.out.println("Название товара: " + product.getName());
        System.out.println("Цена товара: " + product.getPrice());
        System.out.println("Рейтинг товара: " + product.getRating());
    }
}











package object_oriented_java_programming.seminar1;

// Создать класс Категория, имеющий переменные имя и массив товаров. Создать несколько объектов класса Категория.

public class Category {
    private String name;
    private Product[] products;

    public Category(String name, Product[] products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public Product[] getProducts() {
        return products;
    }

    public static void main(String[] args) {
        // Пример использования класса
        Product laptop = new Product("Ноутбук", 1500.0, 4);
        Product smartphone = new Product("Смартфон", 800.0, 5);

        Product[] electronics = { laptop, smartphone };
        Category electronicsCategory = new Category("Электроника", electronics);

        System.out.println("Категория: " + electronicsCategory.getName());
        System.out.println("Товары в категории:");

        for (Product product : electronicsCategory.getProducts()) {
            System.out.println("Название товара: " + product.getName());
            System.out.println("Цена товара: $" + product.getPrice());
            System.out.println("Рейтинг товара: " + product.getRating());
            System.out.println("----------------------");
        }
    }
}

package object_oriented_java_programming.seminar1;

// Создать класс Basket, содержащий массив купленных товаров.

public class Basket {
    private Product[] products;

    public Basket(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    public static void main(String[] args) {
        // Пример использования класса
        Product laptop = new Product("Ноутбук", 1500.0, 4);
        Product smartphone = new Product("Смартфон", 800.0, 5);
        Product headphones = new Product("Наушники", 100.0, 4);

        Product[] purchasedProducts = { laptop, smartphone, headphones };
        Basket basket = new Basket(purchasedProducts);

        System.out.println("Товары в корзине:");

        for (Product product : basket.getProducts()) {
            System.out.println("Название товара: " + product.getName());
            System.out.println("Цена товара: $" + product.getPrice());
            System.out.println("Рейтинг товара: " + product.getRating());
            System.out.println("----------------------");
        }
    }
}

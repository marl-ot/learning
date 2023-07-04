package object_oriented_java_programming.seminar1;

// Вывести на консоль каталог продуктов. (все продукты магазина)

public class Store {
    private Product[] products;

    public Store(Product[] products) {
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

        Product[] allProducts = { laptop, smartphone, headphones };
        Store store = new Store(allProducts);

        System.out.println("Каталог продуктов в магазине:");

        for (Product product : store.getProducts()) {
            System.out.println("Название товара: " + product.getName());
            System.out.println("Цена товара: $" + product.getPrice());
            System.out.println("Рейтинг товара: " + product.getRating());
            System.out.println("----------------------");
        }
    }
}

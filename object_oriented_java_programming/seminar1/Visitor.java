package object_oriented_java_programming.seminar1;

import java.util.ArrayList;
import java.util.List;

// Вывести на консоль покупки посетителей магазина. (После покупки у пользователя добавляется товар, а из магазина - удаляется)


public class Store {
    private List<Product> products;

    public Store() {
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }
}

public class Visitor {
    private String name;
    private Basket basket;

    public Visitor(String name) {
        this.name = name;
        this.basket = new Basket(null);
    }

    public String getName() {
        return name;
    }

    public Basket getBasket() {
        return basket;
    }

    public void addToBasket(Product product) {
        basket.addProduct(product);
    }

    public void removeFromBasket(Product product) {
        basket.removeProduct(product);
    }

    public static void main(String[] args) {
        // Пример использования классов
        Store store = new Store();

        Product laptop = new Product("Ноутбук", 1500.0, 4);
        Product smartphone = new Product("Смартфон", 800.0, 5);
        Product headphones = new Product("Наушники", 100.0, 4);

        store.addProduct(laptop);
        store.addProduct(smartphone);
        store.addProduct(headphones);

        Visitor visitor1 = new Visitor("Посетитель 1");
        Visitor visitor2 = new Visitor("Посетитель 2");

        visitor1.addToBasket(laptop);
        visitor1.addToBasket(smartphone);

        visitor2.addToBasket(headphones);

        System.out.println("Покупки посетителя 1 (" + visitor1.getName() + "):");
        for (Product product : visitor1.getBasket().getProducts()) {
            System.out.println("Название товара: " + product.getName());
            System.out.println("Цена товара: $" + product.getPrice());
            System.out.println("Рейтинг товара: " + product.getRating());
            System.out.println("----------------------");

            store.removeProduct(product);
        }

        System.out.println("Покупки посетителя 2 (" + visitor2.getName() + "):");
        for (Product product : visitor2.getBasket().getProducts()) {
            System.out.println("Название товара: " + product.getName());
            System.out.println("Цена товара: $" + product.getPrice());
            System.out.println("Рейтинг товара: " + product.getRating());
            System.out.println("----------------------");

            store.removeProduct(product);
        }

        System.out.println("Оставшиеся товары в магазине:");
        for (Product product : store.getProducts()) {
            System.out.println("Название товара: " + product.getName());
            System.out.println("Цена товара: $" + product.getPrice());
            System.out.println("Рейтинг товара: " + product.getRating());
            System.out.println("----------------------");
        }
    }
}

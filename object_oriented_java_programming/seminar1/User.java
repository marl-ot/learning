package object_oriented_java_programming.seminar1;

// Создать класс User, содержащий логин, пароль и объект класса Basket. Создать несколько объектов класса User.

public class User {
    private String login;
    private String password;
    private Basket basket;

    public User(String login, String password, Basket basket) {
        this.login = login;
        this.password = password;
        this.basket = basket;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Basket getBasket() {
        return basket;
    }

    public static void main(String[] args) {
        // Пример использования класса
        Product laptop = new Product("Ноутбук", 1500.0, 4);
        Product smartphone = new Product("Смартфон", 800.0, 5);
        Product headphones = new Product("Наушники", 100.0, 4);

        Product[] purchasedProducts = { laptop, smartphone, headphones };
        Basket basket = new Basket(purchasedProducts);

        User user1 = new User("user1", "password1", basket);
        User user2 = new User("user2", "password2", basket);

        System.out.println("Пользователь 1:");
        System.out.println("Логин: " + user1.getLogin());
        System.out.println("Пароль: " + user1.getPassword());
        System.out.println("Товары в корзине пользователя 1:");

        for (Product product : user1.getBasket().getProducts()) {
            System.out.println("Название товара: " + product.getName());
            System.out.println("Цена товара: $" + product.getPrice());
            System.out.println("Рейтинг товара: " + product.getRating());
            System.out.println("----------------------");
        }

        System.out.println("Пользователь 2:");
        System.out.println("Логин: " + user2.getLogin());
        System.out.println("Пароль: " + user2.getPassword());
        System.out.println("Товары в корзине пользователя 2:");

        for (Product product : user2.getBasket().getProducts()) {
            System.out.println("Название товара: " + product.getName());
            System.out.println("Цена товара: $" + product.getPrice());
            System.out.println("Рейтинг товара: " + product.getRating());
            System.out.println("----------------------");
        }
    }
}

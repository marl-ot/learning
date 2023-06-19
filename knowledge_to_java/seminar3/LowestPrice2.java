package knowledge_to_java.seminar3;

// Сведения о товаре состоят из наименования, страны-производителя, веса, цены, сорта. 
// Получить наименования товаров заданного сорта с наименьшей ценой.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LowestPrice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Заданный массив товаров
        String[][] products = {
                { "Помидоры", "Азербайджан", "1", "100.0", "Сорт A" },
                { "Помидоры", "Россия, Краснодарский край", "1", "80.0", "Сорт B" },
                { "Кукуруза", "Россия, Краснодарский край", "1", "90.0", "Сорт A" },
                { "Кукуруза", "Израиль", "1", "85.0", "Сорт B" },
                { "Яблоки", "Россия, Московская область", "1", "120.0", "Сорт A" }
        };

        System.out.print("Введите заданный сорт товара: ");
        String targetSort = scanner.nextLine();

        List<String> lowestPriceProducts = findLowestPriceProducts(products, targetSort);

        System.out.println("Наименования товаров с наименьшей ценой для сорта \"" + targetSort + "\":");
        for (String product : lowestPriceProducts) {
            System.out.println(product);
        }
    }

    public static List<String> findLowestPriceProducts(String[][] products, String targetSort) {
        List<String> lowestPriceProducts = new ArrayList<>();
        double lowestPrice = Double.MAX_VALUE;

        for (String[] product : products) {
            String name = product[0];
            String sort = product[4];
            double price = Double.parseDouble(product[3]);

            if (sort.equals(targetSort)) {
                if (price < lowestPrice) {
                    lowestPrice = price;
                    lowestPriceProducts.clear();
                    lowestPriceProducts.add(name);
                } else if (price == lowestPrice) {
                    lowestPriceProducts.add(name);
                }
            }
        }

        return lowestPriceProducts;
    }
}
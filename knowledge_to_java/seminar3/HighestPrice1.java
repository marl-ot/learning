package knowledge_to_java.seminar3;

// Дан массив записей: наименование товара, цена, сорт. Найти наибольшую цену 
// товаров 1го или 2-го сорта среди товаров, название которых содержит «высший».

public class HighestPrice1 {
    public static void main(String[] args) {

        String[][] products = {
            { "Яблоко", "100", "1-й сорт" },
            { "Молоко высший", "150", "1-й сорт" },
            { "Помидор высший", "200", "2-й сорт" },
            { "Кукуруза", "180", "2-й сорт" },
            { "Персик высший", "250", "1-й сорт" }
        };

        double maxPrice = findMaxPrice(products);

        System.out.println(
                "Наибольшая цена товаров 1-го или 2-го сорта среди товаров, название которых содержит 'высший': "
                        + maxPrice);
    }

    public static double findMaxPrice(String[][] products) {
        double maxPrice = 0;

        for (String[] product : products) {
            String name = product[0];
            double price = Double.parseDouble(product[1]);
            String sort = product[2];

            if (sort.equals("1-й сорт") || sort.equals("2-й сорт")) {
                if (name.contains("высший") && price > maxPrice) {
                    maxPrice = price;
                }
            }
        }

        return maxPrice;
    }
}

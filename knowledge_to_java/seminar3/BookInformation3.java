package knowledge_to_java.seminar3;

import java.util.ArrayList;
import java.util.List;

//  Сведения о книге состоят из названия, фамилии автора, цены, года издания и количества страниц. 
// Найти названия книг, в которых простое количество страниц, фамилия автора содержит «А» и год издания после 2010 г, включительно.

public class BookInformation3 {
    public static void main(String[] args) {
        // Заданный массив книг
        String[][] books = {
            {"Война и мир", "Лев Толстой", "1001.0", "2015", "120"},
            {"Лолита", "Владимир Набоков", "1003.0", "2012", "150"},
            {"Капитал", "Карл Маркс", "970.0", "2014", "101"},
            {"Приключения Гекльберри Финна", "Марк Твен", "400.0", "2018", "200"},
            {"Искусство программирвоания", "Дональд Эрвин Кнут", "1510.0", "2013", "1001"}
        };

        List<String> selectedBooks = findSelectedBooks(books);

        System.out.println("Названия книг, удовлетворяющих условиям:");
        for (String book : selectedBooks) {
            System.out.println(book);
        }
    }

    public static List<String> findSelectedBooks(String[][] books) {
        List<String> selectedBooks = new ArrayList<>();

        for (String[] book : books) {
            String title = book[0];
            String author = book[1];
            int year = Integer.parseInt(book[3]);
            int pages = Integer.parseInt(book[4]);

            if (isPrimeNumber(pages) & (author.contains("А") | author.contains("а")) & year >= 2010) {
                selectedBooks.add(title);
            }
        }

        return selectedBooks;
    }

    public static boolean isPrimeNumber(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}

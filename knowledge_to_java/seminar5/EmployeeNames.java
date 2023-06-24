package knowledge_to_java.seminar5;

import java.util.*;

public class EmployeeNames {
    public static void main(String[] args) {
        List<String> employeeList = Arrays.asList(
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"
        );

        Map<String, Integer> nameCountMap = new HashMap<>();

        // Подсчитываем количество повторений каждого имени
        for (String employee : employeeList) {
            String firstName = employee.split(" ")[0]; // Получаем имя сотрудника

            nameCountMap.put(firstName, nameCountMap.getOrDefault(firstName, 0) + 1);
        }

        // Сортируем имена по убыванию популярности
        List<Map.Entry<String, Integer>> sortedNames = new ArrayList<>(nameCountMap.entrySet());
        sortedNames.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Выводим повторяющиеся имена с количеством повторений
        System.out.println("Повторяющиеся имена:");
        for (Map.Entry<String, Integer> entry : sortedNames) {
            if (entry.getValue() >= 1) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }
}

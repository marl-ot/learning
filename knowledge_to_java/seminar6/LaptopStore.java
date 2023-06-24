package knowledge_to_java.seminar6;

import java.util.*;

class Laptop {
    private String model;
    private int ram;
    private int storage;
    private String os;
    private String color;

    public Laptop(String model, int ram, int storage, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.storage = storage;
        this.os = os;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }
}

public class LaptopStore {
    public static void main(String[] args) {
        // Создание множества ноутбуков
        Set<Laptop> notebooks = new HashSet<>();
        notebooks.add(new Laptop("HP Pavilion", 8, 512, "Windows 10", "Silver"));
        notebooks.add(new Laptop("Dell XPS", 16, 1024, "Windows 10", "Black"));
        notebooks.add(new Laptop("Lenovo ThinkPad", 8, 256, "Windows 10", "Black"));
        notebooks.add(new Laptop("Apple MacBook Pro", 16, 512, "macOS", "Space Gray"));
        notebooks.add(new Laptop("Asus ZenBook", 16, 512, "Windows 10", "Blue"));

        // Создание критериев фильтрации
        Map<Integer, Object> filters = new HashMap<>();
        filters.put(1, 8); // ОЗУ = 8
        filters.put(2, 512); // Объем ЖД = 512

        // Запрос минимальных значений для критериев фильтрации
        Scanner scanner = new Scanner(System.in);
        for (Integer filter : filters.keySet()) {
            System.out.print("Введите минимальное значение для критерия " + filter + ": ");
            int minValue = scanner.nextInt();
            filters.put(filter, minValue);
        }

        // Фильтрация ноутбуков и вывод результатов
        Set<Laptop> filteredLaptops = filterLaptops(notebooks, filters);
        if (filteredLaptops.isEmpty()) {
            System.out.println("Ноутбуки, отвечающие заданным критериям, не найдены.");
        } else {
            System.out.println("Ноутбуки, отвечающие заданным критериям:");
            for (Laptop notebook : filteredLaptops) {
                System.out.println(notebook.getModel());
            }
        }
    }

    public static Set<Laptop> filterLaptops(Set<Laptop> notebooks, Map<Integer, Object> filters) {
        Set<Laptop> filteredSet = new HashSet<>();

        for (Laptop notebook : notebooks) {
            boolean satisfiesCriteria = true;

            for (Map.Entry<Integer, Object> entry : filters.entrySet()) {
                int filter = entry.getKey();
                Object filterValue = entry.getValue();

                if (!matchesCriteria(notebook, filter, filterValue)) {
                    satisfiesCriteria = false;
                    break;
                }
            }

            if (satisfiesCriteria) {
                filteredSet.add(notebook);
            }
        }

        return filteredSet;
    }

    public static boolean matchesCriteria(Laptop notebook, int filter, Object filterValue) {
        switch (filter) {
            case 1: // ОЗУ
                return notebook.getRam() >= (int) filterValue;
            case 2: // Объем ЖД
                return notebook.getStorage() >= (int) filterValue;
            case 3: // Операционная система
                return notebook.getOs().equalsIgnoreCase((String) filterValue);
            case 4: // Цвет
                return notebook.getColor().equalsIgnoreCase((String) filterValue);
            default:
                return false;
        }
    }
}


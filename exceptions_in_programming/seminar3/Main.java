package exceptions_in_programming.seminar3;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(System.out, true, "Cp866"));

            Map<String, List<String>> dataMap = new TreeMap<>();

            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Введите данные в формате: Фамилия Имя Отчество, дата рождения (dd.mm.yyyy), номер телефона, пол (f/m)");
                String input = scanner.nextLine();

                String[] data = input.split(", ");
                if (data.length != 4) {
                    throw new InputMismatchException("Неверное количество данных. Введите Фамилия Имя Отчество, дата рождения, номер телефона, пол (f/m).");
                }

                String[] fullName = data[0].split(" ");
                if (fullName.length != 3) {
                    throw new InputMismatchException("Неверное количество данных в ФИО. Введите Фамилия Имя Отчество через пробел.");
                }

                String surname = fullName[0];
                String name = fullName[1];
                String patronymic = fullName[2];
                String dateOfBirth = data[1];
                String phone = data[2];
                String gender = data[3];

                if (!isValidDate(dateOfBirth)) {
                    throw new IllegalArgumentException("Неверный формат даты рождения. Используйте формат dd.mm.yyyy.");
                }

                if (!isValidPhone(phone)) {
                    throw new IllegalArgumentException("Неверный формат номера телефона. Используйте целое беззнаковое число без форматирования.");
                }

                if (!isValidGender(gender)) {
                    throw new IllegalArgumentException("Неверный формат пола. Используйте 'f' или 'm'.");
                }

                String formattedData = formatData(surname, name, patronymic, dateOfBirth, phone, gender);
                String fileName = surname + ".txt";

                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), "UTF-8"))) {
                    writer.write(formattedData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Данные успешно записаны в файл " + fileName);
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private static boolean isValidDate(String date) {
        return date.matches("([0-2][0-9]|3[0-1])\\.(0[1-9]|1[0-2])\\.(\\d{4})");
    }

    private static boolean isValidPhone(String phone) {
        return phone.matches("\\d+");
    }

    private static boolean isValidGender(String gender) {
        return gender.equals("f") || gender.equals("m");
    }

    private static String formatData(String surname, String name, String patronymic, String dateOfBirth, String phone, String gender) {
        return surname + " " + name + " " + patronymic + ", " + dateOfBirth + ", " + phone + ", " + gender + "\n";
    }
}
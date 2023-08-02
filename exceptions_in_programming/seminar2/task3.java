public static void main(String[] args) {
    try {
        int a = 90;
        int b = 3;
        System.out.println(a / b);
        printSum(23, 234);
        int[] abc = { 1, 2 };
        // Для избежания ArrayIndexOutOfBoundsException проверяем, что индекс существует
        if (abc.length > 3) {
            abc[3] = 9;
        } else {
            System.out.println("Ошибка: Индекс выходит за пределы массива!");
        }
    } catch (Throwable ex) {
        System.out.println("Что-то пошло не так...");
    } catch (NullPointerException ex) {
        System.out.println("Указатель не может указывать на null!");
    } catch (IndexOutOfBoundsException ex) {
        System.out.println("Массив выходит за пределы своего размера!");
    }
}

public static void printSum(Integer a, Integer b) {
    System.out.println(a + b);
}


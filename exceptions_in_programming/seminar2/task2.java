public static void main(String[] args) {
    try {
        int d = 0;
        double catchedRes1;
        if (d != 0) {
            catchedRes1 = (double) intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } else {
            System.out.println("Ошибка: Деление на ноль недопустимо!");
        }
    } catch (ArithmeticException e) {
        System.out.println("Catching exception: " + e);
    }
}


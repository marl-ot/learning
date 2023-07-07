package object_oriented_java_programming.seminar2;

class Human {
    public void run() {
        System.out.println("Человек бежит");
    }
    
    public void jump() {
        System.out.println("Человек прыгает");
    }
}

class Cat {
    public void run() {
        System.out.println("Кошка бежит");
    }
    
    public void jump() {
        System.out.println("Кошка прыгает");
    }
}

class Robot {
    public void run() {
        System.out.println("Робот бежит");
    }
    
    public void jump() {
        System.out.println("Робот прыгает");
    }
}

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        Cat cat = new Cat();
        Robot robot = new Robot();
        
        human.run();
        human.jump();
        
        cat.run();
        cat.jump();
        
        robot.run();
        robot.jump();
    }
}


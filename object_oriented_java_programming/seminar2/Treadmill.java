package object_oriented_java_programming.seminar2;

class Treadmill {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}

class Wall {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }
}

class Participant {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;

    public Participant(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    public void run(Treadmill treadmill) {
        int length = treadmill.getLength();
        if (length <= maxRunDistance) {
            System.out.println(name + " успешно пробежал по беговой дорожке");
        } else {
            System.out.println(name + " не смог пробежать дорожку");
        }
    }

    public void jump(Wall wall) {
        int height = wall.getHeight();
        if (height <= maxJumpHeight) {
            System.out.println(name + " успешно перебрыгнул стену");
        } else {
            System.out.println(name + " не смог перепрыгнуть стену");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Treadmill treadmill = new Treadmill(100);
        Wall wall = new Wall(50);

        Participant participant1 = new Participant("Ваня", 120, 60);
        Participant participant2 = new Participant("Варя", 80, 70);

        participant1.run(treadmill);
        participant1.jump(wall);

        participant2.run(treadmill);
        participant2.jump(wall);
    }
}


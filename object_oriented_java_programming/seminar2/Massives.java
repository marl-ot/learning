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
            System.out.println(name + " успешно пробежал дорожку длиной " + length);
        } else {
            System.out.println(name + " не смог пробежать дорожку длиной " + length);
            throw new RuntimeException(name + " выбыл");
        }
    }

    public void jump(Wall wall) {
        int height = wall.getHeight();
        if (height <= maxJumpHeight) {
            System.out.println(name + " успешно перепрыгнул стену высотой " + height);
        } else {
            System.out.println(name + " не смог перепрыгнуть стену высотой " + height);
            throw new RuntimeException(name + " выбыл");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Treadmill[] treadmills = {
            new Treadmill(100),
            new Treadmill(200),
            new Treadmill(150)
        };

        Wall[] walls = {
            new Wall(50),
            new Wall(100),
            new Wall(80)
        };

        Participant[] participants = {
            new Participant("Ваня", 120, 60),
            new Participant("Варя", 80, 70),
            new Participant("Петя", 150, 90)
        };

        for (Participant participant : participants) {
            boolean passedAllObstacles = true;

            for (Treadmill treadmill : treadmills) {
                try {
                    participant.run(treadmill);
                } catch (RuntimeException e) {
                    passedAllObstacles = false;
                    break;
                }
            }

            if (passedAllObstacles) {
                for (Wall wall : walls) {
                    try {
                        participant.jump(wall);
                    } catch (RuntimeException e) {
                        break;
                    }
                }
            }
        }
    }
}


package ru.geekBrains.lesson1;

public class Test1 {


    public static void main(String[] args) {

        Cat cat = new Cat (5, 300);
        Robot robot = new Robot(1000, 10000000);
        Human human = new Human(10,500);
        Wall wall = new Wall(100);
        Treadmill treadmill = new Treadmill(5000);


        Jump[] jumpParticipants = {cat, human, robot};
        Run[] runParticipants = {cat, human, robot};

        Object[] obstacles = {wall, treadmill};

        for (int i = 0; i < jumpParticipants.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j] instanceof Wall) {
                    jumpParticipants[i].jump((Wall) obstacles[j]);
                }
                else continue;
            }
        }

        for (int i = 0; i < runParticipants.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if (obstacles[j] instanceof Treadmill) {
                    runParticipants[i].run((Treadmill) obstacles[j]);
                }
                else continue;
            }
        }

    }
}

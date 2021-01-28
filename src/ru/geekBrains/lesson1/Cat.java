package ru.geekBrains.lesson1;

public class Cat implements Jump, Run {

    private int jumpHeight;
    private  int distanceLimit;

    public Cat(int jumpHeight, int distanceLimit) {
        this.jumpHeight = jumpHeight;
        this.distanceLimit = distanceLimit;
    }

    @Override
    public void jump (Wall wall) {
        if (wall.getHeight() < this.jumpHeight) {
            System.out.println("кот перепрыгнул!");
        }
        else System.out.println("кот не перепрыгнул!");
    }

    @Override
    public void run (Treadmill treadmill) {
        if (treadmill.getDistance() < this.distanceLimit) {
            System.out.println("кот пробежал");
        }
        else System.out.println("кот не пробежал");
    }

    @Override
    public String toString() {
        return "Cat{}";
    }
}

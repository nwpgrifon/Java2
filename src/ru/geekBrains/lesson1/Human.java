package ru.geekBrains.lesson1;

public class Human implements Jump, Run {

    private int jumpHeight;
    private  int distanceLimit;


    public Human(int jumpHeight, int distanceLimit) {
        this.jumpHeight = jumpHeight;
        this.distanceLimit = distanceLimit;
    }

    public void jump (Wall wall) {
        if (wall.getHeight() < this.jumpHeight) {
            System.out.println("человек перепрыгнул!");
        }
        else System.out.println("человек не перепрыгнул!");
    }

    @Override
    public void run (Treadmill treadmill) {
        if (treadmill.getDistance() < this.distanceLimit) {
            System.out.println("человек пробежал");
        }
        else System.out.println("человек не пробежал");
    }
}

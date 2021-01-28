package ru.geekBrains.lesson1;


public class Robot implements Jump, Run {

    private int jumpHeight;
    private  int distanceLimit;

    public Robot(int jumpHeight, int distanceLimit) {
        this.jumpHeight = jumpHeight;
        this.distanceLimit = distanceLimit;
    }

    public void jump (Wall wall) {
        if (wall.getHeight() < this.jumpHeight) {
            System.out.println("робот перепрыгнул!");
        }
        else System.out.println("робот не перепрыгнул!");
    }

    @Override
    public void run (Treadmill treadmill) {
        if (treadmill.getDistance() < this.distanceLimit) {
            System.out.println("робот пробежал");
        }
        else System.out.println("робот не пробежал");
    }
}

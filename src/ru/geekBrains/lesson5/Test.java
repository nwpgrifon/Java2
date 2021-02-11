package ru.geekBrains.lesson5;

public class Test {

    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) {



        fooSimple();

//        fooComplicated();


    }

    private static void fooComplicated() {
        float[] arr = new float[size];

        long time = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long fillArrayTime = (System.currentTimeMillis() - time);

        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < a1.length; i++) {
                a1[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < a2.length; i++) {
                a2[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });

        t1.start();
        t2.start();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        long end = (System.currentTimeMillis() - time);

        System.out.println(fillArrayTime);
        System.out.println(end);


    }

    private static void fooSimple() {

        float[] arr = new float[size];

        long time = System.currentTimeMillis();
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long fillArrayTime = (System.currentTimeMillis() - time);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long end = (System.currentTimeMillis() - time);

        System.out.println(fillArrayTime);

        System.out.println(end);
    }

}

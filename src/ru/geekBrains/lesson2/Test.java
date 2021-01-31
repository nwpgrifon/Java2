package ru.geekBrains.lesson2;

import com.sun.jdi.CharType;

import java.awt.*;
import java.io.EOFException;

public class Test {

    public static void main(String[] args)  {

        String[][] myArr1 = {{"1", "1", "5", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "1"}, {"1", "1", "1", "5"}};
        foo(myArr1);
    }

    private static void foo(String[][] myArr1) {
        try {
            checkSize(myArr1);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(checkTypeAndSum(myArr1));;
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static void checkSize(String[][] myArr) throws MyArraySizeException {
        if (myArr.length != 4) {
            throw new MyArraySizeException("Размер массива направильный!");
        }
        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i].length != 4) {
                throw new MyArraySizeException("Размер массива направильный!");
            }
        }
    }


    public static int checkTypeAndSum(String[][] myArr) throws MyArrayDataException {
        int sum = 0;
        for (int i = 0; i < myArr.length; i++) {
            for (int j = 0; j < myArr[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(myArr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неправильный тип данных в ячейке: " + "[" + i + "]" + "[" + j +"]");
                }

            }
        }
        return sum;
    }


}

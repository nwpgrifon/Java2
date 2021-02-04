package ru.geekBrains.lesson3;

import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        HashMap<Integer, String> hashMap = new HashMap<>();


//        phoneBook.add(hashMap, 11111111, "John Gage");
//        phoneBook.add(hashMap, 11111112, "Patrick Naughton");
//        phoneBook.add(hashMap, 11111113, "James Gosling");
//        phoneBook.add(hashMap, 11111114, "Herbert Schildt");
//        phoneBook.add(hashMap, 11111115, "Cay Horstmann");
        phoneBook.add(hashMap, 11111115, "Joshua Bloch");
        phoneBook.add(hashMap, 11111115, "Joshua Bloch");

//        phoneBook.getByName(hashMap, "Joshua Bloch");
        System.out.println(hashMap);
    }
}

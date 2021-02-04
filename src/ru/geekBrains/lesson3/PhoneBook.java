package ru.geekBrains.lesson3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    public static void add(HashMap hashMap, int tel, String name) {
        if (hashMap.containsKey(tel)) {
            System.out.println("Номер для " + name + " уже есть в телефеонной книге!");
            return;
        }
        hashMap.put(tel, name);
    }

//    public static void getByName(HashMap hashMap, String name) {
//        for (name: hashMap.values()) {
//            System.out.println(name + hashMap.keySet());
//        }
//    }
}

package ru.geekBrains.lesson3;

import java.util.HashMap;

public class PhoneBook {

    private static HashMap<String, String> hashMap = new HashMap();

    public void add(Contact contact) {
        if (!hashMap.containsKey(contact.getName())) {
            hashMap.put(contact.getName(), contact.getTel());
        } else {
            if (hashMap.get(contact.getName()).contains(contact.getTel())) {
                System.out.println("такой номер для " + contact.getName() + " уже есть!");
            } else {
                hashMap.replace(contact.getName(), hashMap.get(contact.getName()), hashMap.get(contact.getName()) + ", " + contact.getTel());
            }
        }
    }

    public void getByName(String name) {
        System.out.println(name + ",  " + hashMap.get(name));
    }

}


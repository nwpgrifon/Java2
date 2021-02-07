package ru.geekBrains.lesson3.List;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhoneBook {

    private HashMap<String, List<String>> hashMap = new HashMap();

    public void add(Contact contact) {
        if (!hashMap.containsKey(contact.getName())) {
            List<String> list = new ArrayList<>();
            list.add(contact.getTel());
            hashMap.put(contact.getName(), list);
        } else {
            for (String s : hashMap.get(contact.getName())) {
                if (s == contact.getTel()) {
                    System.out.println("Такой номер для " + contact.getName() + " уже есть!");
                    return;
                }
            }
            hashMap.get(contact.getName()).add(contact.getTel());
        }
    }

    public void getByName(String name) {
        System.out.println(name + ",  " + hashMap.get(name));
    }

}


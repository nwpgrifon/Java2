package ru.geekBrains.lesson3;

import java.util.HashMap;
import java.util.HashSet;

//1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
//Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
//Посчитать сколько раз встречается каждое слово.

public class UniqueWords {

    public static void main(String[] args) {

        String[] words = {
                "Java",
                "Java",
                "Java",
                "Java",
                "Java",
                "Java",
                "Java",
                "JavaScript",
                "Script",
                "Java",
                "Java",
                "Java",
                "Java",
                "JavaScript",
                "JavaScript",
                "JavaScript",
                "JavaScript",
                "JavaScript",
                "JavaScript"};

        HashMap<String, Integer> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<String>();
        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }

        for (String word: words) {
            hashSet.add(word);
        }
        System.out.println(hashMap);
        System.out.println(hashSet);
        System.out.println(hashSet.size());
        System.out.println(hashMap.size());
    }
}

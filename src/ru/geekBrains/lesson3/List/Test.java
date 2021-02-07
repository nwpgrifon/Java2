package ru.geekBrains.lesson3.List;


public class Test {

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        Contact c1 = new Contact("Joshua Bloch", "1234");
        Contact c2 = new Contact("Cay Horstmann", "1235");
        Contact c3 = new Contact("Herbert Schildt", "1236");
        Contact c4 = new Contact("Joshua Bloch", "1237");
        Contact c5 = new Contact("Joshua Bloch", "1237");


        phoneBook.add(c1);
        phoneBook.add(c2);
        phoneBook.add(c3);
        phoneBook.add(c4);
        phoneBook.add(c5);

        phoneBook.getByName("Joshua Bloch");

    }
}

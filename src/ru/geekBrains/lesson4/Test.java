package ru.geekBrains.lesson4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.swing.*;
import java.awt.*;

public class Test {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame frame = new JFrame("Клиент");
            frame.setSize(300, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            BorderLayout borderLayout = new BorderLayout();
            frame.setLayout(borderLayout);

            var chat = new JTextArea(15, 20);
            chat.setBackground(new Color(255, 255, 255));

            var input = new JTextField(20);
            var sendButton = new JButton("Отправить");

            sendButton.addActionListener(e -> {
                chat.setText(chat.getText() +"\n" +input.getText());
                input.setText("");
            });

            frame.add(chat, BorderLayout.NORTH);
            frame.add(input, BorderLayout.WEST);
            frame.add(sendButton, BorderLayout.EAST);
            frame.setVisible(true);

        });


//2. OUTPUT
        int[] list = {1, 2, 3, 4, 5};

        search(5, list);
        int o = search((a, b) -> {

            int sum = 0;

            for (int c : b) {
                sum =+ c;
            }

            return sum / a;

        },5, list);

        System.out.println(o);

//        List<Integer> t = l.stream().filter(a -> true).collect(Collectors.toList());


//3. OUTPUT

        String s1 = "java interview";
        System.out.println(reverse(s1, a -> new StringBuilder(s1).reverse().toString()));


//4. OUTPUT

        int y =

        maximum(list, a -> Arrays.stream(list).max().getAsInt());

        System.out.println(y);


//5. OUTPUT

        List<Integer> l = Arrays.asList(2, 2, 3, 5, 2);

        Double xx = average(l, v -> {
            double sum = 0;

            for (double c : l) {
                sum += c;
            }

            return (sum / l.size());
        });

        System.out.println(xx);


//6. OUTPUT

        List<String> k = Arrays.asList("aaa", "aaag", "abv", "aaad", "qwertyuiop", "cba", "asdfghjkl;", "zxcvbnm,./");

        List h = search(k, f -> k.stream().filter(q -> q.charAt(0) == 'a').filter(q -> q.length() == 3).collect(Collectors.toList()));

        System.out.println(h);

    }


//2. Напишите метод, который возвращает индекс первого вхождения данного целого числа в списке.

    public static Integer search(int n, int[] list) {

        CustomInterface c = (b, a) -> {
            for (int i = 0; i < a.length; i++) {
                if (a[i] == b) {
                    return i;
                }
            }
            return -1;
        };
        return c.operation(n, list);
    }

    public static Integer search(CustomInterface c, int n, int[] list) {
        return c.operation(n, list);
    }

//3 Напишите метод, переворачивающий строку.

    public static String reverse(String s, StringReverse a) {
        return a.stringReverse(s);
    }

//4 Напишите метод, который возвращает наибольшее целое число в списке.

    public static int maximum(int[] k, Max max) {
        return max.operation(k);
    }

//5. Напишите метод, который возвращает среднее значение из списка целых чисел.

    public static Double average(List<Integer> list, AverageValue v) {
        return v.operation(list);
    }

//6. Имея список строк, напишите метод, который возвращает список всех строк,
//    которые начинаются с буквы «а» (нижний регистр) и имеют ровно 3 буквы.

    public static List<String> search(List<String> list, Function f) {
        return (List<String>) f.apply(list);
    }

}

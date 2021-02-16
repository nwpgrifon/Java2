package ru.geekBrains.lesson6.client;

import java.io.*;
import java.net.Socket;

class Client {

    private static Socket clientSocket;
    private static BufferedReader reader;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            clientSocket = new Socket("localhost", 8082);
            System.out.println("Клиент запущен!");
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            Thread input = new Thread(() -> {

                try {
                    while (true) {
                        String word = reader.readLine();
                        if (word.equalsIgnoreCase("finish")) {
                            System.out.println("Закончили");
                            clientSocket.close();
                            in.close();
                            out.close();
                            break;
                        }
                        out.write(word + "\n");
                        out.flush();
                    }
                } catch (IOException e) {
                    System.err.println(e);
                }
            });
            Thread output = new Thread(() -> {

                try {
                    while (true) {
                        String serverWord = in.readLine();
                        System.out.println(serverWord);
                    }
                } catch (IOException e) {
                    System.err.println(e);
                }
            });
            input.start();
            output.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
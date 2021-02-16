package ru.geekBrains.lesson6.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static Socket clientSocket;
    private static ServerSocket server;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        try {
            server = new ServerSocket(8082);
            System.out.println("Сервер запущен!");
            clientSocket = server.accept();
            System.out.println("Клиент подключился!");
            reader = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            Thread input = new Thread(() -> {
                try {
                    while (true) {
                        String word = in.readLine();
                        if (word.equalsIgnoreCase("finish")) {
                            System.out.println("Закончили");
                            server.close();
                            in.close();
                            out.close();
                            break;
                        }
                        System.out.println("Клиент: " + word);
                    }
                } catch (IOException e) {
                    System.err.println(e);
                }
            });
            Thread output = new Thread(() -> {
                try {
                    while (true) {
                        String wordServer = reader.readLine();
                        if (wordServer.equalsIgnoreCase("finish")) {
                            System.out.println("Закончили");
                            break;
                        }
                        out.write("Сервер: " + wordServer + "\n");
                        out.flush();
                    }
                } catch (IOException e) {
                    System.err.println(e);
                }

            });
            input.start();
            output.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
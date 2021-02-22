package ru.geekBrains.lesson7.serverside.service;
import ru.geekBrains.lesson7.serverside.interfaces.AuthService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyServer {
    private final int PORT = 8081;

    private List<ClientHandler> clients;

    private AuthService authService;

    public AuthService getAuthService() {
        return this.authService;
    }

    public MyServer() {
        try (ServerSocket server = new ServerSocket(PORT)){

            authService = new BaseAuthService();
            authService.start();

            clients = new ArrayList<>();

            while (true) {
                System.out.println("Сервер ожидает подключения");
                Socket socket = server.accept();
                System.out.println(socket.getInetAddress().getCanonicalHostName());
                System.out.println("Клиент подклчился");
                new ClientHandler(this, socket);
            }

        } catch (IOException e){
            System.out.println("Сервер не пережил землятрясение");
        } finally {
            if (authService != null) {
                authService.stop();
            }
        }
    }

    public synchronized void broadcastMessage(String message) {
        for (ClientHandler c : clients) {
            c.sendMessage(message);
        }
    }
    public synchronized void privateMessage(ClientHandler from, String toName, String message) {
        for (ClientHandler c : clients) {
            if (c.getName().equals(toName)){
                c.sendMessage(message);
                from.sendMessage(message);
            }
        }
    }


    public synchronized void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public synchronized void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public boolean isNickBusy(String nick) {
        for (ClientHandler c : clients) {
            if (c.getName().equals(nick)) {
                return true;
            }
        }
        return false;
    }
}
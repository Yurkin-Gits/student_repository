package com.yurkin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Подключено к серверу");

            String name = in.readLine();
            System.out.println(name);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Введите ваше имя: ");
            String username = userInput.readLine();

            out.println(username);

            new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            String message;
            while ((message = userInput.readLine()) != null) {
                if (message.equals("/exit")) {
                    out.println("/exit");
                    break;
                } else if (message.equals("/history")) {
                    out.println("/history");
                } else {
                    out.println(message);
                }
            }

            System.out.println("Вы покинули чат.");
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

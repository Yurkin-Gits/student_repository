package com.yurkin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Server {
    private static final int PORT = 12345;
    private static Set<ClientHandler> clientHandlers = new HashSet<>();
    private static List<String> messageHistory = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Сервер запущен...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Введите ваше имя:");
                clientName = in.readLine();
                System.out.println(clientName + " подключился.");

                synchronized (clientHandlers) {
                    clientHandlers.add(this);
                }

                // Отправка истории сообщений при подключении
                sendHistory();

                String message;
                while ((message = in.readLine()) != null) {
                    if (message.startsWith("/exit")) {
                        out.println("Вы покинули чат.");
                        break;
                    } else if (message.startsWith("/history")) {
                        sendHistory();
                    } else {
                        if (messageHistory.size() >= 100) {
                            messageHistory.remove(0);
                        }
                        messageHistory.add(clientName + ": " + message);
                        System.out.println(clientName + ": " + message);

                        // Пересылаем сообщение всем клиентам
                        synchronized (clientHandlers) {
                            for (ClientHandler client : clientHandlers) {
                                client.out.println(clientName + ": " + message);
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                synchronized (clientHandlers) {
                    clientHandlers.remove(this);
                }
            }
        }

        private void sendHistory() {
            if (messageHistory.isEmpty()) {
                out.println("История сообщений пуста.");
            } else {
                for (String msg : messageHistory) {
                    out.println(msg);
                }
            }
        }
    }
}
 
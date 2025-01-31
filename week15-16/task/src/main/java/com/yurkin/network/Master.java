package com.yurkin.network;

import com.yurkin.model.HousePriceRecord;
import com.yurkin.model.Task;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Master {
    private final int port;
    private final BlockingQueue<Task> taskQueue;
    private final BlockingQueue<List<HousePriceRecord>> resultQueue;
    private volatile int processedTasks = 0;

    public Master(int port) {
        this.port = port;
        this.taskQueue = new LinkedBlockingQueue<>();
        this.resultQueue = new LinkedBlockingQueue<>();
    }

    public static List<String> scanDirectory(String directoryPath) throws IOException {
        Path dir = Paths.get(directoryPath);
        if (!Files.isDirectory(dir)) {
            throw new IllegalArgumentException("Указанный путь не является директорией.");
        }

        List<String> filePaths = new ArrayList<>();
        try (var paths = Files.walk(dir)) {
            paths.filter(Files::isRegularFile)
                 .filter(p -> p.getFileName().toString().equals(p.getParent().getFileName().toString()))
                 .map(Path::toString)
                 .forEach(filePaths::add);
        }
        return filePaths;
    }

    public void submitTasks(List<String> filePaths) {
        for (String filePath : filePaths) {
            taskQueue.add(new Task(filePath));
        }
    }

    public void startServer() {
        new Thread(() -> {
            try (ServerSocket serverSocket = new ServerSocket(port)) {
                System.out.println("Master запущен на порту " + port);

                while (!taskQueue.isEmpty()) {
                    Socket workerSocket = serverSocket.accept();
                    System.out.println("Подключен новый воркер: " + workerSocket.getInetAddress());
                    new Thread(() -> handleWorker(workerSocket)).start();
                }
            } catch (IOException e) {
                System.err.println("Ошибка при работе сервера: " + e.getMessage());
                e.printStackTrace();
            }
        }).start();
    }

    private void handleWorker(Socket workerSocket) {
        try (var out = new ObjectOutputStream(workerSocket.getOutputStream());
             var in = new ObjectInputStream(workerSocket.getInputStream())) {

            while (true) {
                Task task = taskQueue.poll();
                out.writeObject(task);
                out.flush();
                if (task == null) break;

                List<HousePriceRecord> records = (List<HousePriceRecord>) in.readObject();
                resultQueue.add(records);
                processedTasks++;
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при взаимодействии с воркером: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<HousePriceRecord> collectResults() throws InterruptedException {
        List<HousePriceRecord> allRecords = new ArrayList<>();
        while (!resultQueue.isEmpty()) {
            allRecords.addAll(resultQueue.take());
        }
        return allRecords;
    }

    public int getProcessedTasks() {
        return processedTasks;
    }
}
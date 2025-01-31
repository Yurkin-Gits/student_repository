package com.yurkin.network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import com.yurkin.model.HousePriceRecord;
import com.yurkin.model.Task;

public class WorkerClient {
    private final String masterHost;
    private final int masterPort;
    private final Worker worker;

    public WorkerClient(String masterHost, int masterPort, Worker worker) {
        this.masterHost = masterHost;
        this.masterPort = masterPort;
        this.worker = worker;
    }

    public void start() {
        try (Socket socket = new Socket(masterHost, masterPort);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            System.out.println("Воркер подключен к мастеру: " + masterHost + ":" + masterPort);

            while (true) {
                Task task = (Task) in.readObject();
                if (task == null) break;

                List<HousePriceRecord> records = worker.process(task);
                out.writeObject(records);
                out.reset();
                out.flush();
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при работе воркера: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
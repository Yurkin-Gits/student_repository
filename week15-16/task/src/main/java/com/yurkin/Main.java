package com.yurkin;

import com.yurkin.model.HousePriceRecord;
import com.yurkin.network.Master;
import com.yurkin.network.WorkerClient;
import com.yurkin.service.DataAnalyzer;
import com.yurkin.service.FileProcessingWorker;
import com.yurkin.ui.ChartCreator;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Ошибка: Путь к директории не указан.");
            System.exit(1);
        }

        String directoryPath = args[0];
        int masterPort = 8080;

        try {
            List<String> filePaths = Master.scanDirectory(directoryPath);
            Master master = new Master(masterPort);
            master.submitTasks(filePaths);
            master.startServer();

            for (int i = 0; i < 4; i++) {
                new Thread(() -> {
                    WorkerClient worker = new WorkerClient("localhost", masterPort, new FileProcessingWorker());
                    worker.start();
                }).start();
            }

            int totalTasks = filePaths.size();
            while (master.getProcessedTasks() < totalTasks) {
                Thread.sleep(500);
            }

            List<HousePriceRecord> allRecords = master.collectResults();
            Map<Integer, Map<String, Integer>> yearlyMaxPrices = DataAnalyzer.getYearlyMaxPrices(allRecords);

            System.out.println("Выберите год для построения диаграммы:");
            yearlyMaxPrices.keySet().forEach(System.out::println);

            try (Scanner scanner = new Scanner(System.in)) {
                int selectedYear = scanner.nextInt();
                if (yearlyMaxPrices.containsKey(selectedYear)) {
                    Map<String, Integer> cityMaxPrices = yearlyMaxPrices.get(selectedYear);
                    ChartCreator.createHistogram(Map.of(selectedYear, cityMaxPrices));
                } else {
                    System.out.println("Год не найден.");
                }
            }
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
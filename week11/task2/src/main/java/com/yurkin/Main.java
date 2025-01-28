package com.yurkin;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_COUNT = 4; // Количество потоков
    private static final long FILE_SIZE = 32L * 1024 * 1024 * 1024;
    private static final long CHUNK_SIZE = FILE_SIZE / THREAD_COUNT; // Размер части файла для каждого потока

    public static void main(String[] args) {
        String filePath = "/home/leroman/Загрузки/large_file.bin";

        // Начало измерения времени
        long startTime = System.nanoTime();

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        List<ShannonEntropyCalculator> calculators = new ArrayList<>();

        try (RandomAccessFile file = new RandomAccessFile(new File(filePath), "r")) {
            for (int i = 0; i < THREAD_COUNT; i++) {
                long start = i * CHUNK_SIZE;
                long end = (i == THREAD_COUNT - 1) ? FILE_SIZE : start + CHUNK_SIZE;
                calculators.add(new ShannonEntropyCalculator(filePath, start, end));
            }

            for (ShannonEntropyCalculator calculator : calculators) {
                executor.submit(calculator);
            }

            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.HOURS);

            // Объединяем результаты
            Map<Byte, Long> totalFrequencyMap = new HashMap<>();
            long totalBytes = 0;

            for (ShannonEntropyCalculator calculator : calculators) {
                Map<Byte, Long> frequencyMap = calculator.getFrequencyMap();
                for (Map.Entry<Byte, Long> entry : frequencyMap.entrySet()) {
                    totalFrequencyMap.put(entry.getKey(), totalFrequencyMap.getOrDefault(entry.getKey(), 0L) + entry.getValue());
                }
                totalBytes += calculator.getTotalBytes();
            }

            double entropy = 0.0;
            for (long count : totalFrequencyMap.values()) {
                double probability = (double) count / totalBytes;
                entropy -= probability * (Math.log(probability) / Math.log(2));
            }

            System.out.println("Итоговая энтропия Шеннона: " + entropy);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            long endTime = System.nanoTime();
            long duration = (endTime - startTime) / 1_000_000_000;
            System.out.println("Время выполнения: " + duration + " с");
        }
    }
}
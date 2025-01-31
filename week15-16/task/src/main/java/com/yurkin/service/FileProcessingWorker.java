package com.yurkin.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.yurkin.model.HousePriceRecord;
import com.yurkin.model.Task;
import com.yurkin.network.Worker;

public class FileProcessingWorker implements Worker {
    @Override
    public List<HousePriceRecord> process(Task task) {
        if (task == null || task.getFilePath() == null) {
            throw new IllegalArgumentException("Задача или путь к файлу не указаны.");
        }

        try {
            return DataParser.parseLines(Files.readAllLines(Path.of(task.getFilePath())));
        } catch (IOException e) {
            System.err.println("Ошибка при обработке файла: " + task.getFilePath());
            e.printStackTrace();
            return List.of();
        }
    }
}
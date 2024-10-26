package com.yurkin;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Ошибка: Укажите путь к файлу.");
            return;
        }

        String inputFilePath = args[0];
        Path inputPath = Paths.get(inputFilePath);
        String resultFileName = "result.txt";
        Path resultFilePath = Paths.get(resultFileName);

        if (!Files.exists(inputPath)) {
            System.out.println("Ошибка: Файл не найден.");
            return;
        }
        if (!Files.isReadable(inputPath)) {
            System.out.println("Ошибка: Файл недоступен для чтения.");
            return;
        }

        try (FileChannel fileChannel = FileChannel.open(inputPath, StandardOpenOption.READ)) {
            double entropy = EntropyCalculator.calculateEntropy(fileChannel);
            System.out.printf("Энтропия Шеннона для файла '%s': %.6f%n", inputFilePath, entropy);
            if (!Files.exists(resultFilePath) || Files.isWritable(resultFilePath)) {
                Files.writeString(resultFilePath, "Энтропия Шеннона: " + entropy);
            } else {
                System.out.println("Ошибка: Файл недоступен для записи.");
            }
            
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

package com.yurkin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Ошибка: Путь к файлу не задан.");
            return;
        }
        
        String filePath = args[0];
        Path path = Paths.get(filePath);
        try {
            String content = Files.readString(path);
            double entropy = EntropyCalculator.calculateEntropy(content);
            System.out.printf("Энтропия для файла '%s': %.6f%n", filePath, entropy);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Возникла ошибка: " + e.getMessage());
        }
    }
}
 
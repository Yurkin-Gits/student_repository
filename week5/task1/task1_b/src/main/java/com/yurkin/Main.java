package com.yurkin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String fileName = "src/main/java/com/yurkin/data_file.txt";

        try {
            Path path = Paths.get(fileName);
            String content = Files.readString(path);
            char[] characters = content.toCharArray();
            double entropy = EntropyCalculator.calculateEntropy(characters);
            System.out.printf("Энтропия для файла '%s': %.6f%n", fileName, entropy);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Возникла ошибка: " + e.getMessage());
        }
    }
}

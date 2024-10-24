package com.yurkin;

import java.io.IOException;
import java.nio.ByteBuffer;
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
        try (FileChannel fileChannel = FileChannel.open(inputPath, StandardOpenOption.READ)) {
            int bufferSize = 8192;
            ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
            long[] frequencies = new long[256];
            long totalCharacters = 0;
            while (fileChannel.read(buffer) > 0) {
                buffer.flip();
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    frequencies[b & 0xFF]++;
                    totalCharacters++;
                }
                buffer.clear();
            }

            double entropy = EntropyCalculator.calculateEntropy(frequencies, totalCharacters);
            System.out.printf("Энтропия Шеннона для файла '%s': %.6f%n", inputFilePath, entropy);
            Files.writeString(resultFilePath, "Энтропия Шеннона: " + entropy);
        } catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

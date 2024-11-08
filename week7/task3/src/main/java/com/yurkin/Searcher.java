package com.yurkin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Searcher {

    public static List<Path> searchByName(String directory, String fileName) throws IOException {
        try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
            return paths
                .filter(Files::isRegularFile)
                .filter(path -> path.getFileName().toString().contains(fileName))
                .collect(Collectors.toList());
        }
    }

    public static List<Path> searchByContent(String directory, String keyword) throws IOException {
        try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
            return paths
                .filter(Files::isRegularFile)
                .filter(path -> {
                    try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            if (line.contains(keyword)) {
                                return true; 
                            }
                        }
                    } catch (IOException e) {
                        System.out.println("Ошибка при чтении файла: " + path.toString());
                    }
                    return false;
                })
                .collect(Collectors.toList());
        }
    }
}

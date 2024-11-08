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
        return searchFiles(directory, path -> path.getFileName().toString().contains(fileName), null);
    }

    public static List<Path> searchByContent(String directory, String keyword) throws IOException {
        return searchFiles(directory, path -> containsKeyword(path, keyword), null);
    }

    private static List<Path> searchFiles(String directory, java.util.function.Predicate<Path> pathFilter, java.util.function.Predicate<Path> contentFilter) throws IOException {
        try (Stream<Path> paths = Files.walk(Paths.get(directory))) {
            return paths
                .filter(Files::isRegularFile)
                .filter(pathFilter)
                .filter(contentFilter != null ? contentFilter : p -> true)
                .collect(Collectors.toList());
        }
    }

    private static boolean containsKeyword(Path path, String keyword) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            return reader.lines().anyMatch(line -> line.contains(keyword));
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + path.toString());
            return false;
        }
    }
}

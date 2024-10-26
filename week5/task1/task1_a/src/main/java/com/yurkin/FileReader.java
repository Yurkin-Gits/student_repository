package com.yurkin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

public class FileReader {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Ошибка: Путь к файлу не задан.");
            return;
        }
        
        String filePath = args[0];
        
        try {
            String content = Files.readString(Paths.get(filePath));
            System.out.println("Содержимое файла: ");
            System.out.println(content);
        } catch (NoSuchFileException e) {
            System.out.println("Ошибка: Файл не найден.");
        } catch (IOException e) {
            System.out.println("Ошибка: Проблема при чтении файла.");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Неверный формат данных в файле.");
        }
    }
}

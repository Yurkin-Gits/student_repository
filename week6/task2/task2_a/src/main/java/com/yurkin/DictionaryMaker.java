package com.yurkin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DictionaryMaker {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Map<String, List<String>> latinEnglishDictionary = new TreeMap<>();

        System.out.print("Введите количество английских слов в словаре: ");
        int count = Integer.parseInt(read.nextLine());
        System.out.printf("Введите слово и его переводы:\n");
        for (int i = 0; i < count; i++) {
            String line = read.nextLine();
            String[] parts = line.split(" - ");
            String englishWord = parts[0];
            String[] translations = parts[1].split(", ");

            for (String latinWord : translations) {
                latinEnglishDictionary.putIfAbsent(latinWord, new ArrayList<>());
                List<String> englishWords = latinEnglishDictionary.get(latinWord);
                if (!englishWords.contains(englishWord)) {
                    englishWords.add(englishWord);
                }
            }
        }

        System.out.println("\nЛатинско-английский словарь:");
        System.out.println("Найдено переводов: " + latinEnglishDictionary.size());
        for (Map.Entry<String, List<String>> entry : latinEnglishDictionary.entrySet()) {
            String latinWord = entry.getKey();
            String englishWords = String.join(", ", entry.getValue());
            System.out.println(latinWord + " - " + englishWords);
        }

        read.close();
    }
}

package com.yurkin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Ошибка: Путь к файлу не указан.");
            System.exit(1);
        }

        String filePath = args[0];
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        List<HousePriceRecord> records = DataParser.parseLines(lines);
        Map<Integer, Map<String, Integer>> yearlyMaxPrices = DataAnalyzer.getYearlyMaxPrices(records);
        ChartCreator.createHistogram(yearlyMaxPrices);
    }
}

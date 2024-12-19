package com.yurkin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) {
        Map<Integer, Double> recursiveTimes = new HashMap<>();
        Map<Integer, Double> optimizedTimes = new HashMap<>();
        List<Result> results = new ArrayList<>();

        for (int i = 1; i <= 45; i++) {
            // Измерение времени рекурсивного метода
            long startTime = System.nanoTime();
            long recursiveValue = Fibonacci.recursive(i);
            long endTime = System.nanoTime();
            double recursiveTime = (endTime - startTime) / 1_000_000.0;
            recursiveTimes.put(i, recursiveTime);

            // Измерение времени оптимизированного метода
            startTime = System.nanoTime();
            long optimizedValue = Fibonacci.optimized(i);
            endTime = System.nanoTime();
            double optimizedTime = (endTime - startTime) / 1_000_000.0;
            optimizedTimes.put(i, optimizedTime);

            results.add(new Result(i, recursiveValue, recursiveTime, optimizedValue, optimizedTime));
        }

        // Создание графика
        ChartCreator chartBuilder = new ChartCreator();
        try {
            chartBuilder.createChart(recursiveTimes, optimizedTimes);
        } catch (Exception e) {
            System.err.println("Ошибка при построении графика: " + e.getMessage());
        }

        // Сохранение результата в JSON
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("results.json"), results);
            System.out.println("Результаты сохранены в файл results.json");
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении результата в файл: " + e.getMessage());
        }
    }
}

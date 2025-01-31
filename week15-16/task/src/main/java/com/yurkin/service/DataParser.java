package com.yurkin.service;

import java.io.StringReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.opencsv.CSVReader;
import com.yurkin.model.HousePriceRecord;

public class DataParser {
    public static List<HousePriceRecord> parseLines(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            throw new IllegalArgumentException("Список строк пуст.");
        }

        return lines.stream()
                .map(DataParser::parseLine)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private static HousePriceRecord parseLine(String line) {
        try (CSVReader reader = new CSVReader(new StringReader(line))) {
            String[] fields = reader.readNext();
            if (fields.length < 4) {
                System.err.println("Недостаточно данных в строке: " + line);
                return null;
            }
            int price = Integer.parseInt(fields[1].replaceAll("\\D", ""));
            String date = fields[2].replace("\"", "");
            String city = fields[fields.length - 3].replace("\"", "");
            int year = Integer.parseInt(date.substring(0, 4));
            return new HousePriceRecord(year, city, price);
        } catch (Exception e) {
            System.err.println("Ошибка при обработке строки: " + line);
            return null;
        }
    }
}
package com.yurkin.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.yurkin.model.HousePriceRecord;

public class DataAnalyzer {
    public static Map<Integer, Map<String, Integer>> getYearlyMaxPrices(List<HousePriceRecord> records) {
        if (records == null || records.isEmpty()) {
            throw new IllegalArgumentException("Список записей пуст.");
        }

        return records.stream()
                .collect(Collectors.groupingBy(
                        HousePriceRecord::getYear,
                        Collectors.toMap(
                                HousePriceRecord::getCity,
                                HousePriceRecord::getPrice,
                                Math::max
                        )
                ));
    }
}
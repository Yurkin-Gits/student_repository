package com.yurkin;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Processor {
    public static List<Object> findMostFrequentChar(String line) {
        Map<Character, Long> frequencyMap = line.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        Map.Entry<Character, Long> maxEntry = frequencyMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);

        if (maxEntry != null) {
            return List.of(maxEntry.getKey(), maxEntry.getValue().intValue());
        } else {
            return Collections.emptyList();
        }
    }
}

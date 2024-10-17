package com.yurkin;

import java.util.HashMap;
import java.util.Map;

public class ShannonEntropy {

    public double calculateEntropy(String input) {
        Map<Character, Integer> charCounts = new HashMap<>();
        int totalChars = input.length();

        for (int i = 0; i < totalChars; i++) {
            char currentChar = input.charAt(i);
            charCounts.put(currentChar, charCounts.getOrDefault(currentChar, 0) + 1);
        }

        double entropy = 0.0;
        for (int count : charCounts.values()) {
            double probability = (double) count / totalChars;
            entropy += -probability * (Math.log(probability) / Math.log(2));
        }

        return entropy;
    }
}

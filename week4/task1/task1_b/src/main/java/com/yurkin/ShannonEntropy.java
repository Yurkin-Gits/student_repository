package com.yurkin;

public class ShannonEntropy {

    public double calculateEntropy(String input) {
        int[] charCounts = new int[512];
        int totalChars = input.length();

        for (int i = 0; i < totalChars; i++) {
            char currentChar = input.charAt(i);
            if (currentChar < 512) {
                charCounts[currentChar]++;
            }
        }
        
        double entropy = 0.0;
        for (int count : charCounts) {
            if (count > 0) {
                double probability = (double) count / totalChars;
                entropy += -probability * (Math.log(probability) / Math.log(2));
            }
        }

        return entropy;
    }
}

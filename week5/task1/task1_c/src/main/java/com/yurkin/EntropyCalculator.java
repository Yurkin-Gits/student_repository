package com.yurkin;

public class EntropyCalculator {
    public static double calculateEntropy(long[] frequencies, long totalCharacters) {
        double entropy = 0.0;
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 0) {
                double probability = (double) frequencies[i] / totalCharacters;
                entropy -= probability * (Math.log(probability) / Math.log(2));
            }
        }
        return entropy;
    }
}

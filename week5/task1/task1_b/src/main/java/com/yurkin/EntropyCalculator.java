package com.yurkin;

public class EntropyCalculator {

    public static double calculateEntropy(char[] characters) {
        int[] frequencies = new int[256];
        for (char c : characters) {
            frequencies[c]++;
        }

        int totalCharacters = characters.length;
        double[] probabilities = new double[256];
        for (int i = 0; i < frequencies.length; i++) {
            if (frequencies[i] > 0) {
                probabilities[i] = (double) frequencies[i] / totalCharacters;
            }
        }

        double entropy = 0.0;
        for (double probability : probabilities) {
            if (probability > 0) {
                entropy -= probability * (Math.log(probability) / Math.log(2));
            }
        }

        return entropy;
    }
}

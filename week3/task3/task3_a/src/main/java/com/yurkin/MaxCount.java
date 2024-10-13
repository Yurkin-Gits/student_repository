package com.yurkin;

public class MaxCount {
    private double[] numbers;

    public MaxCount(double[] numbers) {
        this.numbers = numbers;
    }

    public double findAndCountMax() {
        double max = numbers[0];
        int count = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        for (double number : numbers) {
            if (number == max) {
                count++;
            }
        }
        return count;
    }
}


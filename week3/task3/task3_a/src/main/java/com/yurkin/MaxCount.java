package com.yurkin;

public class MaxCount {
    private double[] numbers;

    public MaxCount(double[] numbers) {
        this.numbers = numbers;
    }

    public double findMax() {
        double max = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public int countMax(double max) {
        int count = 0;
        for (double number : numbers) {
            if (number == max) {
                count++;
            }
        }
        return count;
    }
}


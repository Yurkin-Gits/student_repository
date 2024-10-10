package com.yurkin;

class MedianCalculator {
    public static double findMedian(double[] numbers) {
        sort(numbers);
        int size = numbers.length;

        if (size % 2 == 0) {
            return (numbers[size / 2 - 1] + numbers[size / 2]) / 2;
        } else {
            return numbers[size / 2];
        }
    }

    private static void sort(double[] numbers) {
        // Используется сортировка пузырьком
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    double temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }
}

package com.yurkin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество чисел:");
        int size = scanner.nextInt();

        double[] numbers = new double[size];

        System.out.println("Введите числа:");
        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextDouble();
        }
        scanner.close();

        MaxCount maxCounter = new MaxCount(numbers);
        int count = (int) maxCounter.findAndCountMax();

        System.out.println("Количество чисел, равных максимальному: " + count);
    }
}


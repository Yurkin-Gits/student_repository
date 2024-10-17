package com.yurkin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShannonEntropy entropyCalculator = new ShannonEntropy();

        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        double entropy = entropyCalculator.calculateEntropy(input);

        System.out.printf("Энтропия строки: %.2f%n", entropy);
        scanner.close();
    }
}


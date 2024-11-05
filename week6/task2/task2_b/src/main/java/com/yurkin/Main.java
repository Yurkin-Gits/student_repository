package com.yurkin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Введите количество строк, которые вы хотите ввести:");
        int linesCount = read.nextInt();
        read.nextLine();
        List<String> salesInput = new ArrayList<>();
        System.out.println("Введите данные о продажах (Покупатель товар количество):");
        for (int i = 0; i < linesCount; i++) {
            String input = read.nextLine();
            salesInput.add(input);
        }

        read.close();
        System.out.println();
        SalesData.processSales(salesInput);
        for (Map.Entry<String, Map<String, Integer>> entry : SalesData.getCustomerData().entrySet()) {
            String customer = entry.getKey();
            System.out.println(customer + ":");
            for (Map.Entry<String, Integer> productEntry : entry.getValue().entrySet()) {
                System.out.println(productEntry.getKey() + " " + productEntry.getValue());
            }
        }

        int invalidInputCount = SalesData.getInvalidInputCount();
        if (invalidInputCount > 0) {
            System.out.println("Количество некорректных строк: " + invalidInputCount);
        }
    }
}
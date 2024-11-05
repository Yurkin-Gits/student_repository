package com.yurkin;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.println("Введите цены акции через запятую: ");
        String input = read.nextLine();
        String[] strPrices = input.split(",");
        
        List<Integer> prices = new ArrayList<>();
        for (String strPrice : strPrices) {
            prices.add(Integer.parseInt(strPrice.trim()));
        }

        System.out.println("Введите номер дня покупки (от 1 до " + prices.size() + "): ");
        int buyDay = read.nextInt() - 1;
        
        System.out.println("Введите номер дня продажи (от 1 до " + prices.size() + "): ");
        int sellDay = read.nextInt() - 1;

        if (buyDay < 0 || buyDay >= prices.size() || sellDay < 0 || sellDay >= prices.size()) {
            System.out.println("Ошибка: введенный день не существует.");
        } else if (sellDay <= buyDay) {
            System.out.println("Ошибка: день продажи должен быть позже дня покупки.");
        } else {
            int profit = ProfitCalculator.maxProfit(prices, buyDay, sellDay);
            System.out.println("Прибыль за выбранный период: " + profit);
        }
    }
}

package com.yurkin;

import java.util.List;

public class ProfitCalculator {
    public static int maxProfit(List<Integer> prices, int buyDay, int sellDay) {
        if (prices == null || prices.size() < 2) {
            return 0;
        }

        if (buyDay < 0 || buyDay >= prices.size() || sellDay < 0 || sellDay >= prices.size() || sellDay <= buyDay) {
            return 0;
        }

        int minPrice = prices.get(0);
        int maxProfit = 0;

        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) < minPrice) {
                minPrice = prices.get(i);
            } else {
                int profit = prices.get(i) - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return prices.get(sellDay) - prices.get(buyDay);
    }
}

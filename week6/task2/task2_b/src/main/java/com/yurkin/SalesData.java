package com.yurkin;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SalesData {
    private static final Map<String, Map<String, Integer>> customerData = new TreeMap<>();
    private static int invalidInputCount = 0;

    public static void processSales(List<String> salesEntries) {
        for (String entry : salesEntries) {
            String[] parts = entry.split(" ");
            if (parts.length != 3) {
                invalidInputCount++;
                continue;
            }

            String customer = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            customerData.putIfAbsent(customer, new TreeMap<>());
            Map<String, Integer> products = customerData.get(customer);
            products.put(product, products.getOrDefault(product, 0) + quantity);
        }
    }

    public static Map<String, Map<String, Integer>> getCustomerData() {
        return customerData;
    }

    public static int getInvalidInputCount() {
        return invalidInputCount;
    }
}


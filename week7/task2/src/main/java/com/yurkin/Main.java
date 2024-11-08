package com.yurkin;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Укажите путь к файлу заказов как аргумент командной строки.");
            return;
        }

        String filePath = args[0];
        OrderGenerator generator = new OrderGenerator();
        List<Order> orders = generator.generateOrders(filePath);

        double totalAmount = orders.stream()
            .filter(order -> order.getOrderDate().getYear() == 2020 &&
                             order.getOrderDate().getMonthValue() == 2)
            .flatMap(order -> order.getProducts().stream())
            .mapToDouble(Product::getPrice)
            .sum();

        System.out.println("Общая сумма заказов в феврале 2020 г.: " + totalAmount);
    }
}

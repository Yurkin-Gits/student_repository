package com.yurkin;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderGenerator generator = new OrderGenerator();
        List<Order> orders = generator.generateOrders("orders.csv");

        double totalAmount = orders.stream()
            .filter(order -> order.getOrderDate().getYear() == 2020 &&
                             order.getOrderDate().getMonthValue() == 2)
            .flatMap(order -> order.getProducts().stream())
            .mapToDouble(Product::getPrice)
            .sum();

        System.out.println("Общая сумма заказов в феврале 2020 г.: " + totalAmount);
    }
}

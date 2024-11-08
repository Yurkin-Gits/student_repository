package com.yurkin;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class OrderCompiler {

    private static final SimpleDateFormat DATE_FORMATTER = new SimpleDateFormat("dd-MM-yy");

    public List<Order> compileOrders(String filePath) {
        List<Order> orders = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                try {
                    String[] row = line.split(",");

                    Long orderId = Long.parseLong(row[0]);
                    String orderDate = row[1];
                    String deliveryDate = row[2];
                    String status = row[3];
                    Long customerId = Long.parseLong(row[4]);
                    String customerName = row[5];
                    int customerTier = Integer.parseInt(row[6]);
                    Long productId = Long.parseLong(row[7]);
                    String productName = row[8];
                    String productCategory = row[9];
                    Double productPrice = Double.parseDouble(row[10]);

                    Customer customer = new Customer();
                    customer.setId(customerId);
                    customer.setName(customerName);
                    customer.setTier(customerTier);

                    Product product = new Product();
                    product.setId(productId);
                    product.setName(productName);
                    product.setCategory(productCategory);
                    product.setPrice(productPrice);

                    Order order = new Order();
                    order.setId(orderId);

                    Date orderDateParsed = DATE_FORMATTER.parse(orderDate);
                    Date deliveryDateParsed = DATE_FORMATTER.parse(deliveryDate);
                    order.setOrderDate(new java.sql.Date(orderDateParsed.getTime()).toLocalDate());
                    order.setDeliveryDate(new java.sql.Date(deliveryDateParsed.getTime()).toLocalDate());

                    order.setStatus(status);
                    order.setCustomer(customer);
                    order.setProducts(Set.of(product));

                    orders.add(order);

                } catch (Exception e) {
                    continue;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла.");
        }

        return orders;
    }

}

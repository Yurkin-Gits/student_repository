package com.yurkin.model;

import java.io.Serializable;

public class HousePriceRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private final int year;
    private final String city;
    private final int price;

    public HousePriceRecord(int year, String city, int price) {
        this.year = year;
        this.city = city;
        this.price = price;
    }

    public int getYear() { return year; }
    public String getCity() { return city; }
    public int getPrice() { return price; }
}
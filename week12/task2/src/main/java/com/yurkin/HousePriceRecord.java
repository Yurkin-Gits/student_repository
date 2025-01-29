package com.yurkin;

public class HousePriceRecord {
    private final int year;
    private final String city;
    private final int price;

    public HousePriceRecord(int year, String city, int price) {
        this.year = year;
        this.city = city;
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public String getCity() {
        return city;
    }

    public int getPrice() {
        return price;
    }
}

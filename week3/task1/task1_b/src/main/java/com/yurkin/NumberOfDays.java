package com.yurkin;

public class NumberOfDays {
    private static int month;
    private static int year;


    public NumberOfDays(int month, int year) {
        this.month = month;
        this.year = year;
    }

    public static int getNumberOfDays() {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4: 
            case 6: 
            case 9:
            case 11:
                return 30;
            case 2:
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
            throw new IllegalArgumentException("Неправильный месяц: " + month);
        }
    }
}
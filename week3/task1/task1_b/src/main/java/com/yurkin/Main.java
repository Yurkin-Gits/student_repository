package com.yurkin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scannerMonth = new Scanner(System.in);
        Scanner scannerYear = new Scanner(System.in);

        System.out.print("Введите месяц: ");
        int month = scannerMonth.nextInt();
        
        System.out.print("Введите год: ");
        int year = scannerYear.nextInt();
        scannerMonth.close();
        scannerYear.close();
        NumberOfDays value = new NumberOfDays(month,year);
        System.out.println("Количество дней в месяце: " + value.getNumberOfDays());
    }
}

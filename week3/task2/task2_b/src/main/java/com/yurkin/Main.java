package com.yurkin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        double number = scanner.nextDouble();
        scanner.close();
        
        HeronMethod heronSqrt = new HeronMethod(number);
        double result = heronSqrt.HeronSqrt();
        
        System.out.printf("Квадратный корень числа %.5f по методу Герона: %.5f\n", number, result);
    }
}
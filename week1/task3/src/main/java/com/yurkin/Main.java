package com.yurkin;

import java.util.Scanner;

public class Main 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите длину ребра: ");
        int edge = scanner.nextInt();
        scanner.close();
        double value = getValue(edge);
        System.out.print("Объём додекаэдра равен: ");
        System.out.printf("%.1f%n", value);
    }

    public static double  getValue(int edge)
    {
        double V = ((15+7*Math.sqrt(5))/4) * Math.pow(edge, 3);
        return V;
    }
}

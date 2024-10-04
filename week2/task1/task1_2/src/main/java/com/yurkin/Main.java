package com.yurkin;

public class Main {
    public static void main(String[] args) {
        Octagon octagon = new Octagon(10.0);
        System.out.println("Площадь восьмиугольника: ");
        System.out.printf("%1f%n", octagon.calculateArea());
        System.out.println("Периметр восьмиугольника: ");
        System.out.printf("%1f%n", octagon.calculatePerimeter());
    }
}

package com.yurkin;

public class Octagon {
    private double innerRadius;

    public Octagon(double innerRadius) {
        this.innerRadius = innerRadius;
    }

    public void setInnerRadius(double innerRadius) {
        // Метод для установки значения внутреннего радиуса
        this.innerRadius = innerRadius;
    }

    public double getInnerRadius() {
        // Метод для получения значения внутреннего радиуса
        return innerRadius;
    }

    public double calculateArea() {
        // Метод для вычисления площади восьмиугольника
        return 2 * (1 + Math.sqrt(2)) * Math.pow(innerRadius, 2);
    }

    public double calculatePerimeter() {
        // Метод для вычисления периметра восьмиугольника
        return 8 * innerRadius * Math.sqrt(2);
    }

    public static void main(String[] args) {
        Octagon octagon = new Octagon(10.0);
        System.out.println("Площадь восьмиугольника: ");
        System.out.printf("%1f%n", octagon.calculateArea());
        System.out.println("Периметр восьмиугольника: ");
        System.out.printf("%1f%n", octagon.calculatePerimeter());
    }
}

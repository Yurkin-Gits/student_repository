package com.yurkin;

public class Octagon {
    private double innerRadius;

    public Octagon(double innerRadius) {
        this.innerRadius = innerRadius;
    }

    public void setInnerRadius(double innerRadius) {
        this.innerRadius = innerRadius;
    }

    public double getInnerRadius() {
        return innerRadius;
    }

    public double calculateArea() {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(innerRadius, 2);
    }

    public double calculatePerimeter() {
        return 8 * innerRadius * Math.sqrt(2);
    }

}

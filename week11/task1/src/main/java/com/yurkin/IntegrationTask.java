package com.yurkin;

import java.util.function.Function;


public class IntegrationTask implements Runnable {
    private final Function<Double, Double> function; // Функция для интегрирования
    private final double a;
    private final double b;
    private final int n;
    private double result;

    public IntegrationTask(Function<Double, Double> function, double a, double b, int n) {
        this.function = function;
        this.a = a;
        this.b = b;
        this.n = n;
    }

    public double getResult() {
        return result;
    }

    @Override
    public void run() {
        double h = (b - a) / n; // Шаг разбиения
        result = 0.0;

        for (int i = 0; i < n; i++) {
            double x = a + (i + 0.5) * h; // Середина отрезка
            result += function.apply(x) * h;
        }
    }
}

package com.yurkin;

public class HeronMethod {
    private double number;
    private double precision = 0.001;

    public HeronMethod(double number) {
        this.number = number;
    }
    public double HeronSqrt() {
        
        double guess = number / 2.0;
        double previousGuess = 0.0;
        while (Math.abs(previousGuess - guess) > precision){
            previousGuess = guess;
            guess = (previousGuess + number / previousGuess) / 2.0;
        } 
        return guess;
    }
}

package com.yurkin;

public class Pyramid {
    public int height;

    public Pyramid(int height) {
        this.height = height;
    }

    public void printPyramid() {
        for (int i = 1; i <= height; i++) {
            for (int j = 0; j < height - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }
            System.out.print("  ");
            for (int j = 0; j < i; j++) {
                System.out.print("#");
            }

            System.out.println();
        }
    }
}

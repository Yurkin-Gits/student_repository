package com.yurkin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите высоту пирамиды: ");
        int height = scanner.nextInt();
        scanner.close();

        Pyramid pyramid = new Pyramid(height);
        pyramid.printPyramid();
    }
}
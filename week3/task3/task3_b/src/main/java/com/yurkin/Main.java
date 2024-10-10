package com.yurkin;

import java.util.Scanner;

public class Main {
    public static void printArray(double[] array) {
        for (double num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов массива: ");
        int size = scanner.nextInt();
        double[] array = new double[size];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextDouble();
        }

        System.out.println("Исходный массив:");
        printArray(array);
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(array);
        System.out.println("Отсортированный массив:");
        printArray(array);
    }
}

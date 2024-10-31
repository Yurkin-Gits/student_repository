package com.yurkin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        
        System.out.print("Введите количество элементов в массиве: ");
        int count = read.nextInt();
        int[] inputArray = new int[count];
        System.out.println("Введите элементы массива (целые числа): ");
        for (int i = 0; i < count; i++) {
            inputArray[i] = read.nextInt();
        }

        int[] uniqueArray = RemoveDuplicates.removeDuplicates(inputArray);
        System.out.print("Массив без дубликатов: \n");
        for (int num : uniqueArray) {
            System.out.print(num + " ");
        }

        System.out.print('\n');;
        read.close();
    }
}

package com.yurkin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String line = read.nextLine();

        System.out.println(Processor.findMostFrequentChar(line));
    }

}

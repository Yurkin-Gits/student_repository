package com.yurkin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ввод:");
        String input = scanner.nextLine();
        String result = StringProcessing.process(input);
        System.out.println("Вывод:");
        System.out.println(result);
        
        scanner.close();
    }
}

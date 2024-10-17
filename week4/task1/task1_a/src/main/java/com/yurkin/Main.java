package com.yurkin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StringChecker checker = new StringChecker();
        String target = scanner.nextLine();
        if (target == null || target.trim().isEmpty()) {
            System.out.println("Ошибка: строка для поиска не должна быть пустой!");
            scanner.close();
            return;
        }

        System.out.print("Количество строк: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
        
        if (n == 0 || strings.length == 0) {
            System.out.println("Ошибка: массив строк не должен быть пустым!");
            scanner.close();
            return;
        }

        int occurrences = checker.findOccurrences(target, strings);
        System.out.println(occurrences);

        scanner.close();
    }
}

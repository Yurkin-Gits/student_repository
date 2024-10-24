package com.yurkin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сообщение:");
        String message = scanner.nextLine();
        System.out.println("Выберите тип для преобразования:");
        System.out.println("1 - в byte");
        System.out.println("2 - в short");
        System.out.println("3 - в int");
        System.out.println("4 - в long");
        System.out.println("5 - в float");
        System.out.println("6 - в double");
        System.out.println("7 - в char");
        System.out.println("8 - в boolean");
        int option = scanner.nextInt();

        Object result = Converter.convert(message, option);

        if (result != null) {
            System.out.println("Результат преобразования: " + result + " (тип: " + result.getClass().getSimpleName() + ")");
        }
        scanner.close();
    }
}

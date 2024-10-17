package com.yurkin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите адрес электронной почты: ");
        String email = scanner.nextLine();

        EmailChecker checker = new EmailChecker();
        if (checker.isValid(email)) {
            System.out.println("Это валидный адрес электронной почты.");
        } else {
            System.out.println("Невалидный адрес электронной почты.");
        }

        scanner.close();
    }
}

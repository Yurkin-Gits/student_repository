package com.yurkin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите IPv6 адрес: ");
        String input = scanner.nextLine();

        IPChecker checker = new IPChecker();
        if (checker.validate(input)) {
            System.out.println("Введённый IPv6 адрес корректен.");
        } else {
            System.out.println("Введённый IPv6 адрес некорректен.");
        }
        
        scanner.close();
    }
}



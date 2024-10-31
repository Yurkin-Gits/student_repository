package com.yurkin;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        System.out.print("Введите все числа через пробел: ");
        String input = read.nextLine();

        List<List<Integer>> result = PermProcessor.perms(input);
        System.out.println("Перестановки: " + result);
        read.close();
    }
}

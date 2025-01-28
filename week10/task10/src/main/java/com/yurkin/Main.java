package com.yurkin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackInterface<Integer> stack = new StackClass<>();

        while (true) {
            System.out.println("\nВыберите операцию:");
            System.out.println("1. Добавить элемент в стек");
            System.out.println("2. Удалить элемент из стека");
            System.out.println("3. Просмотреть верхний элемент");
            System.out.println("4. Проверить, пуст ли стек");
            System.out.println("5. Узнать размер стека");
            System.out.println("6. Выйти из программы");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    // Добавление элемента в стек
                    System.out.print("Введите элемент для добавления: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    System.out.println("Элемент " + element + " добавлен в стек.");
                }

                case 2 -> {
                    // Удаление элемента из стека
                    try {
                        int poppedElement = stack.pop();
                        System.out.println("Удаленный элемент: " + poppedElement);
                    } catch (IllegalStateException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                }

                case 3 -> {
                    // Просмотр верхнего элемента
                    try {
                        int topElement = stack.peek();
                        System.out.println("Верхний элемент: " + topElement);
                    } catch (IllegalStateException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                }

                case 4 -> // Проверка, пуст ли стек
                    System.out.println("Стек пустой? " + stack.isEmpty());

                case 5 -> // Получение размера стека
                    System.out.println("Размер стека: " + stack.size());

                case 6 -> {
                    System.out.println("Программа завершена.");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
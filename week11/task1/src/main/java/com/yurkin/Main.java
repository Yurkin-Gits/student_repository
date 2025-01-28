package com.yurkin;

import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("Выберите функцию для интегрирования:");
            System.out.println("1. sin(x)");
            System.out.println("2. x^2");
            System.out.println("3. e^x");
            System.out.println("4. cos(x)");
            System.out.print("Ваш выбор: ");

            int choice = scanner.nextInt();

            Function<Double, Double> function;
            switch (choice) {
                case 1 -> function = x -> Math.sin(x);
                case 2 -> function = x -> x * x;
                case 3 -> function = x -> Math.exp(x);
                case 4 -> function = x -> Math.cos(x);
                default -> {
                    System.out.println("Неверный выбор! Программа завершена.");
                    scanner.close();
                    return;
                }
            }

            // Ввод пределов интегрирования
            System.out.print("Введите нижний предел интегрирования (a): ");
            double a = scanner.nextDouble();
            System.out.print("Введите верхний предел интегрирования (b): ");
            double b = scanner.nextDouble();

            System.out.print("Введите количество разбиений (n): ");
            int n = scanner.nextInt();

            System.out.print("Введите количество потоков: ");
            int numThreads = scanner.nextInt();

            if (n <= 0 || numThreads <= 0) {
                System.out.println("Количество разбиений и потоков должно быть положительным числом!");
                scanner.close();
                return;
            }

            long startTime = System.nanoTime();
            double step = (b - a) / numThreads; 
            Thread[] threads = new Thread[numThreads];
            IntegrationTask[] tasks = new IntegrationTask[numThreads];

            // Создаем и запускаем потоки
            for (int i = 0; i < numThreads; i++) {
                double start = a + i * step;
                double end = (i == numThreads - 1) ? b : start + step;
                tasks[i] = new IntegrationTask(function, start, end, n / numThreads);
                threads[i] = new Thread(tasks[i]);
                threads[i].start();
            }

            // Ожидаем завершения всех потоков
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    System.out.println("Поток был прерван: " + e.getMessage());
                }
            }
            
            // Суммируем результаты всех потоков
            double totalArea = 0.0;
            for (IntegrationTask task : tasks) {
                totalArea += task.getResult();
            }

            long endTime = System.nanoTime();
            double duration = (endTime - startTime) / 1_000_000.0;
            System.out.println("Площадь криволинейной трапеции: " + totalArea);
            System.out.println("Время выполнения: " + duration + " мс");
        }
    }
}

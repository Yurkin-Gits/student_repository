package com.yurkin;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeatherCheck weatherCheck = new WeatherCheck();

        System.out.println("Введите день недели:");
        weatherCheck.day = scanner.nextLine();

        System.out.println("Введите температуру (жарко/тепло/холодно):");
        weatherCheck.temperature = scanner.nextLine();

        System.out.println("Введите осадки (ясно/облачно/дождь/снег/град):");
        weatherCheck.precipitation = scanner.nextLine();

        System.out.println("Есть ли ветер? (да/нет):");
        weatherCheck.windy = scanner.nextLine();

        System.out.println("Введите влажность (высокая/низкая):");
        weatherCheck.humidity = scanner.nextLine();

        scanner.close();

        boolean canPlay = weatherCheck.weatherIsGood();

        if (canPlay) {
            System.out.println("Вы должны поиграть в бадминтон!");
        } else {
            System.out.println("Нет, вам нельзя играть в бадминтон :(");
        }
    }
}
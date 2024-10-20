package com.yurkin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ввод:");
        String input = scanner.nextLine();
        if (input.length() > 512) {
            System.out.println("Ошибка: строка слишком длинная.");
            return;
        }

        String[] readings = input.split("@");
        DataOfSensors[] sensors = new DataOfSensors[readings.length];

        for (int i = 0; i < readings.length; i++) {
            try {
                String idStr = readings[i].substring(0, 2);
                String tempStr = readings[i].substring(2);
                int id = Integer.parseInt(idStr);
                int temp = Integer.parseInt(tempStr);
                sensors[i] = new DataOfSensors(id, temp);

            } catch (Exception e) {
                System.out.println("Ошибка: неверный формат входных данных.");
                return;
            }
        }

        System.out.println("Сортировать по ID (id) или по средней температуре (temp)?:");
        String sortOption = scanner.nextLine().trim().toLowerCase();

        for (DataOfSensors sensor : sensors) {
            sensor.calculateAverageTemp();
        }

        if (sortOption.equals("id")) {
            sortById(sensors);
        } else if (sortOption.equals("temp")) {
            sortByTemp(sensors);
        } else {
            System.out.println("Ошибка: неверный выбор сортировки.");
            return;
        }

        for (DataOfSensors sensor : sensors) {
            System.out.println(sensor.getId() + " " + sensor.getAverageTemp());
        }
    }

    // Сортировка по ID
    public static void sortById(DataOfSensors[] sensors) {
        for (int i = 0; i < sensors.length - 1; i++) {
            for (int j = i + 1; j < sensors.length; j++) {
                if (sensors[i].getId() > sensors[j].getId()) {
                    DataOfSensors temp = sensors[i];
                    sensors[i] = sensors[j];
                    sensors[j] = temp;
                }
            }
        }
    }

    // Сортировка по средней температуре
    public static void sortByTemp(DataOfSensors[] sensors) {
        for (int i = 0; i < sensors.length - 1; i++) {
            for (int j = i + 1; j < sensors.length; j++) {
                if (sensors[i].getAverageTemp() > sensors[j].getAverageTemp()) {
                    DataOfSensors temp = sensors[i];
                    sensors[i] = sensors[j];
                    sensors[j] = temp;
                }
            }
        }
    }
}
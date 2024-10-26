package com.yurkin;

import java.util.Scanner;

import com.yurkin.exceptions.InvalidSortOptionException;
import com.yurkin.exceptions.SensorIDOutOfRangeException;
import com.yurkin.exceptions.TemperatureOutOfRangeException;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ввод:");
        String input = scanner.nextLine();

        String[] readings = input.split("@");
        DataOfSensors[] sensors = new DataOfSensors[readings.length];

        for (int i = 0; i < readings.length; i++) {
            String idStr = readings[i].substring(0, 2);
            String tempStr = readings[i].substring(2);

            try {
                int id = Integer.parseInt(idStr);
                int temp = Integer.parseInt(tempStr);

                if (id < 0 || id > 99) {
                    throw new SensorIDOutOfRangeException("Ошибка: некорректный ID сенсора - " + id);
                }
                if (temp < -50 || temp > 50) {
                    throw new TemperatureOutOfRangeException("Ошибка: температура выходит за пределы диапазона - " + temp);
                }

                sensors[i] = new DataOfSensors(id, temp);

            } catch (NumberFormatException e) {
                System.out.println("Ошибка: некорректные данные.");
                return;
            } catch (SensorIDOutOfRangeException | TemperatureOutOfRangeException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        System.out.println("Сортировать по ID (id) или по средней температуре (temp)?:");
        String sortOption = scanner.nextLine().trim().toLowerCase();

        for (DataOfSensors sensor : sensors) {
            sensor.calculateAverageTemp();
        }

        try {
            if (sortOption.equals("id")) {
                sortById(sensors);
            } else if (sortOption.equals("temp")) {
                sortByTemp(sensors);
            } else {
                throw new InvalidSortOptionException("Ошибка: неверный выбор сортировки - " + sortOption);
            }
        } catch (InvalidSortOptionException e) {
            System.out.println(e.getMessage());
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

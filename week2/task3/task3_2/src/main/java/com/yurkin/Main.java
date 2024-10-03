package com.yurkin;

// Главный класс программы
public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine(150);
        Car car = new Car("Toyota", engine);
        Passenger passenger1 = new Passenger("Алиса");
        Passenger passenger2 = new Passenger("Сергей");
        Passenger passenger3 = new Passenger("Геннадий");

        // Добавление пассажиров в автомобиль
        car.addPassenger(passenger1);
        car.addPassenger(passenger2);
        car.addPassenger(passenger3);
        car.displayInfo();
        car.removePassenger(passenger1);
        car.displayInfo();
    }
}

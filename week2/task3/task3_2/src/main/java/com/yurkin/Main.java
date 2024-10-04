package com.yurkin;

public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine(125);
        Car car = new Car("BMW", engine);
        Passenger passenger1 = new Passenger("Алиса");
        Passenger passenger2 = new Passenger("Сергей");
        Passenger passenger3 = new Passenger("Геннадий");
        car.addPassenger(passenger1);
        car.addPassenger(passenger2);
        car.addPassenger(passenger3);
        car.removePassenger(passenger1);
        car.info();
    }
}

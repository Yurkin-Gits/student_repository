package com.yurkin;

// Класс Car, представляющий автомобиль
class Car {
    private final String model; 
    private final Engine engine; 
    private Passenger passenger1; 
    private Passenger passenger2;

    // Конструктор для создания нового объекта автомобиля
    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public void addPassenger(Passenger passenger) {
        // Метод для добавления пассажира в автомобиль
        if (passenger1 == null) {
            passenger1 = passenger;
            System.out.println(passenger.getName() + " добавлен как первый пассажир.");
        } else if (passenger2 == null) {
            passenger2 = passenger;
            System.out.println(passenger.getName() + " добавлен как второй пассажир.");
        } else {
            System.out.println("Автомобиль полон. Нельзя добавить больше пассажиров.");
        }
    }

    public void removePassenger(Passenger passenger) {
        // Метод для удаления пассажира из автомобиля
        if (passenger1 != null && passenger1.getName().equals(passenger.getName())) {
            passenger1 = null;
            System.out.println("Первый пассажир " + passenger.getName() + " удален из автомобиля.");
        } else if (passenger2 != null && passenger2.getName().equals(passenger.getName())) {
            passenger2 = null;
            System.out.println("Второй пассажир " + passenger.getName() + " удален из автомобиля.");
        } else {
            System.out.println("Пассажира с таким именем нет в автомобиле.");
        }
    }


    public void displayInfo() {
        // Метод для вывода информации об автомобиле и пассажирах
        System.out.println("Модель автомобиля: " + model);
        System.out.println("Мощность двигателя: " + engine.getPower() + " л.с.");
        if (passenger1 != null) {
            System.out.println("Первый пассажир: " + passenger1.getName());
        } else {
            System.out.println("Первый пассажир: отсутствует");
        }
        if (passenger2 != null) {
            System.out.println("Второй пассажир: " + passenger2.getName());
        } else {
            System.out.println("Второй пассажир: отсутствует");
        }
    }
}
package com.yurkin;

// Класс Passenger, представляющий пассажира автомобиля
class Passenger {
    private final String name;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
    // Метод для получения имени пассажира
        return name;
    }
}

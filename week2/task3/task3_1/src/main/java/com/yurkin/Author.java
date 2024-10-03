package com.yurkin;

public class Author {
    private String name;
    private int birthYear;
    
    public Author(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        // Метод для получения имени автора
        return name;
    }

    public void setName(String name) {
        // Метод для установки имени автора
        this.name = name;
    }

    public int getBirthYear() {
        // Метод для получения года рождения автора
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        // Метод для установки года рождения автора
        this.birthYear = birthYear;
    }
}
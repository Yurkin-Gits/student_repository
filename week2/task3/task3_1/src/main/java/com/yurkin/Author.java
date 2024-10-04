package com.yurkin;

public class Author {
    private String name;
    private int birthYear;
    
    public Author(String name, int birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }
    @Override
    public String toString() {
        return String.format("Автор: %s (%d года рождения)", name, birthYear);
    }
}
package com.yurkin;

class Person {
    private String name;
    private int age; 
    private String city;

    public Person() {
        this.name = "Unknown";  
        this.age = 0;          
        this.city = "Unknown"; 
    }

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public void setName(String name) {
        // Метод для установки имени
        this.name = name;
    }

    public String getName() {
        // Метод для получения имени
        return name;
    }

    public void setAge(int age) {
        // Метод для установки возраста
        this.age = age;
    }

    public int getAge() {
        // Метод для получения возраста
        return age;
    }

    public void setCity(String city) {
        // Метод для установки города
        this.city = city;
    }

    public String getCity() {
        // Метод для установки города
        return city;
    }

    public void printPersonInfo() {
        // Метод для вывода информации о человеке на экран
        System.out.println("Name: " + this.name + ", Age: " + this.age + ", City: " + this.city);
    }
}

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person();

        Person person2 = new Person("Alice", 25, "Moscow");
        Person person3 = new Person("Boris", 35, "Vladivostok");

        person1.setName("Roman");
        person1.setAge(20);
        person1.setCity("Penza");

        person1.printPersonInfo();
        person2.printPersonInfo();
        person3.printPersonInfo();
    }
}

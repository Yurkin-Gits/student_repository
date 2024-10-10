package com.yurkin;

public class Declension {
    private  int age;

    public Declension(int age) {
        this.age = age;
    }

    public String getDeclenction() {
        if (age % 100 <= 19 && age % 100 >= 11) {
            return "лет";
        }
        switch (age % 10) {
            case 1:
                return "год";
            case 2:
            case 3:
            case 4:
                return "года";
            default:
                return "лет";
        }
    }

    public String ageWithDeclention() {
        return age + " " + getDeclenction();
    }
}

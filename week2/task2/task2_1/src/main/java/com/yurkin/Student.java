package com.yurkin;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Student {

    private String name;
    private LocalDate birthDate;
    private String group;
    private int studentId;
    private double averageScore;

    public Student(String name, LocalDate birthDate, String group, int studentId, double averageScore) {
        this.name = name;
        this.birthDate = birthDate;
        this.group = group;
        this.studentId = studentId;
        this.averageScore = averageScore;
    }

    public String getName() {
        // Метод получения имени студента
        return name;
    }

    public void setName(String name) {
        // Метод установки имени студента
        this.name = name;
    }

    public LocalDate getBirthDate() {
        // Метод получения даты рождения студента
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        // Метод установки даты рождения студента
        this.birthDate = birthDate;
    }

    public String getGroup() {
        // Метод получения группы студента
        return group;
    }

    public void setGroup(String group) {
        // Метод установки группы студента
        this.group = group;
    }

    public int getStudentId() {
        // Метод получения id студента
        return studentId;
    }

    public void setStudentId(int studentId) {
        // Метод установки id студента
        this.studentId = studentId;
    }

    public double getAverageScore() {
        // Метод получения среднего балла студента
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        // Метод установки среднего балла студента
        this.averageScore = averageScore;
    }

    public int getAge() {
        // Метод для вычисления возраста студента в целых годах
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "Студент: " + name + "\n" +
               "Дата рождения: " + birthDate.format(formatter) + "\n" +
               "Группа: " + group + "\n" +
               "ID студента: " + studentId + "\n" +
               "Средний балл: " + averageScore;
    }

    public boolean isExcellentStudent() {
        return averageScore >= 4.8;
    }

    public static void main(String[] args) {
        // Создание объектов класса Student
        Student student1 = new Student("Петр Петров", LocalDate.of(2004, 4, 15), "22ИБ1б", 12015, 4.9);
        Student student2 = new Student("Александра Александровна", LocalDate.of(2005, 8, 30), "23ИД1б", 14675, 4.5);

        System.out.println(student1);
        System.out.println("Возраст: " + student1.getAge());
        System.out.println("Отличник: " + student1.isExcellentStudent());
        System.out.println();

        System.out.println(student2);
        System.out.println("Возраст: " + student2.getAge());
        System.out.println("Отличник: " + student2.isExcellentStudent());
    }
}

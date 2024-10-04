package com.yurkin;

import java.time.LocalDate;

public class Main {
        public static void main(String[] args) {
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
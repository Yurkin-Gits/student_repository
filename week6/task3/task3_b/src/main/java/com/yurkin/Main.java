package com.yurkin;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        int studentCount = Integer.parseInt(read.nextLine());

        List<Student> students = new ArrayList<>();
        Queue<String> languageQueue = new LinkedList<>();

        for (int i = 0; i < studentCount; i++) {
            int languageCount = Integer.parseInt(read.nextLine());

            for (int j = 0; j < languageCount; j++) {
                languageQueue.add(read.nextLine());
            }

            students.add(new Student(languageQueue));
            languageQueue.clear();
        }

        Set<String> basedLanguages = new HashSet<>();
        Set<String> allLanguages = new HashSet<>();

        SchoolLanguages.calculateLanguages(students, basedLanguages, allLanguages);

        List<String> sortedBasedLanguages = SchoolLanguages.getSortedBasedLanguages(basedLanguages);
        System.out.println(sortedBasedLanguages.size());
        for (String language : sortedBasedLanguages) {
            System.out.println(language);
        }

        List<String> sortedAllLanguages = SchoolLanguages.getSortedAllLanguages(allLanguages);
        System.out.println(sortedAllLanguages.size());
        for (String language : sortedAllLanguages) {
            System.out.println(language);
        }

        read.close();
    }
}

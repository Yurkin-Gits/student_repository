package com.yurkin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class SchoolLanguages {
    public static void calculateLanguages(List<Student> students, Set<String> basedLanguages, Set<String> allLanguages) {
        if (!students.isEmpty()) {
            basedLanguages.addAll(students.get(0).getLanguages());

            for (Student student : students) {
                basedLanguages.retainAll(student.getLanguages());
                allLanguages.addAll(student.getLanguages());
            }
        }
    }

    public static List<String> getSortedBasedLanguages(Set<String> basedLanguages) {
        List<String> sortedBasedLanguages = new ArrayList<>(basedLanguages);
        Collections.sort(sortedBasedLanguages);
        return sortedBasedLanguages;
    }

    public static List<String> getSortedAllLanguages(Set<String> allLanguages) {
        List<String> sortedAllLanguages = new ArrayList<>(allLanguages);
        Collections.sort(sortedAllLanguages);
        return sortedAllLanguages;
    }
}

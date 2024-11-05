package com.yurkin;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Student {
    private Set<String> languages;

    public Student(Queue<String> languageQueue) {
        this.languages = new HashSet<>(languageQueue);
    }

    public Set<String> getLanguages() {
        return languages;
    }
}

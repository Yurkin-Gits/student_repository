package com.yurkin;

class StringChecker {
    public int findOccurrences(String target, String[] strings) {
        int count = 0;

        for (String str : strings) {
            if (str == null || str.isEmpty()) {
                System.out.println("Ошибка: найдена пустая строка, пропускаем её.");
                continue;
            }
            if (str.length() < target.length()) {
                System.out.println("Предупреждение: строка короче целевой подстроки, пропускаем её.");
                continue;
            }
            
            for (int i = 0; i <= str.length() - target.length(); i++) {
                if (str.substring(i, i + target.length()).equals(target)) {
                    count++;
                }
            }
        }

        return count;
    }
}

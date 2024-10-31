package com.yurkin;

import java.util.ArrayList;
import java.util.List;

public class PermProcessor {
    public static List<List<Integer>> perms(String input) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for (String s : input.split(" ")) {
            numbers.add(Integer.parseInt(s.trim()));
        }
        createPerm(numbers, 0, result);
        return result;
    }

    private static void createPerm(List<Integer> numbers, int index, List<List<Integer>> result) {
        if (index == numbers.size() - 1) {
            result.add(new ArrayList<>(numbers));
            return;
        }

        for (int i = index; i < numbers.size(); i++) {
            List<Integer> temp = new ArrayList<>(numbers);
            temp.set(index, numbers.get(i));
            temp.set(i, numbers.get(index));
            createPerm(temp, index + 1, result);
        }
    }
}

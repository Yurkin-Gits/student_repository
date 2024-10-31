package com.yurkin;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class RemoveDuplicates {
    public static int[] removeDuplicates(int[] array) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int num : array) {
            if (set.add(num)) {
                queue.add(num);
            }
        }

        int[] resultArray = new int[queue.size()];
        int index = 0;
        while (!queue.isEmpty()) {
            resultArray[index++] = queue.poll();
        }

        return resultArray;
    }
}

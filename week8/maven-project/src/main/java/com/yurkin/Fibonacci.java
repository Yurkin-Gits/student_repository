package com.yurkin;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class Fibonacci {
    private static final Map<Integer, Long> memory = new HashMap<>();

    public static long recursive(int n) {
        if (n <= 1) {
            return n;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    public static long optimized(int n) {
        if (n <= 1) {
            return n;
        }
        if (memory.containsKey(n)) {
            return memory.get(n);
        }
        long result = optimized(n - 1) + optimized(n - 2);
        memory.put(n, result);
        return result;
    }
}

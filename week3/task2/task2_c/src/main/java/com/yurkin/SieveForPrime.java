package com.yurkin;

public class SieveForPrime {
    public static int limit;

    public static void printPrimes() {
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}


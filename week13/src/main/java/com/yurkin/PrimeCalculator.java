package com.yurkin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class PrimeCalculator {

    public static List<Integer> findPrimesWorkStealing(int start, int end) throws InterruptedException, ExecutionException {
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newWorkStealingPool(numThreads);

        List<CompletableFuture<List<Integer>>> futures = new ArrayList<>();
        int rangeSize = (end - start) / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int rangeStart = start + i * rangeSize;
            int rangeEnd = (i == numThreads - 1) ? end : rangeStart + rangeSize;
            futures.add(CompletableFuture.supplyAsync(() -> {
                List<Integer> primes = new ArrayList<>();
                for (int n = rangeStart; n < rangeEnd; n++) {
                    if (PrimeChecker.isPrime(n)) {
                        primes.add(n);
                    }
                }
                return primes;
            }, executor));
        }

        List<Integer> primes = futures.stream()
            .flatMap(future -> future.join().stream())
            .sorted()
            .collect(Collectors.toList());

        executor.shutdown();
        return primes;
    }

    public static List<Integer> findPrimesShuffle(int start, int end) throws InterruptedException, ExecutionException {
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);

        List<Integer> numbers = new ArrayList<>();
        for (int i = start; i < end; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        List<CompletableFuture<List<Integer>>> futures = new ArrayList<>();
        int rangeSize = numbers.size() / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int rangeStart = i * rangeSize;
            int rangeEnd = (i == numThreads - 1) ? numbers.size() : rangeStart + rangeSize;
            futures.add(CompletableFuture.supplyAsync(() -> {
                List<Integer> primes = new ArrayList<>();
                for (int n = rangeStart; n < rangeEnd; n++) {
                    if (PrimeChecker.isPrime(numbers.get(n))) {
                        primes.add(numbers.get(n));
                    }
                }
                return primes;
            }, executor));
        }

        List<Integer> primes = futures.stream()
            .flatMap(future -> future.join().stream())
            .sorted()
            .collect(Collectors.toList());

        executor.shutdown();
        return primes;
    }
}
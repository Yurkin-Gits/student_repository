package com.yurkin;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FibonacciTest {

    @Test
    public void testRecursiveFibonacci() {
        assertEquals("Fibonacci(0) должен быть равен 0", 0, Fibonacci.recursive(0));
        assertEquals("Fibonacci(1) должен быть равен 1", 1, Fibonacci.recursive(1));
        assertEquals("Fibonacci(2) должен быть равен 1", 1, Fibonacci.recursive(2));
        assertEquals("Fibonacci(3) должен быть равен 2", 2, Fibonacci.recursive(3));
        assertEquals("Fibonacci(4) должен быть равен 3", 3, Fibonacci.recursive(4));
        assertEquals("Fibonacci(5) должен быть равен 5", 5, Fibonacci.recursive(5));
    }

    @Test
    public void testOptimizedFibonacci() {
        assertEquals("Fibonacci(0) должен быть равен 0", 0, Fibonacci.optimized(0));
        assertEquals("Fibonacci(1) должен быть равен 1", 1, Fibonacci.optimized(1));
        assertEquals("Fibonacci(2) должен быть равен 1", 1, Fibonacci.optimized(2));
        assertEquals("Fibonacci(3) должен быть равен 2", 2, Fibonacci.optimized(3));
        assertEquals("Fibonacci(4) должен быть равен 3", 3, Fibonacci.optimized(4));
        assertEquals("Fibonacci(5) должен быть равен 5", 5, Fibonacci.optimized(5));
        assertEquals("Fibonacci(10) должен быть равен 55", 55, Fibonacci.optimized(10));
        assertEquals("Fibonacci(20) должен быть равен 6765", 6765, Fibonacci.optimized(20));
    }
}


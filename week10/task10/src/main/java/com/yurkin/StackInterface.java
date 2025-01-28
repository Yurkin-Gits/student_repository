package com.yurkin;

public interface StackInterface<T> {
    void push(T element);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
}
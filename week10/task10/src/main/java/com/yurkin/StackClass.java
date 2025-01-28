package com.yurkin;

import java.util.ArrayList;

public class StackClass<T> implements StackInterface<T> {
    private final ArrayList<T> elements;

    public StackClass() {
        elements = new ArrayList<>();
    }

    @Override
    public void push(T element) {
        elements.add(element);
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пустой");
        }
        return elements.remove(elements.size() - 1);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пустой");
        }
        return elements.get(elements.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    @Override
    public int size() {
        return elements.size();
    }
}
package com.yurkin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class StackTest {

    @Test
    public void testIntegerStack() {
        StackInterface<Integer> stack = new StackClass<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop(), "Ошибка: извлечённый элемент не равен 30");
        assertEquals(20, stack.pop(), "Ошибка: извлечённый элемент не равен 20");
        assertEquals(10, stack.pop(), "Ошибка: извлечённый элемент не равен 10");
    }

    @Test
    public void testStringStack() {
        StackInterface<String> stack = new StackClass<>();
        stack.push("Hello");
        stack.push("World");

        assertEquals("World", stack.pop(), "Ошибка: извлечённый элемент не равен 'World'");
        assertEquals("Hello", stack.pop(), "Ошибка: извлечённый элемент не равен 'Hello'");
    }

    @Test
    public void testEdgeCases() {
        StackInterface<Integer> stack = new StackClass<>();

        assertThrows(IllegalStateException.class, stack::pop, "Ошибка: pop() из пустого стека не выбросил исключение");
        assertThrows(IllegalStateException.class, stack::peek, "Ошибка: peek() из пустого стека не выбросил исключение");

        stack.push(42);
        assertEquals(42, stack.pop(), "Ошибка: извлечённый элемент не равен 42");
    }
}

package com.codecool.si1;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {


    @Test
    void testPop() {
        Stack<Integer> stack = new Stack<>(3);
        Integer expected = 2137;

        stack.push(2137);

        assertEquals(expected, stack.pop());
    }

    @Test
    void testPop_EmptyStack() {
        Stack<Integer> stack = new Stack<>(3);

        assertThrows(EmptyStackException.class, () -> {
            stack.pop();
        });
    }

    @Test
    void testPush(){
        Stack<Integer> stack = new Stack<>(4);
        Integer expected = 7;

        stack.push(expected);

        assertEquals(expected, stack.peek());
    }

    @Test
    void testPush_FullStack() {
        Stack<Integer> stack = new Stack<>(2);
        stack.push(2137);
        stack.push(1488);


        assertThrows(StackOverflowError.class, () -> {
            stack.push(123);
        });
    }


    @Test
    void testGetFreeSpaces() {
        Stack<Integer> stack = new Stack<>(6);
        stack.push(2137);
        stack.push(1488);
        int expected = 4;

        int freeSpaces = stack.getFreeSpaces();

        assertEquals(expected, freeSpaces);
    }


    @Test
    void testPeekNotDeletesLastItem() {
        Stack<Integer> stack = new Stack<>(4);
        stack.push(1);
        stack.push(2);
        Integer expected = 3;
        stack.push(expected);

        stack.peek();

        assertEquals(expected, stack.peek());
    }

    @Test
    void testPeekFromEmptyStack() {
        Stack<Integer> stack = new Stack<>(2137);

        assertNull(stack.peek());
    }

    @Test
    void testGetSize() {
        int expected = 2137;
        Stack<Integer> stack = new Stack<>(expected);

        int size = stack.getSize();

        assertEquals(expected, size);
    }
}
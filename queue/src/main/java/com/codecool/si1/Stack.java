package com.codecool.si1;

import java.util.EmptyStackException;

public class Stack<E> {
    private int size;
    private int freeSpaces;
    private E[] items;

    Stack(int size) {
        this.size = size;
        this.freeSpaces = size;
        this.items = (E[]) new Object[size];
    }

    void push(E item) {
        if (freeSpaces > 0) {
            int index = size - freeSpaces;
            this.items[index] = item;
            freeSpaces--;
        } else {
            throw new StackOverflowError("Stack is full!");
        }
    }

    E pop() {
        if (freeSpaces < size) {
            freeSpaces++;
            return items[size-freeSpaces];
        } else {
            throw new EmptyStackException();
        }
    }

    E peek() {
        return freeSpaces == size ? items[size-freeSpaces] : items[size-freeSpaces-1];
    }

    public int getFreeSpaces() {
        return freeSpaces;
    }

    public int getSize() {
        return size;
    }

}

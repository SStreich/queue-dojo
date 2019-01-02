package com.codecool.si1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomQueueTest {

    @Test
    void testEnqueue() {
        CustomQueue queue = new CustomQueue();
        String expected = "Random value";

        queue.enqueue(expected);

        assertEquals(expected, queue.peek());
    }

    @Test
    void testEnqueueThrowsExceptionIfNull() {
        CustomQueue queue = new CustomQueue();

        assertThrows(IllegalArgumentException.class, () -> {
            queue.enqueue(null);
        });
    }

    @Test
    void testDequeue() {
        CustomQueue queue = new CustomQueue();
        String expected = "Dark string of death";
        queue.enqueue("Random value");
        queue.enqueue(expected);

        queue.dequeue();

        assertEquals(expected, queue.dequeue());
    }

    @Test
    void testDequeueIfQueueIsEmpty() {
        CustomQueue queue = new CustomQueue();

        assertNull(queue.dequeue());
    }

    @Test
    void testPeek() {
        CustomQueue queue = new CustomQueue();
        String expected = "Random value";
        queue.enqueue(expected);
        queue.enqueue("Whatever");


        String actual = queue.peek();

        assertEquals(expected, actual);
    }

    @Test
    void testPeekIfQueueIsEmpty() {
        CustomQueue queue = new CustomQueue();

        assertNull(queue.peek());
    }

    @Test
    void testEnqueuePriorityMode() {
        CustomQueue queue = new CustomQueue();
        queue.enqueue("Head", 0);
        queue.enqueue("More important", 2);

        String actual = queue.peek();

        assertEquals("More important", actual);
    }
}
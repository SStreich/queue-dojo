package com.codecool.si1;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SimplyLinkedListTest {

    private SimplyLinkedList<String> linkedList = new SimplyLinkedList<>();

    @Test
    void testAddingToLinkedList() {
        String data = "random data";

        linkedList.add(data);

        assertEquals(data, linkedList.getHead().getData());
    }

    @Test
    void testIfLinkedListCreatesHeadProperly() {
        String data = "another random data";

        linkedList.add(data);
        Node head = linkedList.getHead();

        assertNotNull(head);
    }

    @Test
    void testInsertingToLinkedList() {
        String data1 = "random dataa";
        String data2 = "another random data";
        String data3 = "one more random data";
        linkedList.add(data1);
        linkedList.add(data3);

        linkedList.insert(linkedList.getHead(), data2);
        String insertedData = linkedList.getHead().getNextNode().getData();

        assertEquals(data2, insertedData);
    }

    @Test
    void testInsertingAfterLastItem() {
        String data1 = "random data again";
        String data2 = "another randoom data";
        linkedList.add(data1);

        linkedList.insert(linkedList.getHead(), data2);
        String insertedData = linkedList.getHead().getNextNode().getData();

        assertEquals(data2, insertedData);
    }

    @Test
    void testChangingDataInNode() {
        String data = "random data tarata";
        String changedData = "changed data";
        linkedList.add(data);

        linkedList.getHead().setData(changedData);

        assertEquals(changedData, linkedList.getHead().getData());
    }

    @Test
    void testRemovingNodeFromLinkedList() {
        String data1 = "data tarata";
        linkedList.add(data1);

        linkedList.remove(linkedList.getHead());

        assertNull(linkedList.getHead());
    }

    @Test
    void testIfRemovingNodeFromEmptyListThrowsNoSuchElementException() {
        Node<String> node = new Node<>("data of independent node");

        assertThrows(NoSuchElementException.class, () -> {
           linkedList.remove(node);
        });
    }

    @Test
    void testIfRemovingNodeChangesLengthProperly() {
        Node<String> node = new Node<>("node to remoove");
        linkedList.addNode(node);
        int lengthBeforeRemove = linkedList.getLength();

        linkedList.remove(node);
        int lengthAfterRemove = linkedList.getLength();

        assertNotEquals(lengthBeforeRemove, lengthAfterRemove);
    }

    @Test
    void testGetTailIfOnlyHeadInList() {
        String data = "random data here";
        linkedList.add(data);

        SimplyLinkedList<String> tail = linkedList.getTail();

        assertEquals(0, tail.getLength());
    }

    @Test
    void testIfLinkedListDoesntChangeAfterGettingTaill() {
        String data = "random data here";
        linkedList.add(data);
        int length = linkedList.getLength();

        SimplyLinkedList<String> tail = linkedList.getTail();

        assertEquals(length, linkedList.getLength());
    }

}
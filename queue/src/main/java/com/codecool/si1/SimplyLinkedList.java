package com.codecool.si1;

import java.util.NoSuchElementException;

public class SimplyLinkedList<E> {

    private Node<E> head;
    private Node<E> last;
    private int length;

     SimplyLinkedList() {
        this.length = 0;
    }

     void add(E data) {
        Node<E> node = new Node<>(data);
        addNode(node);
        this.last = node;
    }

     void addNode(Node<E> node) {
        if (this.head == null) {
            this.head = node;
        } else {
            last.setNextNode(node);
        }
        this.last = node;
        this.length++;
    }

     void insert(Node<E> node, E dataToInsert) {
        if (node.hasNext()) {
            Node<E> nextNode = node.getNextNode();
            Node<E> nodeToInsert = new Node<>(dataToInsert);
            node.setNextNode(nodeToInsert);
            nodeToInsert.setNextNode(nextNode);
        } else {
            this.add(dataToInsert);

        }
    }

     void remove(Node<E> nodeToRemove) {
        Node node = this.getHead();
        if (length > 0) {
            if (this.head.equals(nodeToRemove)) {
                removeHead();
            } else {
                boolean isRemoved = false;
                while (!isRemoved) {

                    if (node.getNextNode().equals(nodeToRemove)) {
                        node.setNextNode(nodeToRemove.getNextNode());
                        this.last = node;
                        isRemoved = true;
                    } else if (node.equals(last)) {
                        throw new NoSuchElementException("no such element!");
                    } else {
                        Node temp = node.getNextNode();
                        node = temp;
                    }
                }
            }
            this.length--;
        } else {
            throw new NoSuchElementException("no such element!");
        }
    }

    private void removeHead() {
        Node<E> temp = this.head.getNextNode();
        this.head = temp;
    }

     Node<E> getHead() {
        return this.head;
    }

     int getLength() {
        return this.length;
    }

     SimplyLinkedList<E> getTail() {
        Node<E> node = this.getHead();
        SimplyLinkedList<E> linkedListCopy = new SimplyLinkedList<>();
        while (node.hasNext()) {
            linkedListCopy.add(node.getData());
            Node<E> temp = node.getNextNode();
            node = temp;
        }

        return linkedListCopy;
    }
}
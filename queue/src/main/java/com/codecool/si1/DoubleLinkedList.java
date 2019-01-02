package com.codecool.si1;

import java.util.NoSuchElementException;

public class DoubleLinkedList<E>{
    private DoubleNode<E> previous;
    private DoubleNode<E> head;
    private DoubleNode<E> last;
    private int length;

    DoubleLinkedList() {
        this.length = 0;
    }

    void addNode(DoubleNode<E> node) {
        if (this.head == null) {
            this.head = node;
        } else {
            last.setNextNode(node);
            node.setPreviousNode(last);
        }
        this.last = node;
        this.length++;
    }

    void add(E data) {
        DoubleNode<E> node = new DoubleNode<>(data);
        addNode(node);
    }

    void insert(DoubleNode<E> node, E dataToInsert) {
        DoubleNode<E> nodeToInsert = new DoubleNode<>(dataToInsert);
        if (node.hasNext()) {
            node.getNextNode().setPreviousNode(nodeToInsert);
            nodeToInsert.setPreviousNode(node);
            nodeToInsert.setNextNode(node.getNextNode());
            node.setNextNode(nodeToInsert);
        } else {
            this.addNode(nodeToInsert);
        }
    }

    void remove(DoubleNode<E> nodeToRemove) {
        DoubleNode node = this.getHead();
        if (length > 0) {
            if (this.head.equals(nodeToRemove)) {
                removeHead();
            } else if (!removeNodeFromTail(nodeToRemove)) {
                    throw new NoSuchElementException("no such element!");
            }
        } else {
            throw new NoSuchElementException("no such element!");
        }
    }

    private boolean removeNodeFromTail(DoubleNode<E> nodeToRemove) {
        DoubleNode node = this.getHead();
        while (!node.equals(last)) {
            if (node.getNextNode().equals(nodeToRemove)) {
                node.setNextNode(nodeToRemove.getNextNode());
                this.last = node;
                this.length--;
                return true;
            } else {
                node = node.getNextNode();
            }
        }
        return false;
    }

    private void removeHead() {
        this.head = this.head.getNextNode();
        this.length--;
        if (head != null) {
            this.head.setPreviousNode(null);
        }
    }

    DoubleNode<E> getHead() {
        return this.head;
    }

    int getLength() {
        return this.length;
    }

    DoubleLinkedList<E> getTail() {
        DoubleNode<E> node = this.getHead();
        DoubleLinkedList<E> linkedListCopy = new DoubleLinkedList<>();
        while (node.hasNext()) {
            linkedListCopy.add(node.getData());
            node = node.getNextNode();
        }

        return linkedListCopy;
    }

}

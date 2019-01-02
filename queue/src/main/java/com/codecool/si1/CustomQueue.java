package com.codecool.si1;

public class CustomQueue {

    private Node head;
    private Node tail;
    private int size;

    CustomQueue() {
        this.size = 0;
    }

    private void enqueueNode(Node item) {
        if (isEmpty()) {
            this.head = item;
            this.tail = item;
        } else if(tail.equals(head)) {
            this.head.setNextNode(item);
        }
        this.tail.setNextNode(item);
        this.tail = item;
        this.size++;
    }

    public void enqueue(String value) {
        checkArgument(value);
        enqueueNode(new Node(value));
    }

    public void enqueue(String value, Integer priority) {
        checkArgument(value);
        Node newItem = new Node(value, priority);

        if (this.head == null || this.tail.getPriority() >= newItem.getPriority()) {
            enqueueNode(newItem);
        } else {
            enqueueInPriorityMode(newItem);
        }
    }

    private void enqueueInPriorityMode(Node newItem) {
        int NEW_ITEM_PRIORITY = newItem.getPriority();
        if (this.head.getPriority() < NEW_ITEM_PRIORITY) {
            newItem.setNextNode(this.head);
            this.head = newItem;
        } else {
            Node item = this.head;
            for (int i = queueSize(); i > 1; i--) {
                if (item.getPriority() >= NEW_ITEM_PRIORITY && item.getNextNode() != null) {
                    item = item.getNextNode();
                } else if (item.getNextNode() == null) {
                    item.setNextNode(newItem);
                    tail = newItem;
                } else {
                    Node temp = item.getNextNode();
                    item.setNextNode(newItem);
                    newItem.setNextNode(temp);
                }
            }
        }
    }

    private void checkArgument(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Entered value can not be null!");
        }
    }

    public String peek() {
        if (!isEmpty()) {
            return this.head.getValue();
        } else {
            return null;
        }
    }

    public String dequeue() {
        if (!isEmpty()) {
            Node item = this.head;
            this.head = item.getNextNode();
            size--;
            return item.getValue();
        } else {
            return null;
        }
    }

    public int queueSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
}

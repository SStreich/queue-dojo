package com.codecool.si1;

 class Node<E> {
    private Node<E> nextNode;
    private E data;

    Node(E data) {
        this.data = data;
    }

     void setData(E data) {
        this.data = data;
    }

     Node<E> getNextNode() {
        return nextNode;
    }

     boolean hasNext() {
        return nextNode != null;
    }

     void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

     E getData() {
    return this.data;
    }
}

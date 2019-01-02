package com.codecool.si1;

 class DoubleNode<E> {

     private DoubleNode<E> nextNode;
     private E data;
     private DoubleNode<E> previousNode;

     DoubleNode(E data) {
         this.data = data;
     }

     void setData(E data) {
         this.data = data;
     }

     DoubleNode<E> getNextNode() {
         return nextNode;
     }

     boolean hasNext() {
         return nextNode != null;
     }

     void setNextNode(DoubleNode<E> nextNode) {
         this.nextNode = nextNode;
     }

     E getData() {
         return this.data;
     }

     DoubleNode<E> getPreviousNode() {
        return previousNode;
    }

    void setPreviousNode(DoubleNode<E> previousNode) {
        this.previousNode = previousNode;
    }
}



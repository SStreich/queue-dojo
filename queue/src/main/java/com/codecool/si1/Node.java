package com.codecool.si1;

public class Node {
    private String value;
    private Node nextNode;
    private Integer priority;

    public Node(String value){
        this.value = value;
        this.priority = 0;
    }

    public Node(String value, Integer priority) {
        this.value = value;
        this.priority = priority;
    }

    public String getValue(){
        return this.value;
    }

    public Node getNextNode(){
        return this.nextNode;
    }

    public void setNextNode(Node node) {
        this.nextNode = node;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}

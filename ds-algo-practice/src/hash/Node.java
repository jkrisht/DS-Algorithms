package hash;

import java.util.HashMap;

public class Node {
    private int key;
    private int value;
    private int hash;
    private Node next;

    public Node(int key, int value, int hash){
        this.key = key;
        this.value = value;
        this.hash = hash;
        this.next = null;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public int getHash() {
        return hash;
    }

    public Node getNext() {
        return next;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
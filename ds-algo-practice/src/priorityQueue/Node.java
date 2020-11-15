package priorityQueue;

public class Node {
    private Node previous;
    private Node next;
    private int key;

    public Node(int key){
        this.key = key;
        this.previous = null;
        this.next = null;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getNext() {
        return next;
    }

    public int getKey() {
        return key;
    }
}

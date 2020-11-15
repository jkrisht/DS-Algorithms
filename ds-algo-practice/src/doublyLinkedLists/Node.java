package doublyLinkedLists;

public class Node {
    private Node previous;
    private Node next;
    private int key;

    public Node(int key){
        this.key = key;
        this.previous = null;
        this.next = null;
    }

    public int getKey(){
        return this.key;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

package stacks;

public class Node {
    private Node next;
    private int key;

    public Node(int key){
        this.key = key;
        this.next = null;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public Node getNext(){
        return this.next;
    }

    public int getKey(){
        return this.key;
    }
}

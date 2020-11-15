package linkedLists.problems;

public class NthNodeFromTheEndOfLinkedList {

    private Node1 head;
    private Node1 tail;
    private int size;

    public static void main(String[] args) {
        NthNodeFromTheEndOfLinkedList list = new NthNodeFromTheEndOfLinkedList();
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.findNthNode(0);
    }

    public void push(int key){

        Node1 node1 = new Node1(key);

        if (!isEmpty()){
            tail.setNode(node1);
            tail = node1;
            size++;
        } else {
            head = tail = node1;
            size++;
        }
    }

    public boolean isEmpty(){
        if (head == null)
            return true;
        return false;
    }

    public void printKeys(){
        Node1 node = head;

        while (node != null){
            System.out.print(node.getKey()+" ");
            node = node.getNode();
        }
        System.out.println();
    }

    public void findNthNode(int n){
        if ( n < size){
            Node1 temp = head;

            for (int i = 1; i < size - n + 1; i++)
                temp = temp.getNode();

            if (temp != null)
                System.out.println(temp.getKey());
        }
    }
}

class Node1{
    private int key;
    private Node1 node;

    public Node1 getNode() {
        return this.node;
    }

    public void setNode(Node1 node) {
        this.node = node;
    }

    public Node1(int key){
        this.key = key;
        this.node = null;
    }

    public int getKey(){
        return this.key;
    }

}
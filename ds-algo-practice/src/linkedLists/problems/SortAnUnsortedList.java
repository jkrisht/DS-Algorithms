package linkedLists.problems;

import java.awt.event.AWTEventListener;

public class SortAnUnsortedList {
    private Node head;
    private Node tail;
    private int size;

    public static void main(String[] args) {
        SortAnUnsortedList unsortedList = new SortAnUnsortedList();
        unsortedList.push(3);
        unsortedList.push(1);
        unsortedList.push(2);
        unsortedList.push(5);
        unsortedList.push(4);
        unsortedList.print(unsortedList.head);
    }

    public void sort(){
        if (isEmpty())
            return;
        else {
            Node node = head;
            Node previous = null;
            Node next = null;

            while (node != null){

            }
        }
    }

    public void push(int key){
        Node newNode = new Node(key);

        if (isEmpty()){
            head = tail = newNode;
            size++;
        } else {
            tail.setNode(newNode);
            tail = newNode;
        }
    }

    public void print(Node node){
        while (node != null){
            System.out.println(node.getKey()+" ");
            node = node.getNode();
        }
        System.out.println();
    }

    public boolean isEmpty(){
        if (head == null)
            return true;
        return false;
    }
}

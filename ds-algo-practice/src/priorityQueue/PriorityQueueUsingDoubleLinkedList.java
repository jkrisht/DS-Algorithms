package priorityQueue;

import com.sun.xml.internal.bind.v2.runtime.AttributeAccessor;

public class PriorityQueueUsingDoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public static void main(String[] args) {
        PriorityQueueUsingDoubleLinkedList list = new PriorityQueueUsingDoubleLinkedList();

        list.push(3);
        list.push(4);
        list.push(1);
        list.push(10);
        list.push(7);
        list.push(8);
        list.push(-5);
        list.push(1);
        list.push(11);

        System.out.println(list.extract());
        System.out.println(list.extract());
        System.out.println(list.extract());
        System.out.println(list.extract());
        System.out.println(list.extract());
        System.out.println(list.extract());
        System.out.println(list.extract());
        System.out.println(list.extract());
        System.out.println(list.extract());

        list.print(list.head);
        System.out.println();
    }

    public int extract(){
        int key = Integer.MIN_VALUE;

        if (!empty()){
            key = tail.getKey();
            tail = tail.getPrevious();
            if (tail != null){
                tail.setNext(null);
            } else {
                head = tail = null;
            }
        }

        return key;
    }

    public void push(int key){
        Node node = new Node(key);

        if (empty()){
            this.head = this.tail = node;
            size++;
        } else {
            if (key < head.getKey()){
                node.setNext(head);
                head.setPrevious(node);
                head = node;
                size++;
            } else if (key > tail.getKey()){
                tail.setNext(node);
                node.setPrevious(tail);
                tail = node;
                size++;
            } else {
                Node lessNode = head;

                while (lessNode != null){
                    if (key < lessNode.getKey()){
                        lessNode = lessNode.getPrevious();
                        break;
                    }
                    lessNode = lessNode.getNext();
                }

                if (lessNode != null){
                    Node next = lessNode.getNext();

                    node.setNext(next);
                    node.setPrevious(lessNode);
                    lessNode.setNext(node);
                    next.setPrevious(node);
                    size++;
                }
            }
        }
    }

    public void print(Node node){
        while (node != null){
            System.out.print(node.getKey()+" ");
            node = node.getNext();
        }
    }

    public void printLast(Node node){
        while (node != null){
            System.out.print(node.getKey()+" ");
            node = node.getPrevious();
        }
    }

    public int getSize(){
        return this.size;
    }

    public boolean empty(){
        return this.head == null;
    }
}

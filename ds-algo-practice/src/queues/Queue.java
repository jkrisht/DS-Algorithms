package queues;

import doublyLinkedLists.Node;

public class Queue {

    private Node head;
    private Node tail;
    private int size;

    public static void main(String[] args) {
        Queue queue = new Queue();

        for (int i=0; i < 4; i++){
            queue.enqueue(i);
        }

        queue.print();

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        queue.print();
    }

    public int dequeue(){
        if (!isEmpty()){
            int key = head.getKey();
            head = head.getNext();
            size--;
            return key;
        }
        throw new RuntimeException("Queue is Empty");
    }

    public void enqueue(int key){
        Node node = new Node(key);
        if (isEmpty()){
            head = tail = node;
            size++;
        } else {
            tail.setNext(node);
            tail = node;
            size++;
        }
    }

    public void print(){
        Node node = head;
        while (node != null){
            System.out.print(node.getKey()+" ");
            node = node.getNext();
        }
        System.out.println();
    }

    public boolean isEmpty(){
        return head == null;
    }

}

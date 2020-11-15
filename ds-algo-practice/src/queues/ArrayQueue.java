package queues;

import java.util.Stack;

public class ArrayQueue {
    private int read;
    private int write;
    private int size = -1;
    private int[] queue;

    public ArrayQueue(int length){
        if (length > 0)
            queue = new int[length];
        else
            throw new ArrayStoreException("Queue won't be created with negative value.");
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        System.out.println(queue.isEmpty());

        for (int i=0; i < 4; i++){
            queue.enqueue(i);
        }

        queue.print();
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
    }

    public int dequeue(){
        if (isEmpty())
            throw new RuntimeException("Queue is Empty");
        int key = queue[read];
        queue[read++] = Integer.MIN_VALUE;
        return key;
    }

    public int peek(){
        if (isEmpty())
            throw new RuntimeException("Queue is Empty");
        return queue[read];
    }

    public void print(){
        for (int i=0; i < queue.length; i++){
            if (i == Integer.MIN_VALUE)
                continue;
            System.out.print(queue[i]+" ");
        }
        System.out.println();
    }

    public void enqueue(int key){
        if (!isEmpty()){
            if (write <= queue.length-1){
                queue[++size] = key;
            }
        } else {
            queue[write] = key;
            size++;
        }
    }

    public boolean isEmpty(){
        return (size==-1 && queue.length > 0);
    }
}

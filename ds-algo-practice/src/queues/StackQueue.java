package queues;

import java.util.LinkedList;
import java.util.Stack;

public class StackQueue {

    private Stack queue;

    public StackQueue(){
        queue = new Stack();
    }

    public static void main(String[] args) {
        StackQueue stackQueue = new StackQueue();
    }

    public void push(int key){
        queue.push(key);
    }
}

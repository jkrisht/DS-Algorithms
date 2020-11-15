package priorityQueue;

import java.util.Arrays;

public class PriorityQueue {

    private int[] queue;
    private int size;
    private int capacity;
    private int max;
    private int maxValueIndex;

    public PriorityQueue(){
        queue = new int[1];
        this.capacity = 1;
    }

    public PriorityQueue(int capacity){
        queue = new int[capacity];
        this.capacity = capacity;
    }

    public static void main(String[] args) {
        PriorityQueue priorityQueue = new PriorityQueue();
        priorityQueue.insert(6);
        priorityQueue.insert(1);
        priorityQueue.insert(2);
        priorityQueue.insert(-1);
        priorityQueue.insert(3);
        priorityQueue.insert(5);
        priorityQueue.insert(-4);

        priorityQueue.extractMax();
        priorityQueue.extractMax();
        priorityQueue.extractMax();
        priorityQueue.extractMax();
        priorityQueue.extractMax();
        priorityQueue.extractMax();
        System.out.println(priorityQueue.extractMax());
        System.out.println(priorityQueue.extractMax());
        System.out.println(Arrays.toString(priorityQueue.queue));
        System.out.println("Size: "+priorityQueue.getSize());
    }

    public int extractMax(){
        int key = Integer.MIN_VALUE;
        if (maxValueIndex >= 0){
            key = max;
            this.queue[maxValueIndex] = Integer.MIN_VALUE;
            size--;
            setMaxValueAndIndex();
        }
        return key;
    }

    public boolean insert(int key){
        if (empty()){
            this.max = key;
            this.maxValueIndex = size;
            queue[size++] = key;
            return true;
        } else {
            if (this.size >= capacity){
                capacity *= 2;
                int newArray[] = new int[this.capacity];

                Arrays.fill(newArray, Integer.MIN_VALUE);

                for (int i=0; i < size ; i++){
                    newArray[i] = this.queue[i];
                }

                if (this.max < key){
                    max = key;
                    maxValueIndex = size;
                }

                queue = newArray;
                queue[size++] = key;
                return true;
            }
            queue[size++] = key;
            return true;
        }
    }

    private void setMaxValueAndIndex(){
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < size; i++) {
            if (this.queue[i] == Integer.MIN_VALUE && (i+1 <= size)){
                int temp = this.queue[i];
                this.queue[i] = this.queue[i+1];
                this.queue[i+1] = temp;
            }

            if (max < this.queue[i]){
                max = this.queue[i];
                maxIndex = i;
            }
        }

        this.max = max;
        this.maxValueIndex = maxIndex;
    }

    public boolean empty(){
        return size == 0;
    }

    public int getSize(){
        if (queue != null)
            return this.size;
        return -1;
    }
}

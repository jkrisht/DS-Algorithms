package priorityQueue;

import java.util.Arrays;

public class MaxHeapBinaryTree {

    private int[] heap;
    private int capacity;
    private int size;

    private MaxHeapBinaryTree(int capacity){
        if (capacity > 0){
            this.capacity = capacity;
            this.heap = new int[capacity];
            for (int i = 0; i < capacity; i++) {
                this.heap[i] = Integer.MIN_VALUE;
            }
        } else {
            throw new ArrayStoreException(capacity+" is not allowed for Binary Tree");
        }
    }

    public static void main(String[] args) {
        MaxHeapBinaryTree maxHeapBinaryTree = new MaxHeapBinaryTree(6);
        maxHeapBinaryTree.insert(2);
        maxHeapBinaryTree.insert(-1);
        maxHeapBinaryTree.insert(3);
        maxHeapBinaryTree.insert(4);
        maxHeapBinaryTree.insert(-3);
        System.out.println(Arrays.toString(maxHeapBinaryTree.heap));

        maxHeapBinaryTree.extractMax();

        System.out.println(Arrays.toString(maxHeapBinaryTree.heap));
        System.out.println("Size : "+maxHeapBinaryTree.getSize());

        maxHeapBinaryTree.changePriority(0, -10);
        maxHeapBinaryTree.extractMax();

        System.out.println(Arrays.toString(maxHeapBinaryTree.heap));
        System.out.println(maxHeapBinaryTree.getSize());
    }

    public void changePriority(int index, int key){
        if (index < size){
            int value = this.heap[index];
            this.heap[index] = key;

            if (key > this.heap[parent(index)]){
                shiftUp(index);
            } else {
                shiftDown(index);
                shiftUp(size);
            }
            return;
        }
        throw new RuntimeException("Index is out of range");
    }

    public int extractMax(){
        if (size > 0){
            int key = this.heap[0];
            this.heap[0] = this.heap[size-1];
            this.heap[size-1] = Integer.MIN_VALUE;
            size--;
            shiftDown(0);
            return key;
        }
        return Integer.MIN_VALUE;
    }

    public void shiftDown(int index){
        if (index > size || getLeft(index) > size || getRight(index) > size)
            return;

        if (get(index) < get(getLeft(index))){
            int temp = this.heap[index];
            this.heap[index] = this.heap[getLeft(index)];
            this.heap[getLeft(index)] = temp;
            shiftDown(getLeft(index));
        } else if (get(index) < get(getRight(index))){
            int temp = this.heap[index];
            this.heap[index] = this.heap[getRight(index)];
            this.heap[getRight(index)] = temp;
            shiftDown(getRight(index));
        }
    }

    private int get(int index){
        return this.heap[index];
    }

    public void insert(int key){
        if (empty()){
            this.heap[size++] = key;
        } else if (isFull()){
            throw new ArrayIndexOutOfBoundsException("Binary Tree is full");
        } else {
            this.heap[size++] = key;
            shiftUp(size);
        }
    }

    private void shiftUp(int index){
        int i = index-1;

        if (i == 0 && this.heap[0] < this.heap[index]){
            int temp = this.heap[0];
            this.heap[0] = this.heap[index];
            this.heap[index] = temp;
        }

        while (i >= 1 && this.heap[parent(i)] < this.heap[i]){
            int temp = this.heap[parent(i)];
            this.heap[parent(i)] = this.heap[i];
            this.heap[i] = temp;
            i = parent(i);
        }

    }

    private int parent(int index){
        int i = index/2;
        if (i >= 0 && i < size)
            return i;
        throw new ArrayIndexOutOfBoundsException("Tree is Empty");
    }

    private int getLeft(int index){
        int i = 2*index;

        if (i > 0 && this.heap[i] != Integer.MIN_VALUE){
            return i;
        } else if (i == 0){
            return i+1;
        }

        return Integer.MAX_VALUE;
    }

    private int getRight(int index){
        int i = 2*index + 1;

        if (i > 0 && this.heap[i] != Integer.MIN_VALUE)
            return i;
        else if (i == 1){
            return i+1;
        }

        return Integer.MAX_VALUE;
    }

    public boolean isFull(){
        return getSize() >= capacity;
    }

    public boolean empty(){
        return getSize() == 0;
    }

    public int getSize(){
        return size;
    }
}

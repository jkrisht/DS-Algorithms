package priorityQueue;

import java.util.Arrays;
import java.util.Random;

public class BinarySort {

    private int[] sortHeap;
    private int size;
    private int capacity;

    public static void main(String[] args) {
        BinarySort sort = new BinarySort();

        int arr[] = new int[40];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(40);
        }

        System.out.println(Arrays.toString(arr));

        sort.buildHeap(arr);

        System.out.println(Arrays.toString(sort.sortHeap));

        for (int i = 0; i < arr.length; i++) {
            sort.extractMax();
        }

        System.out.println(Arrays.toString(sort.sortHeap));
    }

    public void extractMax(){
        int temp = this.sortHeap[--size];
        this.sortHeap[size] = this.sortHeap[0];
        this.sortHeap[0] = temp;
        shiftDown(0);
    }

    public void buildHeap(int[] arr){

        this.sortHeap = arr;
        capacity = size = arr.length;
        shiftDown(0);
    }

    private void shiftDown(int index){
        if (index > size)
            return;

        // System.out.println("Left : "+getLeft(index)+" for "+index);
        // System.out.println("Right : "+getRight(index)+" for "+index);
        // System.out.println(Arrays.toString(this.sortHeap));

        if (getLeft(index) < size){
            if (get(index) < get(getLeft(index))){
                int temp = get(index);
                this.sortHeap[index] = this.sortHeap[getLeft(index)];
                this.sortHeap[getLeft(index)] = temp;
            }
            shiftDown(getLeft(index));
        }

        if (getRight(index) < size){
            if (get(index) < get(getRight(index))){
                int temp = get(index);
                this.sortHeap[index] = this.sortHeap[getRight(index)];
                this.sortHeap[getRight(index)] = temp;
            }
            shiftDown(getRight(index));
        }

        return;
    }

    private int parent(int index){
        return Math.abs((index-1)/2);
    }

    private int getLeft(int index){
        int left = 2*index+1;
        if (left < size)
            return left;

        return Integer.MAX_VALUE;
    }

    private int getRight(int index){
        int right = 2*index+2;
        if (right < size)
            return right;
        return Integer.MAX_VALUE;
    }

    public int getSize(){
        return size;
    }

    public int get(int index){
        return this.sortHeap[index];
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean empty(){
        return size == 0;
    }

}

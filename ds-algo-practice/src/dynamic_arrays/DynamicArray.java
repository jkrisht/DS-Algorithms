package dynamic_arrays;

import java.util.Arrays;

public class DynamicArray {
    private int size;
    private int arr[];
    private int capacity;

    public DynamicArray(){
        this.arr = new int[1];
        this.capacity = 1;
    }

    public DynamicArray(int capacity){
        if (capacity > 0){
            this.arr = new int[capacity];
            this.capacity = capacity;
        } else {
            throw new ArrayStoreException("Array can't be created with 0 or negative values");
        }
    }

    public static void main(String[] args) {
        DynamicArray array = new DynamicArray();
        array.pushBack(1);
        array.pushBack(2);
        array.pushBack(3);

        System.out.println(Arrays.toString(array.arr));
        System.out.println(array.getSize());
        System.out.println(array.capacity);

        DynamicArray array1 = new DynamicArray(3);
        array1.pushBack(-1);
        array1.pushBack(-2);
        array1.pushBack(-3);
        array1.pushBack(-4);

        System.out.println(Arrays.toString(array1.arr));
        System.out.println(array1.getSize());
        System.out.println(array1.capacity);

        System.out.println("Array Value: "+ array.get(2));
        // System.out.println(array.get(3));

        System.out.println("Array Value: "+ array1.get(3));

        System.out.println(array1.remove(1));
        System.out.println(array1.remove(0));
        System.out.println(array1.remove(0));
        System.out.println(Arrays.toString(array1.arr));

        System.out.println(array1.replace(0, 10));
        System.out.println(Arrays.toString(array1.arr));
    }

    public boolean replace(int index, int key){
        if (!empty()){
            if (index < size && index >= 0){
                arr[index] = key;
                return true;
            }
            throw new ArrayIndexOutOfBoundsException(index+" index is out of range for this array");
        }
        throw new ArrayIndexOutOfBoundsException("Array is empty");
    }

    public int remove(int index){
        if (!empty()){
            if (index < size && index >= 0){
                int value = arr[index];
                if (index == size-1){
                    arr[index] = Integer.MIN_VALUE;
                    size--;
                    return value;
                } else {
                    for (;index+1 < size; index++){
                        arr[index] = arr[index+1];
                    }
                    arr[index] = Integer.MIN_VALUE;
                    size--;
                    return value;
                }
            }
            throw new ArrayIndexOutOfBoundsException(index+" index is out of range for this array");
        }
        throw new ArrayIndexOutOfBoundsException("Array is empty");
    }

    public int get(int index){
        if (!empty()){
            if (index < size && index >= 0){
                return arr[index];
            }
            throw new ArrayIndexOutOfBoundsException(index+" index is out of range for this array");
        }
        throw new ArrayIndexOutOfBoundsException("Array is empty");
    }

    public boolean pushBack(int key){
        if (empty()){
            arr[size++] = key;
            return true;
        } else {
            if (size >= capacity){
                capacity *= 2;
                int newArr[] = new int[capacity];
                Arrays.fill(newArr, Integer.MIN_VALUE);

                for (int i=0; i < size; i++){
                    newArr[i] = arr[i];
                }
                arr = newArr;
            }
            arr[size++] = key;
            return true;
        }
    }

    public int getSize(){
        return this.size;
    }

    public boolean empty(){
        return size == 0;
    }
}

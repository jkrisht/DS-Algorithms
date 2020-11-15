package dynamic_arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromArray {
    public static void main(String[] args) {
        removeDuplicates(new int[]{1,2,3,4,1,2,1,2,3,4,1,2,1,2,3,4,1,2,1,2,3,4,1,2,1,2,3,4,1,2,10,-1,-1,-2});
    }

    public static void removeDuplicates(int arr[]){

        if (arr.length <= 1)
            return;

        int size = 0;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            if (!builder.toString().contains(""+arr[i]+" ")){
                builder.append(arr[i]+" ");
                size++;
            } else {
                arr[i] = Integer.MIN_VALUE;
            }
        }

        System.out.println(builder.toString());

        int newArr[] = new int[size];
        int index = 0;
        for (int element: arr) {
            if (element != Integer.MIN_VALUE){
                newArr[index++] = element;
            }
        }

        System.out.println(Arrays.toString(newArr));
    }
}

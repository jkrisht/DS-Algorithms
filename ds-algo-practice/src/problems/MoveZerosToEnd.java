package problems;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int arr[] = {7,0,6,0,0,2,1,0,5,-1,0};
        System.out.println(Arrays.toString(moveZeroesToEnd(arr)));
    }

    public static int[] moveZeroesToEnd(int arr[]){

        if (arr == null || arr.length <= 1)
            return arr;

        int nonZeroIndex = 0;

        for (int i=0; i < arr.length; i++){
            if (arr[nonZeroIndex] != 0){
                nonZeroIndex++;
            } else if (arr[i] != 0){
                    arr[nonZeroIndex++] = arr[i];
                    arr[i] = 0;
            }
        }
        return arr;
    }
}

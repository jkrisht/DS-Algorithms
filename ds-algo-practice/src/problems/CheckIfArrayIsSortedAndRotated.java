package problems;

import java.util.Arrays;

public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 1, 2, 3};
        System.out.println(checkIfArrayIsSortedAndRotated(arr));
    }

    public static boolean checkIfArrayIsSortedAndRotated(int[] arr){

        if (arr == null || arr.length == 0)
            return false;

        if (arr[0] < arr[arr.length-1])
            return false;

        int maxValue = getMaxValue(arr, 0, arr.length-1);
        System.out.println(maxValue);

        int leftIndex = maxValue-1;
        int leftValue = arr[maxValue];

        int rightIndex = maxValue+1;
        int rightValue = arr[rightIndex];

        while (leftIndex >= 0 || rightIndex < arr.length-1){
            boolean isRotated = false;

            if (leftIndex >= 0 && (leftValue > arr[leftIndex])){
                System.out.println("left "+ leftValue);
                leftValue = arr[leftIndex--];
                isRotated = true;
            }

            if (rightIndex+1 <= arr.length-1 && (rightValue < arr[rightIndex+1])){
                System.out.println("right "+ rightValue);
                rightValue = arr[rightIndex++];
                isRotated = true;
            }

            if (!isRotated){
                System.out.println(leftValue+" "+rightValue);
                return isRotated;
            }
        }

        return true;
    }

    public static int getMaxValue(int arr[], int start, int end){
        int mid = (start + end) / 2;

        if (start >= end)
            return start;

        if (arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1])
            return mid;
        else if (arr[mid] < arr[mid+1]){
            return getMaxValue(arr, mid+1, end);
        } else if (arr[mid] > arr[mid+1]){
            return getMaxValue(arr, start, mid);
        }

        return Integer.MIN_VALUE;
    }

    public static boolean compare(int arr1[], int arr2[]){
        if (arr1.length != arr2.length)
            return false;

        if (arr1 == null || arr2 == null)
            return false;

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }

        return true;
    }
}

package problems;

import java.util.Arrays;

public class SortAndRotated2 {
    public static void main(String[] args) {
        int arr[] = { 3, 4, 0, 1};
        System.out.println(isSortAndRotated(arr));
    }

    public static boolean isSortAndRotated(int[] arr){
        if (arr == null || arr.length == 0 || arr[0] < arr[arr.length-1])
            return false;

        int maxIndex = findMaxIndex(arr, 0, arr.length-1);
        System.out.println(maxIndex);

        if (maxIndex != -1){
            int newArr[] = arr.clone();
            Arrays.sort(newArr);
            swap(arr, maxIndex);
        }

        return false;
    }

    public static int findMaxIndex(int[] arr, int start, int end){
        // { 3, 4, 5, 6, 1, 2 };
        if (start >= end)
            return start;

        int mid = (start + end) / 2;

        if (arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1])
            return mid;
        else if (arr[mid] < arr[mid+1])
            return findMaxIndex(arr, mid+1, end);
        else if (arr[mid] > arr[mid-1])
            return findMaxIndex(arr, start, mid-1);

        return -1;
    }

    public static void swap(int arr[], int index){
        for (int i = 0; i < index; i++){

        }
    }
}
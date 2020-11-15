package problems;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3,5,4,1,0,2};
        bubbleSort(arr);
        selectSort(arr);
        insertionSort(arr);
    }

    public static void bubbleSort(int arr[]){

        if (arr.length == 0 || arr == null)
            return;

        int arr1[] = arr.clone();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j+1 <= arr1.length-1-i; j++) {
                if (arr1[j] > arr1[j+1]){
                    int temp = arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = temp;
                }
            }
        }

        System.out.println("Bubble Sort: "+Arrays.toString(arr1));
    }

    public static void selectSort(int arr[]){
        if (arr == null || arr.length == 0)
            return;

        int arr2[] = arr.clone();

        for (int i = 0; i < arr2.length; i++) {

            int maximum = arr2[0];
            int maxIndex = 0;

            for (int j = 0; j <= arr2.length-1-i; j++) {
                if (maximum < arr2[j]){
                    maximum = arr2[j];
                    maxIndex = j;
                }
            }

            arr2[maxIndex] = arr2[arr2.length-1-i];
            arr2[arr2.length-1-i] = maximum;
        }
        System.out.println("Selection Sort: "+ Arrays.toString(arr2));
    }

    public static void insertionSort(int[] arr){
        if (arr == null || arr.length == 0)
            return;

        int[] arr3 = arr.clone();

        for (int i = 1; i < arr3.length; i++) {
            int key = arr3[i];

            for (int j = i-1; j >= 0; j--) {
                if (key < arr3[j]){
                    arr3[j+1] = arr3[j];
                    arr3[j] = key;
                } else
                    break;
            }
        }

        System.out.println("Insertion Sort: "+ Arrays.toString(arr3));
    }

    public static void mergeSort(int arr[], int start, int end){

        if (arr == null || arr.length <= 1)
            return;

        int mid = (start + end) / 2;

        int[] left = new int[mid];

        if (mid % 2 != 0){

        }
    }
}

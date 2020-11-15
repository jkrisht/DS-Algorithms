package algorithms.sort;

import java.util.Arrays;

public class SortAnUnsrotedArrayUsingTwoWayMergeSort {

	public static void main(String[] args) {
		int[] array = { 5, 3, 4, 1, 2 };

		int iters = array.length / 2;
		int[] arr1 = new int[iters];

		int[] arr2 = null;

		if (2 * iters != array.length) {
			arr2 = new int[iters + 1];
		} else {
			arr2 = new int[iters];
		}

		for (int i = 0; i < iters; i++) {
			arr1[i] = array[i];
		}

		int index = 0;

		for (int i = iters; i < array.length; i++) {
			arr2[index++] = array[i];
		}

		twowayMergeSort(arr1, arr2);
	}

	public static int[] twowayMergeSort(int[] arr, int[] arr2) {

		Arrays.sort(arr);
		Arrays.sort(arr2);

		int[] new_arr = new int[arr.length + arr2.length];

		int i = 0;
		int j = 0;

		for (int j2 = 0; j2 < new_arr.length; j2++) {
			if (arr.length != i && arr2.length != j) {
				if (arr[i] < arr2[j]) {
					new_arr[j2] = arr[i];
					i += 1;
				} else {
					new_arr[j2] = arr2[j];
					j += 1;
				}
			} else {
				if (arr2.length != j) {
					new_arr[j2] = arr2[j];
					j += 1;
				} else if (arr.length != i) {
					new_arr[j2] = arr[i];
					i += 1;
				}
			}
		}

		for (int j2 = 0; j2 < new_arr.length; j2++) {
			System.out.print(new_arr[j2] + " ");
		}

		return new_arr;

	}
}

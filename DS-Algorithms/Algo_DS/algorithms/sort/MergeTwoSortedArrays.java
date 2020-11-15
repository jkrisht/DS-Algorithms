package algorithms.sort;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, -1, 100, 102, 103, 99 };
		int[] arr2 = { 5, 6, 7, 0, 100 };

		Arrays.sort(arr);
		Arrays.sort(arr2);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
		System.out.println();

		int[] new_arr = new int[arr.length + arr2.length];

		int i = 0;
		int j = 0;

		for (int j2 = 0; j2 < new_arr.length; j2++) {
			if (arr.length != i && arr2.length != j) {
				System.out.println(i + " : " + j);
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

	}

}
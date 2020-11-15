package algorithms.sort;

public class MergeSort {
	public static void main(String[] args) {
		int[] arr = { 2, 0, -9, -0, -5, 123, 23, 7, 9 };
		arr = slicing(arr);
		printArray(arr, "Final");
	}

	public static int[] slicing(int[] arr) {
		if (arr.length == 1) {
			return arr;
		}

		int middle = arr.length / 2;

		int[] leftArray = new int[middle];
		int[] rightArray;

		if (arr.length % 2 == 0) {
			rightArray = new int[middle];
		} else {
			rightArray = new int[middle + 1];
		}

		for (int i = 0; i < leftArray.length; i++) {
			leftArray[i] = arr[i];
		}

		for (int i = 0; i < rightArray.length; i++) {
			rightArray[i] = arr[middle + i];
		}

		printArray(leftArray, "left");
		printArray(rightArray, "right");

		leftArray = slicing(leftArray);
		rightArray = slicing(rightArray);

		int[] result = merge(leftArray, rightArray);

		return result;

	}

	public static int[] merge(int[] left, int[] right) {

		int[] new_arr = new int[left.length + right.length];

		int i = 0, j = 0;

		for (int j2 = 0; j2 < new_arr.length; j2++) {
			if (i < left.length && j < right.length) {
				if (left[i] < right[j]) {
					new_arr[j2] = left[i++];
				} else {
					new_arr[j2] = right[j++];
				}
			} else if (i < left.length) {
				new_arr[j2] = left[i++];
			} else if (j < right.length) {
				new_arr[j2] = right[j++];
			}
		}
		printArray(new_arr, "Merge");
		return new_arr;
	}

	public static void printArray(int arr[], String key) {
		System.out.print(key + ": ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
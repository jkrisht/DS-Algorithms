package algorithms.sort;

public class QuickSort {
	public static void main(String[] args) {

		int[] arr = { 10, 2, 5, 3, 8, 6, 9, 1, 0, 4, 7, 1, -1 };
		int[] arr1 = { 10, 2, 5, 3, 8, 6, 9, 1, 0, 4, 7, 1, -1 };

		actualQuickSort1(arr, 0, arr.length - 1);
		printArray(arr);
		System.out.println();

		int[] arr2 = quickSort(arr1, 0, arr1.length - 1);
		printArray(arr2);
	}

	public static int[] quickSort(int[] arr, int first, int last) {

		if (arr.length == 1) {
			return arr;
		}

		if (first < last) {

			int pivot = last;

			int index = first - 1;

			for (int i = first; i <= last; i++) {
				if (arr[i] <= arr[pivot]) {

					index++;

					int temp = arr[i];
					arr[i] = arr[index];
					arr[index] = temp;
				}
			}

			quickSort(arr, first, index - 1);

			quickSort(arr, index + 1, last);
			
			return arr;
		}

		return null;
	}

	public static void actualQuickSort1(int[] array, int start, int end) {
		if (start < end) {
			int pivot = actualPartition(array, start, end);
			actualQuickSort1(array, start, pivot - 1);
			actualQuickSort1(array, pivot + 1, end);
		}
	}// end of method

	static int actualPartition(int[] array, int p, int q) {
		int pivot = q;
		int i = p - 1;
		for (int j = p; j <= q; j++) {
			if (array[j] <= array[pivot]) {
				i++;
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		return i;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	public static void printArray(int[] arr, int start, int index) {
		for (int i = start; i <= index; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
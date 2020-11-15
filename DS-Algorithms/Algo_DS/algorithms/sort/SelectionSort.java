package algorithms.sort;

public class SelectionSort {
	public static void main(String[] args) {

		int arr[] = { 2, 5, 3, 8, 6, 9, 1, 4, 7, 1, 0, -9, -7, 100 };

		for (int i = 0; i < arr.length; i++) {

			int small_index = i;

			for (int j = i + 1; j < arr.length; j++) {
				if (arr[small_index] > arr[j]) {
					small_index = j;
				}
			}

			int temp = arr[small_index];
			arr[small_index] = arr[i];
			arr[i] = temp;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
package algorithms.sort;

public class InsertionSort {
	public static void main(String[] args) {

		int[] arr = { 2, 5, 3, 8, 6, 9, 1, 4, 7 };

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}

			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}

	}
}
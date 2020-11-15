package algorithms.binarysearch;

public class BinarySearchWithRecursion {
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4 };

		int low = 0;
		int high = arr.length - 1;
		int search = 4;

		System.out.println("My Logic: " + binarySearch2(arr, low, high, search));

		System.out.println("Copied Logic: " + binarySearch(arr, low, high, search));

	}

	public static int binarySearch2(int arr[], int low, int high, int search) {

		if (high >= low) {
			int middle = (low + high) / 2;
			// System.out.println("My Logic: " + middle);

			if (arr[middle] == search) {
				return middle;
			} else if (arr[middle] > search) {
				return binarySearch2(arr, low, middle - 1, search);
			} else if (arr[middle] < search) {
				return binarySearch2(arr, middle + 1, high, search);
			}
		}

		return -1;
	}

	public static int binarySearch(int[] arr, int low, int high, int search) {
		if (high >= low) {
			int middle = low + (high - low) / 2;
			// System.out.println("Copied: " + middle);

			if (arr[middle] == search) {
				return middle;
			}

			if (arr[middle] > search) {
				return binarySearch(arr, low, middle - 1, search);
			}

			return binarySearch(arr, middle + 1, high, search);
		}

		return -1;
	}

	public static void print(int arr[], int low, int high, String key) {
		System.out.print(key + " ");
		for (int i = low; i <= high; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
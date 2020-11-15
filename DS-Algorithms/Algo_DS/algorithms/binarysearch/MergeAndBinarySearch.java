package algorithms.binarysearch;

public class MergeAndBinarySearch {

	public static void main(String[] args) {
		int[] arr = { 10, 4, 3, 2, 1, 30, 49, 48, 8, 20, 21, 22, 45, 9, 7, 0, 6, 5 };
		arr = sort(arr);
		printArray("Final", arr);

		binarySearch(arr, 5);
	}

	public static int[] sort(int[] arr) {

		if (arr.length == 1)
			return arr;

		int middle = arr.length / 2;

		int[] leftArr = new int[middle];

		int[] rightArr = null;
		if (arr.length % 2 == 0)
			rightArr = new int[middle];
		else
			rightArr = new int[middle + 1];

		for (int i = 0; i < leftArr.length; i++) {
			leftArr[i] = arr[i];
		}

		for (int i = 0; i < rightArr.length; i++) {
			rightArr[i] = arr[middle + i];
		}

		leftArr = sort(leftArr);
		rightArr = sort(rightArr);

		int[] result = merge(leftArr, rightArr);

		return result;
	}

	public static int[] merge(int leftArr[], int rightArr[]) {

		int[] result = new int[leftArr.length + rightArr.length];

		int j = 0, k = 0;

		for (int i = 0; i < result.length; i++) {
			if (j < leftArr.length && k < rightArr.length) {
				if (leftArr[j] < rightArr[k])
					result[i] = leftArr[j++];
				else
					result[i] = rightArr[k++];
			} else if (j < leftArr.length) {
				result[i] = leftArr[j++];
			} else if (k < rightArr.length) {
				result[i] = rightArr[k++];
			}
		}

		return result;
	}

	public static void printArray(String key, int[] arr) {
		System.out.print(key + " ");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void binarySearch(int[] arr, int search) {
		int location = -1;

		while (location == -1) {

			int middle = arr.length / 2;

			if (arr[middle] == search) {
				location = middle;
			} else if (arr.length == 1 && arr[0] != search) {
				location = -2;
			} else if (arr[middle] > search) {

				int[] leftArr = new int[middle];

				for (int i = 0; i < leftArr.length; i++) {
					leftArr[i] = arr[i];
				}

				arr = leftArr;

			} else {
				int[] rightArr = null;
				if (arr.length % 2 == 0)
					rightArr = new int[middle];
				else
					rightArr = new int[middle + 1];

				for (int i = 0; i < rightArr.length; i++) {
					rightArr[i] = arr[middle + i];
				}

				arr = rightArr;
			}
		}

		if (location >= 0)
			System.out.println("location & value: " + location + ", " + arr[location]);
		else
			System.out.println(search + " is not present in the given array");
	}

}
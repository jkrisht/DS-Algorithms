package algorithms.binarysearch;

public class BinarySearch {
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		int search = 10;

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
				int[] rightArr;

				if (arr.length % 2 == 0) {
					rightArr = new int[middle];
				} else {
					rightArr = new int[middle + 1];
				}

				for (int i = 0; i < rightArr.length; i++) {
					rightArr[i] = arr[middle + i];
				}

				arr = rightArr;
			}

		}

		System.out.println("location & value: " + location + ", " + arr[location]);
	}

}

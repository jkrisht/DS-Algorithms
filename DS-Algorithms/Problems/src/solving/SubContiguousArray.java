package solving;

import java.util.Arrays;

public class SubContiguousArray {
	public static void main(String[] args) {

		int number = 7;
		int arr[] = { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 9, 8, 6, 1 };
		int arr2[] = arr.clone();

		Arrays.sort(arr);

		int sum = 0;

		int smallest = 0;

		if (arr[arr.length - 1] == number) {
			 smallest = 1;
		} else {

			int index = 0;

			for (int i = 0; i < arr2.length; i++) {
				if (sum < number) {

					sum += arr2[i];
					smallest += 1;

				} else if (sum != number || sum > number) {

					smallest = 0;
					sum = 0;
					index += 1;

				}

				if (sum != number && arr2.length == i + 1) {
					smallest = 0;
				}
			}

		}

		System.out.println(smallest);

	}
}
package solving;

import java.util.Arrays;

public class SortArray {
	public static void main(String[] args) {
		int[] arr = {13, 7, 6, 45, 21, 9, 101, 102};
		Arrays.sort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}
}

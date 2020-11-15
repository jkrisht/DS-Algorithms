package solving.app_problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumProblem {
	public static void main(String[] args) {
		int S[] = { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSumSol(S));
	}

	public static ArrayList<?> threeSumSol(int nums[]) {

		nums = sortArray(nums);

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}

		System.out.println();

		Set<List<Integer>> set = new HashSet<List<Integer>>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				for (int j2 = j + 1; j2 < nums.length; j2++) {
					int sum = nums[i] + nums[j] + nums[j2];
					if (sum == 0) {
						List<Integer> list1 = new ArrayList<Integer>();
						list1.add(nums[i]);
						list1.add(nums[j]);
						list1.add(nums[j2]);
						set.add(list1);
					}
				}
			}
		}

		return new ArrayList<List<Integer>>(set);
	}

	public static int[] sortArray(int[] arr) {

		if (arr.length == 1)
			return arr;

		int middle = arr.length / 2;

		int leftArr[] = new int[middle];
		int rightArr[] = null;

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

		leftArr = sortArray(leftArr);
		rightArr = sortArray(rightArr);

		return compareAndSort(leftArr, rightArr);
	}

	public static int[] compareAndSort(int lArr[], int[] rArr) {
		int[] resultArr = new int[lArr.length + rArr.length];

		int l = 0, r = 0;

		for (int i = 0; i < resultArr.length; i++) {
			if (lArr.length > l && rArr.length > r) {
				if (lArr[l] < rArr[r]) {
					resultArr[i] = lArr[l++];
				} else {
					resultArr[i] = rArr[r++];
				}
			} else if (lArr.length > l) {
				resultArr[i] = lArr[l++];
			} else if (rArr.length > r) {
				resultArr[i] = rArr[r++];
			}
		}

		return resultArr;
	}
}

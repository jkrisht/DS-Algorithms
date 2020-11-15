package solving;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesFromArray {
	public static void main(String[] args) {

		// Using Set
		int[] arr = { 0, 2, 4, 5, 6, 7, 0, 0, 0, 0, 0, 0, 0, 0, 1 };
		Set<Integer> set = new LinkedHashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}

		System.out.println(set);

		int[] unique_arr = new int[set.size()];

		Iterator<Integer> i = set.iterator();
		int index = 0;

		while (i.hasNext()) {
			unique_arr[index] = i.next();
			index += 1;
		}

	}
}

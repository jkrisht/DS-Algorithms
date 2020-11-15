package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListPractice {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();

		list.add(1);
		list.add(2);
		list.add(4);
		list.add(3);

		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.contains(0));
		System.out.println(list.equals(2));

		System.out.println(list.indexOf(2));
		list.sort(null);
		System.out.println(list);

		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		System.out.println(list.subList(0, 2));

		System.out.println(list.remove(2));
		
	}
}

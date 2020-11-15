package collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetList {
	public static void main(String[] args) {

		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(2);
		set.add(3);
		set.add(5);
		set.add(4);

		Set<Integer> hset = new LinkedHashSet<Integer>();
		hset.add(1);
		hset.add(2);
		hset.add(3);
		hset.add(5);
		hset.add(4);

		Set<Integer> tset = new TreeSet<Integer>();
		tset.add(1);
		tset.add(2);
		tset.add(3);
		tset.add(5);
		tset.add(4);

		System.out.println(set);
		System.out.println(hset);
		System.out.println(tset);

		System.out.println(tset.remove(1) + " " + tset);
		Iterator<Integer> it = set.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}
}
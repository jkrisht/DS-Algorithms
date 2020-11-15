package collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapPractice {
	public static void main(String[] args) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(5, 6);
		map.put(4, 4);

		Map<Object, Object> hmap = new LinkedHashMap<Object, Object>();
		hmap.put(1, 1);
		hmap.put(2, 2);
		hmap.put(3, 3);
		hmap.put(5, 5);
		hmap.put(4, 4);
		hmap.put("asdad", 123123);

		Map<Object, Object> tmap = new TreeMap<Object, Object>();
//		tmap.put(1, 1);
//		tmap.put(2, 2);
//		tmap.put(3, 3);
//		tmap.put(5, 5);
//		tmap.put(4, 4);
//		tmap.put(0, 0);

		tmap.put("a", "34567");
		tmap.put("K", "34567");
		tmap.put("J", "34567");

		System.out.println(map);
		System.out.println(hmap);
		System.out.println(tmap);

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

		Iterator<Integer> it1 = map.values().iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
	}
}
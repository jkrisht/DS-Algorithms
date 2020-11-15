package hash;

import java.util.HashMap;
import java.util.Map;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,12);
        map.put(3,13);
        map.put(4,78);
        map.put(5,90);

        int num = map.get(6);
        System.out.println(num);
    }
}

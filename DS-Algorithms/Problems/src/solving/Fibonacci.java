package solving;

import java.util.LinkedHashMap;
import java.util.Map;

public class Fibonacci {

	static Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

	public static void main(String[] args) {
		int number = 5;
		System.out.println("Normal " + normalSolution(number));
	}

	public static int normalSolution(int number) {
		int n1 = 1, n2 = 1, n3 = 0;

		for (int i = 2; i < number; ++i) {
			n3 = n1 + n2;
			n1 = n2;
			n2 = n3;
		}
		return n3;
	}

}

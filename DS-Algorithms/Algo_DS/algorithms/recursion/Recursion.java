package algorithms.recursion;

public class Recursion {

	public static void main(String[] args) {
		System.err.println(recursionFactorial(40));
		normalMethodForFactorial(40);
	}

	// Recusrsive function
	public static long recursionFactorial(long number) {
		long fact = 1;
		if (number > 1) {
			fact = number * recursionFactorial(number - 1);
		} else {
			fact = 1;
		}
		return fact;
	}

	// Normal Factorial
	public static void normalMethodForFactorial(int number) {
		long fact = 1;
		for (int i = 1; i <= number; i++) {
			fact = fact * i;
		}
		System.out.println(fact);
	}

}
package solving;

public class SubContihuousNumber {
	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 3, 1, 1, 1, 1, 3, 1, 3, 11 };
		int search = 475;

		int sum = 0;

		int smallest = 0;

		for (int i = 0; i < arr.length; i++) {

			int currentLength = 1;

			if (arr[i] == search) {
				smallest = 1;
				break;
			} else {
				sum = arr[i];
				for (int j = i + 1; j < arr.length; j++) {
					if (sum == search && currentLength < smallest) {
						smallest = currentLength;
						break;
					} else if (sum < search) {
						sum += arr[j];
						currentLength++;
					} else if (sum > search) {
						break;
					}
				}

				if (sum == search && (smallest == 0 || currentLength < smallest)) {
					smallest = currentLength;
				}
			}
		}

		System.out.println(smallest);
	}
}
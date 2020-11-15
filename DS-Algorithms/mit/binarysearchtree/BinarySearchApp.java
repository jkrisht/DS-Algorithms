package binarysearchtree;

public class BinarySearchApp {
	public static void main(String[] args) {
		// Insert values into tree
		BinarySearchTreeImpl impl = new BinarySearchTreeImpl();
		impl.insert(8);
		impl.insert(4);
		impl.insert(2);
		impl.insert(7);
		impl.insert(9);
		impl.insert(10);
		impl.insert(11);

		// Print tree
		System.out.println("Total Elemnts: " + impl.totalElements);
		impl.getAllElements();

		// Search for an element
		System.out.println(impl.searchElement(9087898));
	}
}

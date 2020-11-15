package binarysearchtree;

public class BinarySearchTreeImpl {

	// Root node
	Node root = null;
	int totalElements = 0;

	public void insert(int value) {
		root = insertNode(root, value);
	}

	public void getAllElements() {
		getElements(root);
	}

	public boolean searchElement(int value) {
		return searchElement(root, value);
	}

	// Insert nodes into tree
	public Node insertNode(Node root, int value) {
		if (root == null) {
			root = new Node(value);
			totalElements++;
			return root;
		}

		if (value < root.key) {
			root.left = insertNode(root.left, value);
		} else if (value > root.key) {
			root.right = insertNode(root.right, value);
		}

		return root;
	}

	// retrieve all elements from Tree
	public void getElements(Node root) {
		if (root != null) {
			System.out.println(root.key);
			getElements(root.left);
			getElements(root.right);
		}
	}

	// Search for an elements
	public boolean searchElement(Node root, int value) {
		if (root != null) {
			if (value == root.key) {
				return true;
			} else if (value < root.key) {
				return searchElement(root.left, value);
			} else if (value > root.key) {
				return searchElement(root.right, value);
			}
		}

		return false;
	}
}

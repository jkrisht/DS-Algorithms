package datastructures.stack;

public class StackImpl {

	int[] stack_arr = null;
	int length = -1;

	// Initializing the empty array with given size
	public StackImpl(int size) {
		stack_arr = new int[size];
		length = 0;
	}

	// Check stack is empty or not
	public boolean isEmpty() {
		return stack_arr == null;
	}

	// Check the stack is full or not
	public boolean isFull() {
		if (length == -1)
			return true;
		else
			return stack_arr.length == length;
	}

	// Insert values into stack
	public void push(int value) {
		if (!isFull())
			stack_arr[length++] = value;
		else
			throw new StackOverflowError("Stack is full or empty");
	}

	// Pop and return the value
	public int pop() {
		if (!isEmpty() && length > 0)
			return stack_arr[--length];
		else
			throw new EmptyStackException("Stack is empty");
	}

	// Peek the stack
	public int peek() {
		if (!isEmpty())
			return stack_arr[length - 1];
		else
			throw new EmptyStackException("Stack is empty");
	}

	// Print all elements in Stack
	public void all() {
		for (int i = 0; i < length; i++) {
			System.out.println(stack_arr[i]);
		}
	}

	// Delete the stack
	public void deleteStack() {
		stack_arr = null;
		length = -1;
	}

}

class EmptyStackException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmptyStackException() {
		super();
	}

	public EmptyStackException(String message) {
		super(message);
	}
}

package datastructures.stack;

public class StackDS {
	/*
	 * LIFO -> Last In First Out
	 * 
	 * Implementing below functionalities for Stack DS
	 * 
	 * createStack
	 * push
	 * pop
	 * peek -> Get the top element
	 * isEmpty
	 * isFull
	 * deleteStack
	 * 
	 */
	public static void main(String[] args) {
		StackImpl stImpl = new StackImpl(5);

		stImpl.push(1);
		stImpl.push(2);
		stImpl.push(3);
		stImpl.push(4);

		System.out.println(stImpl.pop());
		System.out.println(stImpl.pop());

		System.out.println(stImpl.peek());
		System.out.println(stImpl.length);
		stImpl.deleteStack();
		System.out.println(stImpl.length);
	}
}

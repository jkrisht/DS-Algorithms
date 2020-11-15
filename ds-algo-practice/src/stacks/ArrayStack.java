package stacks;

import java.util.Arrays;
import java.util.Stack;

public class ArrayStack {

    private int top = -1;
    private int[] stack;
    private int size;

    // Initialize Stack array to store the values
    public ArrayStack(int size){
        if (size <= 0)
            throw new ArrayStoreException("Stack is not created with the given size");
        else
            stack = new int[size];
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);

        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);

        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.peek());

        System.out.println(arrayStack.push(10));
        System.out.println(arrayStack.peek());
    }

    public int pop(){
        if (!isEmpty())
            return stack[top--];
        return Integer.MIN_VALUE;
    }

    public int peek(){
        if (!isEmpty())
            return stack[top];
        return Integer.MIN_VALUE;
    }

    public boolean push(int key){
        if (isEmpty()){
            top = 0;
            stack[top] = key;
            size++;
            return true;
        } else {
            if (isFull()){
                throw new StackOverflowError("Stack is full");
            } else {
                stack[++top] = key;
                size++;
                return true;
            }
        }
    }

    public boolean isFull(){
        return (top+1 == stack.length || size == stack.length);
    }

    public boolean isEmpty(){
        return top == -1;
    }
}

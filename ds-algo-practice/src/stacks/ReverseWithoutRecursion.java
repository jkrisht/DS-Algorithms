package stacks;

public class ReverseWithoutRecursion {

    /*
    https://medium.com/techie-delight/stack-data-structure-practice-problems-and-interview-questions-9f08a35a7f19
    https://www.techiedelight.com/reverse-string-without-using-recursion/
     */
    private char[] stack;
    private int size = -1;

    public ReverseWithoutRecursion(int length){
        if (length > 0)
            stack = new char[length];
        else
            System.out.println("Please provide length which is more than 0");
    }

    public static void main(String[] args) {
        String text = "^&*()WORD-1!@#$%";
        StringBuilder builder = new StringBuilder();
        ReverseWithoutRecursion reverseWithoutRecursion = new ReverseWithoutRecursion(text.length());
        for (char ch: text.toCharArray()) {
            reverseWithoutRecursion.push(ch);
        }

        while (reverseWithoutRecursion.size != -1){
            builder.append(reverseWithoutRecursion.pop());
        }
        System.out.println(builder);
        builder.reverse();
    }

    public char pop(){
        if (!isEmpty())
            return stack[size--];
        return '0';
    }

    public void push(char key){
        if (!isEmpty()){
            if (size < stack.length)
                stack[++size] = key;
            else
                throw new StackOverflowError("Stack is full");
        } else
            System.out.println("Stack is empty!");
    }

    public boolean isEmpty(){
        return (size == -1 && stack == null);
    }

}

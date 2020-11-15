package stacks;

import org.jetbrains.annotations.NotNull;

public class CheckTheGivenExpressionIsBalancedOrNot {

    /*
    https://medium.com/techie-delight/stack-data-structure-practice-problems-and-interview-questions-9f08a35a7f19
    https://www.techiedelight.com/check-given-expression-balanced-expression-not/
     */

    private CharNode head;
    private int size;

    public static void main(String[] args) {
        CheckTheGivenExpressionIsBalancedOrNot balancedOrNot = new CheckTheGivenExpressionIsBalancedOrNot();

        if (balancedOrNot.isBalancedExpression("{()}[), {(})")){
            System.out.println("This is a balanced expression");
        } else {
            System.out.println("This is an un-balanced expression");
        }
    }

    public boolean isBalancedExpression(@NotNull String expression){

        for (char ch: expression.toCharArray()) {
            if (ch == '(' || ch == '[')
                push(ch);

            if (ch == ')' || ch == ']'){
                char ch1 = pop();

                if ((ch == ')' && ch1 != '(') || (ch == ']' && ch1 != '[')){
                    return false;
                }
            }
        }

        return isEmpty();
    }

    public char pop(){
        if (!isEmpty()){
            CharNode next = head.getNode();
            char key = head.getCh();
            head = null;
            head = next;
            return key;
        }
        return '1';
    }

    public char peek(){
        if (!isEmpty())
            return head.getCh();
        return '1';
    }

    public boolean push(char key){
        CharNode node = new CharNode(key);
        if (isEmpty()){
            head = node;
            size++;
            return true;
        } else {
            CharNode next = head;
            node.setNode(next);
            head = node;
            size++;
            return true;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }
}

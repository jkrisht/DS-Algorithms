package stacks;

import org.jetbrains.annotations.NotNull;

public class FindDuplicateParenthesisInExpression {

    private CharNode head;
    private int size;

    public static void main(String[] args) {
        FindDuplicateParenthesisInExpression parenthesis = new FindDuplicateParenthesisInExpression();
        String exp = "((x+z))";

        if (parenthesis.checkDuplicateParenthesis(exp)){
            System.out.println("Duplicate Expression Found.");
        } else {
            System.out.println("Duplicate Expression Not Found.");
        }
    }

    public boolean checkDuplicateParenthesis(@NotNull String exp){
        for (char ch: exp.toCharArray()) {
          if (ch != ')'){
              push(ch);
          } else {

              // After removing all characters from Stack and still "(" is present, then duplicate exists in the stack
              if (peek() == '(')
                  return true;

              while (peek() != '(')
                  pop();
              pop();
          }
        }

        return false;
    }

    public char peek(){
        if (!isEmpty())
            return head.getCh();
        return '0';
    }

    public char pop(){
        if (!isEmpty()){
            CharNode node = head.getNode();
            char ch = head.getCh();
            head = null;

            if (node != null){
                head = node;
                return ch;
            }
            size--;
        }

        return '0';
    }

    public void print(){
        CharNode charNode = head;

        while (charNode != null){
            System.out.print(charNode.getCh());
            charNode = charNode.getNode();
        }
    }

    public void push(char ch){
        CharNode node = new CharNode(ch);

        if (isEmpty()){
            head = node;
            size++;
        } else {
            node.setNode(head);
            head = node;
            size++;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }
}

package stacks;

public class EvaluatePostfixExpression {

    private Node head;
    private int size;

    public static void main(String[] args) {
        String exp = "545*+5/";
        EvaluatePostfixExpression expression = new EvaluatePostfixExpression();
        System.out.println(expression.evaluateExppression(exp));
    }

    public int evaluateExppression(String input){
        if (input == null)
            return 0;

        for (char ch: input.toCharArray()) {
            if (Character.isDigit(ch)){
                push(ch-'0');
            } else {
                if (!isEmpty()){
                    int first = pop();
                    int next = pop();

                    if (ch == '+')
                        push(first+next);
                    else if (ch == '-')
                        push(next-first);
                    else if (ch == '*')
                        push(first*next);
                    else if (ch == '/')
                        push(next / first);
                }
            }
        }

        return pop();
    }

    public int pop(){
        if (!isEmpty()){
            Node node = head.getNext();
            int key = head.getKey();
            head = null;
            head = node;
            return key;
        }
        return -1;
    }

    public int peek(){
        if (isEmpty())
            return -1;
        else
            return head.getKey();
    }

    public void push(int key){
        Node node = new Node(key);
        if (isEmpty()){
            head = node;
            size++;
        } else {
            node.setNext(head);
            head = node;
            size++;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }

}

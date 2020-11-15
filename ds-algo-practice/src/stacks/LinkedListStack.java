package stacks;

public class LinkedListStack {
    private Node head;
    private int size;

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(10);
        stack.push(11);
        stack.push(12);
        stack.push(13);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }

    public int pop(){
        if (!isEmpty()){
            Node next = head.getNext();
            int key = head.getKey();
            head = null;
            head = next;
            return key;
        }
        return -1;
    }

    public int peek(){
        if (!isEmpty())
            return head.getKey();
        return -1;
    }

    public boolean push(int key){
        Node node = new Node(key);
        if (isEmpty()){
            head = node;
            size++;
            return true;
        } else {
            Node next = head;
            node.setNext(next);
            head = node;
            size++;
            return true;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }
}

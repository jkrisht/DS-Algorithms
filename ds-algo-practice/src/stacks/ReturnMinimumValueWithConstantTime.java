package stacks;

public class ReturnMinimumValueWithConstantTime {

    private Node head;
    private Node leastNode;

    private int size;

    public static void main(String[] args) {
        ReturnMinimumValueWithConstantTime value = new ReturnMinimumValueWithConstantTime();
        value.push(-123);
        value.push(1);
        value.push(2);
        value.push(-3);
        value.push(3);
        value.push(-2);
        value.pop();
        value.pop();
        value.pop();
        value.pop();
        value.pop();
        System.out.println(value.peek());
        System.out.println(value.getMinimumValue());
    }

    public int getMinimumValue(){
        if (isEmpty())
            return -1;
        else
            return leastNode.getKey();
    }

    public int pop(){
        if (!isEmpty()){
            Node node = head.getNext();
            int key = head.getKey();
            if (head == leastNode){
                Node next = head.getNext();
                leastNode = node;
                while (next != null){
                    if (leastNode.getKey() > next.getKey()){
                        leastNode = next;
                    }
                    next = next.getNext();
                }
            }
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
            head = leastNode = node;
            size++;
        } else {
            node.setNext(head);
            if (leastNode.getKey() > key){
                leastNode = node;
            }
            head = node;
            size++;
        }
    }

    public boolean isEmpty(){
        return head == null;
    }
}

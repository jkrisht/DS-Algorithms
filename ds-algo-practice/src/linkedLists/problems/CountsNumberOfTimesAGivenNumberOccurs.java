package linkedLists.problems;

public class CountsNumberOfTimesAGivenNumberOccurs {

    /*
    https://www.geeksforgeeks.org/write-a-function-that-counts-the-number-of-times-a-given-int-occurs-in-a-linked-list/?ref=lbp
     */

    private Node head;
    private Node tail;
    private int size;

    public static void main(String[] args) {
        CountsNumberOfTimesAGivenNumberOccurs occurs = new CountsNumberOfTimesAGivenNumberOccurs();
        occurs.push(1);
        occurs.push(2);
        occurs.push(2);
        occurs.push(3);
        occurs.push(2);
        System.out.println(occurs.count(4));
    }

    public void push(int key){
        Node node = new Node(key);

        if (!isEmpty()){
            tail.setNode(node);
            tail = node;
            size++;
        } else {
            head = tail = node;
            size++;
        }

    }

    public boolean isEmpty(){
        if (head == null)
            return true;
        return false;
    }

    public int count(int key){
        int count = 0;

        if (!isEmpty()){
            Node node = head;
            while (node != null){
                if (key == node.getKey())
                    count++;
                node = node.getNode();
            }
        }

        return count;
    }

    public void countRepeatedNumbers(){

    }
}

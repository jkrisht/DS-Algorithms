package linkedLists.problems;

public class AddTwoNumbersRepresentedByLinkedList_2 {
    /*
    https://www.geeksforgeeks.org/sum-of-two-linked-lists/?ref=lbp
     */

    private Node head;
    private Node tail;
    private Node result;
    private Node previous;
    private int size;

    public static void main(String[] args) {
        AddTwoNumbersRepresentedByLinkedList_2 list = new AddTwoNumbersRepresentedByLinkedList_2();
        list.push(1);
        list.push(0);
        list.push(0);

        AddTwoNumbersRepresentedByLinkedList_2 list2 = new AddTwoNumbersRepresentedByLinkedList_2();
        list2.push(9);
        list2.push(1);

        Node node = new AddTwoNumbersRepresentedByLinkedList_2().addTwoList(list.head, list2.head);

        while (node != null){
            System.out.println(node.getKey());
            node = node.getNode();
        }
    }



    public Node addTwoList(Node node1, Node node2){

        int sum1 = 0;
        int sum2 = 0;

        while (node1 != null || node2 != null){
            if (node1 != null){
                sum1 = (sum1 + node1.getKey()) * 10;
                node1 = node1.getNode();
            }

            if (node2 != null){
                sum2 = (sum2 + node2.getKey()) * 10;
                node2 = node2.getNode();
            }
        }

        int sum = (sum1 + sum2) / 10;
        int result = 0;

        Node head = null;
        Node tail = null;

        while (sum != 0){
            result = sum % 10;
            sum = sum / 10;

            Node node = new Node(result);

            if (tail == null){
                head = tail = node;
            } else {
                Node temp = node;
                node.setNode(head);
                head = node;
            }
        }

        return head;
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

}

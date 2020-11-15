package linkedLists.problems;

public class ReverseLinkedList {
    /*
    https://www.geeksforgeeks.org/reverse-a-linked-list/?ref=lbp
     */

    private Node head;
    private Node tail;
    private int size;

    public static void main(String[] args) {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.push(1);
        reverseLinkedList.push(2);
        reverseLinkedList.push(3);
        reverseLinkedList.push(4);
        reverseLinkedList.printList();
        //reverseLinkedList.reverseList();
        reverseLinkedList.bestReverseList();
    }

    public Node bestReverseList(){
        Node previous = null;
        Node current  = head;
        Node next = null;

        while (current != null){
            next = current.getNode();
            current.setNode(previous);
            previous = current;
            current = next;
        }

        head = previous;
        printList();

        return null;
    }

    public void reverseList(){
        Node newHead = null;
        Node newTail = null;

        Node node = head;

        while (node != null){
            Node node1 = new Node(node.getKey());

            if (newTail == null){
                newHead = newTail = node1;
            } else {
                node1.setNode(newHead);
                newHead = node1;
            }

            node = node.getNode();
        }

        head = newHead;
        tail = newTail;
        printList();
    }

    public void push(int key){
        Node node = new Node(key);
        if (isEmpty()){
            head = tail = node;
        } else {
            tail.setNode(node);
            tail = node;
        }
    }

    public void printList(){
        Node curr = head;

        while (curr != null){
            System.out.print(curr.getKey()+" ");
            curr = curr.getNode();
        }
        System.out.println();
    }

    public boolean isEmpty(){
        if (head == null)
            return true;
        return false;
    }
}

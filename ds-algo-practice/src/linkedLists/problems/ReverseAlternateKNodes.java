package linkedLists.problems;

public class ReverseAlternateKNodes {

    /*
    https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/?ref=lbp
     */

    private Node head;
    private Node tail;
    private int size;

    public static void main(String[] args) {
        ReverseAlternateKNodes kNodes = new ReverseAlternateKNodes();

        for (int i = 0; i < 10; i++) {
            kNodes.push(i);
        }

        kNodes.printList(kNodes.head);

        kNodes.reverseAlternateKnodes(kNodes.head, 3);
    }

    public Node reverseAlternateKnodes(Node node, int k){
        if (k <= 0)
            return node;

        if (node == null)
            return node;

        int count = 0;
        Node left = node;
        Node right = null;

        while (right == null && count < k){
            if (count == k-1){
                right = node;
                break;
            }
            node = node.getNode();
            count++;
        }

        Node previous = null;

        Node reversed = reverse(left, right);

        if (head != node){
            previous = right.getNode();
        }

        printList(reversed);

        return null;
    }

    public Node reverse(Node start, Node end){

        Node previouse = null;
        Node current = start;
        Node next = null;

        while(current != end){
            next = current.getNode();
            current.setNode(previouse);
            previouse = current;
            current = next;
        }

        current.setNode(previouse);
        previouse = current;
        //printList(previouse);

        return previouse;
    }

    public void push(int key){
        Node node = new Node(key);

        if (isEmpty()) {
            head = tail = node;
            size++;
        }  else {
            tail.setNode(node);
            size++;
            tail = node;
        }
    }

    public void printList(Node node){
        while (node != null){
            System.out.print(node.getKey()+" ");
            node = node.getNode();
        }
        System.out.println();
    }

    public boolean isEmpty(){
        if (head == null)
            return true;
        return false;
    }
}

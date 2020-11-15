package linkedLists.problems;

public class ReverseLinkedListInGroupsOfGivenSize {

    /*
    https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/?ref=lbp
     */

    private Node head;
    private Node tail;
    private int size;

    public static void main(String[] args) {
        ReverseLinkedListInGroupsOfGivenSize llist = new ReverseLinkedListInGroupsOfGivenSize();
        llist.push(9);
        llist.push(8);
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        llist.printList(llist.head);
        llist.reverseTheListFromGivenNodeToLocation(llist.head, 2);
        llist.printList(llist.head);
    }

    public void reverseTheListFromGivenNodeToLocation(Node node, int location){

        if (location <= 0 || node == null)
            return;

        int count = 0;

        Node previous = null;
        Node current = node;
        Node next = null;

        Node n1 = head;

        while (previous == null){
            if (n1 == head)
                break;
            if (n1.getNode() == current){
                previous = n1;
                previous.setNode(null);
                break;
            }
            n1 = n1.getNode();
        }

        while (current != null && count < location+1){
            next = current.getNode();
            current.setNode(previous);
            previous = current;
            current = next;
            count++;
        }

        if (previous != null){
            head = previous;

            while (previous.getNode() != null){
                previous = previous.getNode();
            }
            previous.setNode(next);
        }
    }

    public void push(int key){
        Node node = new Node(key);
        if (isEmpty()){
            head = tail = node;
            size++;
        } else {
            tail.setNode(node);
            tail = node;
            size++;
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

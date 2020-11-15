package linkedLists.problems;

public class InsertInSortedOrder {
    private Node head;
    private Node tail;
    private int size;

    public static void main(String[] args) {
        InsertInSortedOrder sortedOrder = new InsertInSortedOrder();
        sortedOrder.push(3);
        sortedOrder.push(2);
        sortedOrder.push(1);
        sortedOrder.push(5);
        sortedOrder.push(4);
        sortedOrder.push(-1);
        System.out.println(sortedOrder.size);
        sortedOrder.printList(sortedOrder.head);
    }

    public void push(int key){
        Node newNode = new Node(key);

        if (isEmpty()){
            head = tail = newNode;
            size++;
        } else {
            Node node = head;
            Node lessNode = null;
            Node previous = null;

            while (node != null){
                if (key < node.getKey()){
                    lessNode = node;
                    break;
                }
                previous = node;
                node = node.getNode();
            }

            if (lessNode != null){

                newNode.setNode(lessNode);

                if (lessNode == head){
                    head = newNode;
                } else {
                    previous.setNode(newNode);
                }

            } else {
                tail.setNode(newNode);
                tail = newNode;
            }

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

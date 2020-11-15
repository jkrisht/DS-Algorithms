package linkedLists.problems;

public class MiddleOfGivenLinkedList {

    /*
    https://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/?ref=lbp
     */
    private Node head;
    private Node tail;
    private int size;

    public static void main(String[] args) {

        MiddleOfGivenLinkedList middle = new MiddleOfGivenLinkedList();
        middle.push(1);
        middle.push(2);
        middle.push(3);
        middle.push(4);
        middle.push(5); middle.push(6);
        middle.middleNode();

    }

    public boolean push(int key){
        Node node = new Node(key);

        if (!isEmpty()){
            tail.setNode(node);
            tail = node;
            size++;
            return true;
        } else {
            head = tail = node;
            size++;
            return true;
        }
    }

    public void middleNode(){
        if (!isEmpty()){

            int middle1 = size/2;

            int i = 1;

            System.out.println(i+" "+middle1);

            Node middle = head;

            while (i <= middle1){
                middle = middle.getNode();
                i++;
            }

            System.out.println(middle.getKey());
        }
    }

    public boolean isEmpty(){
        if (head == null)
            return true;
        return false;
    }

    public void printKeys(){
        Node node = head;

        while (node != null){
            System.out.print(node.getKey()+" ");
            node = node.getNode();
        }
        System.out.println();
    }

}


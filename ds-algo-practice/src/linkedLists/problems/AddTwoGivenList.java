package linkedLists.problems;

public class AddTwoGivenList {

    /*
    https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/?ref=lbp
     */
    private Node head;
    private Node tail;

    public static void main(String[] args) {
        AddTwoGivenList list1 = new AddTwoGivenList();
        list1.push(5);
        list1.push(6);
        list1.push(3);

        AddTwoGivenList list2 = new AddTwoGivenList();
        list2.push(8);
        list2.push(4);
        list2.push(2);

        AddTwoGivenList list3 = new AddTwoGivenList();
        list3.addTwoGivenLists(list1, list2);
    }

    public void push(int key){
        Node node = new Node(key);

        if (!isEmpty()){
            tail.setNode(node);
            tail = node;
        } else {
            head = tail = node;
        }
    }

    public AddTwoGivenList addTwoGivenLists(AddTwoGivenList list1, AddTwoGivenList list2){

        Node node1 = list1.head;
        Node node2 = list2.head;
        int carry = 0, sum = 0;
        Node result = null, next = null;

        while (node1 != null || node1 != null){

            sum = carry + (node1 != null ? node1.getKey() : 0) + (node2!=null ? node2.getKey():0);
            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            System.out.println(sum);

            Node node = new Node(sum);

            if (result == null){
                result = next = node;
            } else {
                next.setNode(node);
                next = node;
            }

            if (node1 != null)
                node1 = node1.getNode();
            if (node2 != null)
                node2 = node2.getNode();
        }

        while (result != null){
            System.out.println(result.getKey());
            result = result.getNode();
        }

        return null;
    }

    public boolean isEmpty(){
        if (head == null)
            return true;
        return false;
    }
}

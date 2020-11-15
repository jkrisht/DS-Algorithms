package doublyLinkedLists;

import java.security.acl.LastOwnerException;

public class DoublyLinedList {
    private Node head;
    private Node tail;
    private int size;
    private Node existingKeyNode;

    public static void main(String[] args) {
        DoublyLinedList list = new DoublyLinedList();

        for (int i = 1; i <= 4; i++){
            list.push(i);
        }
        list.printList(list.head);
        list.printReverseList(list.tail);

        // Get Top Key
        System.out.println(list.topKey());
        System.out.println(list.lastKey());

        // Push a node to front of the linked list
        list.pushFront(5);
        list.printList(list.head);
        list.printReverseList(list.tail);

        // Push back a node in linked list
        list.pushBack(6);
        list.printList(list.head);
        list.printReverseList(list.tail);
        System.out.println("Size: "+list.getSize());

        // Push back a node in linked list
        list.popBack();
        list.printList(list.head);
        list.printReverseList(list.tail);
        System.out.println("Size: "+list.getSize());

        // Find the given number in linked list
        System.out.println(list.find(5));

        // Remove the given key from the list
        list.printList(list.head);
        System.out.println(list.eraseKey(3));;

        // Add before the given node
        list.printList(list.head);
        System.out.println(list.addBefore(list.head, 7));
        System.out.println(list.addBefore(list.tail, 8));
        System.out.println(list.addBefore(list.tail, 9));
        System.out.println(list.addBefore(null, 10));
        System.out.println(list.addBefore(new Node(6), 9));
        list.printList(list.head);

        //  Add before the given node
        System.out.println(list.addAfter(list.head, 11));
        System.out.println(list.addAfter(list.head.getNext(), 12));
        System.out.println(list.addAfter(list.tail, 10));
        System.out.println(list.addAfter(null, 13));
        System.out.println(list.addAfter(new Node(15), 13));
        list.printList(list.head);
        list.printReverseList(list.tail);

        System.out.println("Final Size: "+list.getSize());
    }

    public boolean addAfter(Node node, int key){
        Node newNode = new Node(key);

        if (!isEmpty() && node != null){
            Node node1 = head;

            while (node1 != node && node1 != null){
                node1 = node1.getNext();
            }

            if (node1 != null){
                Node next = node1.getNext();
                node1.setNext(newNode);
                newNode.setPrevious(node1);
                newNode.setNext(next);
                if (next != null){
                    next.setPrevious(newNode);
                }
                if (node == tail)
                    tail = newNode;
                size++;
                return true;
            }
        }

        return false;
    }

    public boolean addBefore(Node node, int key){
        Node node1 = new Node(key);

        if (!isEmpty() && node != null){
            if (node == head){
                node1.setPrevious(null);
                node1.setNext(head);
                head = node1;
                size++;
                return true;
            } else if (node == tail){
                Node previous = tail.getPrevious();
                node1.setNext(tail);
                node1.setPrevious(previous);
                previous.setNext(node1);
                tail.setPrevious(node1);
                size++;
                return true;
            } else {
                Node current = head;

                while (current != node && current != null){
                    current = current.getNext();
                }

                if (current != null) {
                    Node previous = current.getPrevious();
                    Node next = current.getNext();
                    previous.setNext(node1);
                    next.setPrevious(node1);
                    size++;
                    return true;
                }
            }
        }

        return false;
    }

    public boolean eraseKey(int key){
        if (!isEmpty()){
            Node node = head;
            boolean isKeyExists = find(key);
            if (existingKeyNode != null){
                if (existingKeyNode == head){
                    Node node1 = head.getNext();
                    node1.setPrevious(null);
                    head = null;
                    head = node1;
                } else if (existingKeyNode == tail){
                    Node node1 = tail.getPrevious();
                    node1.setNext(null);
                    tail = null;
                    tail = node1;
                } else {
                    Node prev = existingKeyNode.getPrevious();
                    Node next = existingKeyNode.getNext();
                    existingKeyNode = null;
                    prev.setNext(next);
                    next.setPrevious(prev);
                }
                size--;
                return true;
            }
        }

        return false;
    }

    public boolean find(int key){
        if (!isEmpty()){
            Node node = head;

            while (node != null){
                if (node.getKey() == key){
                    existingKeyNode = node;
                    return true;
                }
                node = node.getNext();
            }
        }
        return false;
    }

    public void popBack(){
        if (!isEmpty()){
            Node node = tail.getPrevious();
            node.setNext(null);
            tail = node;
            size--;
        }
    }

    public void pushFront(int key){
        Node node = new Node(key);

        if (isEmpty()){
            head = tail = node;
            size++;
        } else {
            Node node1 = head;
            node.setNext(node1);
            node1.setPrevious(node);
            head = node;
            size++;
        }
    }

    public void pushBack(int key){
        Node node = new Node(key);

        if (isEmpty()){
            head = tail = node;
            size++;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
            tail = node;
            size++;
        }
    }

    public void push(int key){
        Node node = new Node(key);

        if (isEmpty()){
            head = tail = node;
            size++;
        } else {
            node.setPrevious(tail);
            tail.setNext(node);
            tail = node;
            size++;
        }
    }

    public void printList(Node node){
        while (node != null){
            System.out.print(node.getKey()+" ");
            node = node.getNext();
        }
        System.out.println();
    }

    public void printReverseList(Node node){
        while (node != null){
            System.out.print(node.getKey()+" ");
            node = node.getPrevious();
        }
        System.out.println();
    }

    public boolean isEmpty(){
        if (head == null)
            return true;
        return false;
    }

    public int topKey(){
        if (isEmpty())
            return Integer.MIN_VALUE;
        return head.getKey();
    }

    public int lastKey(){
        if (tail == null)
            return Integer.MIN_VALUE;
        return tail.getKey();
    }

    public int getSize(){
        if (isEmpty())
            return 0;
        return size;
    }
}

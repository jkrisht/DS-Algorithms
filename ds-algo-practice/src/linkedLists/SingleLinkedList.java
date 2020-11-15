package linkedLists;

import javax.swing.event.ChangeListener;

public class SingleLinkedList {

    /*
    isEmpty -> Checks whether Linked list is empty or not
    topKey -> Retrieves the top key from the linked list
    pushFront -> THis method will push the given value to the top of Linked List. if the head node is null then this will initialize the head and tail
    pushBack -> This will initialize head and tail if linked list is empty else it will push the given to last of linked list
    popFront -> Will remove the top value
    popBack -> Will remove the last value
    find -> Will return whether the given key is present in the list or not
    eraseKey -> Will remove the given key from the linked list which occurs first
    addBefore -> Will add the given key before the given node in linked list
    addAfter -> Will add the given key after the given node in the linked list
    toString -> Will return the entire linked list keys in the string format
     */

    Link head = null;
    Link tail = null;
    int size = 0;
    private Link existingKeyPreviousNode;

    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        // Check is list empty or not
        System.out.println(list.isEmpty());
        System.out.println(list.popFront());
        // Add an element to the front
        System.out.println(list.pushBack(1));
        System.out.println(list.pushFront(3));
        System.out.println(list.pushBack(-1));
        System.out.println(list.pushFront(2));
        System.out.println(list.pushBack(-3));
        System.out.println(list.toString());
        System.out.println(list.popFront());
        System.out.println(list.popFront());
        System.out.println(list.topKey());
        System.out.println(list.pushFront(9));
        System.out.println(list.toString());
        System.out.println(list.popBack());
        System.out.println(list.popBack());
        System.out.println(list.popBack());
        System.out.println(list.popBack());
        System.out.println(list.toString());
        System.out.println(list.pushBack(2));
        System.out.println(list.pushBack(1));
        System.out.println(list.pushBack(3));
        System.out.println(list.size);
        System.out.println(list.popFront());
        System.out.println(list.size);
        System.out.println(list.popFront());
        System.out.println(list.popFront());
        System.out.println(list.popFront());
        System.out.println(list.toString());
        System.out.println(list.size);

        System.out.println(list.pushFront(2));
        System.out.println(list.pushFront(3));
        System.out.println(list.pushBack(4));
        System.out.println(list.pushBack(5));
        System.out.println("is element exists?: " + list.find(4));
        System.out.println(list.toString());
        System.out.println(list.eraseKey(4));
        System.out.println(list.eraseKey(3));
        System.out.println(list.pushBack(-1));
        System.out.println(list.eraseKey(-1));
        System.out.println(list.toString());
        System.out.println(list.addBefore(list.head, 2));
        System.out.println(list.addBefore(list.head, 1));
        System.out.println(list.addBefore(null, 10));
        System.out.println(list.toString());

        System.out.println(list.pushBack(12));

        // Add after the given node
        System.out.println(list.addAfter(list.head, -3));
        System.out.println(list.addAfter(null, -4));
        System.out.println(list.toString());
        System.out.println(list.addAfter(list.head.getNode().getNode(), 3));
        System.out.println(list.toString());

        // Find middle of Linked List
        list.middleNode();
    }

    // Check if the list is empty or not
    public boolean isEmpty(){
        if (head == null)
            return true;
        else
            return false;
    }

    // Retrieve the top key
    public Number topKey(){
        if (!isEmpty()){
            return head.getKey();
        }
        return null;
    }

    // Insert the element at the top
    public boolean pushFront(int key){
        // create a node
        Link link = new Link(key);
        // Check is list is empty or not. If it is empty then add to head
        if (isEmpty()){
            head = tail =link;
            size++;
            return true;
        } else {
            link.setNode(head);
            head = link;
            size++;
            return true;
        }
    }

    // Insert the element at back
    public boolean pushBack(int key){
        boolean status = false;

        Link node = new Link(key);

        if (isEmpty()){
            head = tail = node;
            size++;
            status = true;
        } else {
            tail.setNode(node);
            tail = node;
            size++;
            status = true;
        }

        return status;
    }

    // Remove top key
    public boolean popFront(){
        if (!isEmpty()){
            head = head.getNode();
            size--;
            return true;
        }
        return false;
    }

    // Remove last element
    public boolean popBack(){
        if (!isEmpty() && tail != null){
            Link current = head;
            Link previous = current;

            while (current.getNode() != null){
                previous = current;
                current = current.getNode();
            }

            // remove the linkage fro list
            if (previous.getNode() == null){
                head = tail = null;
            } else {
                tail = previous;
                previous.setNode(null);
            }
            size--;
            return true;
        }
        return false;
    }

    // Find the given key
    public boolean find(int key){
        if (!isEmpty()){
            Link node = head;
            Link previous = node;

            while (node != null){
                if (node.getKey() == key){
                    existingKeyPreviousNode = previous;
                    return true;
                }
                previous = node;
                node = node.getNode();
            }
        }

        return false;
    }

    // Remove the first occurrence of given key in the list
    public boolean eraseKey(int key){
        if (!isEmpty()){
            Link current = head;
            if (find(key) && existingKeyPreviousNode != null){
                if (existingKeyPreviousNode == head){
                    head = existingKeyPreviousNode.getNode();
                }else{
                    existingKeyPreviousNode.setNode(existingKeyPreviousNode.getNode().getNode());
                }
                size--;
                return true;
            }
        }

        return false;
    }

    // Add a key before the given node
    public boolean addBefore(Link node, int key){
        Link link = new Link(key);
        if (!isEmpty()){
            if (node == head){
                Link headNode = head;
                link.setNode(headNode);
                head = link;
                size++;
                return true;
            } else {
                Link currentNode = head;
                Link previous = currentNode;

                while (currentNode != null){
                    if (currentNode == node){
                        previous.setNode(link);
                        link.setNode(currentNode);
                        size++;
                        return true;
                    }
                    previous = currentNode;
                    currentNode = currentNode.getNode();
                }

                if (node == null){
                    previous.setNode(link);
                    tail = link;
                    size++;
                    return true;
                }
            }
        }

        return false;
    }

    // Add after the given node
    public boolean addAfter(Link node, int key){
        Link link = new Link(key);

        if (head == node){
            Link headNextNode = head.getNode();
            head.setNode(link);
            link.setNode(headNextNode);
            size++;
            return true;
        } else if (node == null){
            tail.setNode(link);
            tail = link;
            size++;
            return true;
        } else {
            Link current = head;
            while (current != null){
                if (current == node){
                    Link after = node.getNode();
                    current.setNode(link);
                    link.setNode(after);
                    size++;
                    return true;
                }
                current = current.getNode();
            }
        }

        return false;
    }

    /*
        Problem Solving using linked List
     */
    public void middleNode(){
        if (!isEmpty()){

            int middle1 = size/2;

            int i = 1;

            Link middle = head;

            while (i <= middle1){
                middle = middle.getNode();
                i++;
            }

            System.out.println(middle.getKey());
        }
    }

    // Print all elements in the list
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        if (isEmpty())
            return builder.append("[]").toString();
        else{
            Link node = head;
            builder.append("[");
            while (node.getNode() != null){
                builder.append(""+node.getKey()+", ");
                node = node.getNode();
            }

            builder.append(node.getKey());

            builder.append("]");
            return builder.toString();
        }
    }
}

class Link{
    private Link node;
    private int key;

    public Link(int key){
        this.key = key;
        this.node = null;
    }

    public Link getNode(){
        return this.node;
    }

    public void setNode(Link node){
        this.node = node;
    }

    public int getKey(){
        return this.key;
    }

}

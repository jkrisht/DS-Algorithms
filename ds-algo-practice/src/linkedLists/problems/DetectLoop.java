package linkedLists.problems;

import java.util.HashSet;

public class DetectLoop {

    /*
    https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/?ref=lbp
     */

    private Node head;
    private Node tail;
    private int size;

    public static void main(String[] args) {
        DetectLoop detectLoop = new DetectLoop();
        detectLoop.push(1);
        detectLoop.push(2);
        detectLoop.push(3);
        System.out.println(detectLoop.tail.getKey());
        System.out.println(detectLoop.detectLoop());
        System.out.println(detectLoop.tail.getKey());
    }

    public boolean detectLoop() {
        HashSet<Node> nodes = new HashSet<>();

        Node node = head;
        tail.setNode(head);

        while (node != null) {
            if (nodes.contains(node)){
                node.setNode(null);
                return true;
            }

            nodes.add(node);
            node = node.getNode();
        }

        return false;
    }

    public void push(int key){
        Node node = new Node(key);

        if (head == null){
            head = tail = node;
            size++;
        } else {
            tail.setNode(node);
            tail = node;
            size++;
        }
    }
}

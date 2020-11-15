package trees.binarySearchTrees;

public class Node {
    private Node left;
    private Node right;
    private int key;

    public Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

    public void setLeft(Node left){
        this.left = left;
    }

    public void setRight(Node right){
        this.right = right;
    }

    public int getKey(){
        return this.key;
    }

    public void setKey(int key){
        this.key = key;
    }
}

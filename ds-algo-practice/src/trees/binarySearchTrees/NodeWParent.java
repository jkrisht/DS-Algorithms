package trees.binarySearchTrees;

public class NodeWParent {
    private NodeWParent parent;
    private int key;
    private NodeWParent left;
    private NodeWParent right;

    public NodeWParent(int key){
        this.key = key;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    public NodeWParent(int key, NodeWParent parent){
        this.key = key;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    public void setParent(NodeWParent parent) {

        this.parent = parent;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public void setLeft(NodeWParent left) {
        this.left = left;
    }

    public void setRight(NodeWParent right) {
        this.right = right;
    }

    public NodeWParent getParent() {
        return parent;
    }

    public int getKey() {
        return key;
    }

    public NodeWParent getLeft() {
        return left;
    }

    public NodeWParent getRight() {
        return right;
    }
}

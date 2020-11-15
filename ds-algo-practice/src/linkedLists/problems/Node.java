package linkedLists.problems;

class Node{
    Node node;
    int key;

    public Node(int key){
        this.key = key;
        this.node = null;
    }

    public void setNode(Node node){
        this.node = node;
    }

    public Node getNode(){
        return this.node;
    }
    public int getKey(){
        return this.key;
    }
}
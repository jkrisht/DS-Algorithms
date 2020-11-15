package stacks;

public class CharNode {
    private CharNode node;
    private char ch;

    public CharNode(char ch){
        this.ch = ch;
        this.node = null;
    }

    public CharNode getNode(){
        return this.node;
    }

    public void setNode(CharNode node){
        this.node = node;
    }

    public char getCh(){
        return this.ch;
    }
}

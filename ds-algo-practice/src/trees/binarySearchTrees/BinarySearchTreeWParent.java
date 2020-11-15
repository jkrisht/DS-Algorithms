package trees.binarySearchTrees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearchTreeWParent {

    private int size;
    private NodeWParent root;
    private NodeWParent findNode;
    private List<Integer> values;

    public static void main(String[] args) {
        BinarySearchTreeWParent tree = new BinarySearchTreeWParent();
        tree.insert(10);
        tree.insert(11);
        tree.insert(13);
        tree.insert(8);
        tree.insert(9);
        tree.insert(7);
        tree.insert(12);
        tree.insert(15);

        tree.printInOrder(tree.root);
        System.out.println();

        System.out.println(tree.rangeSearch(15));
    }

    public List<Integer> rangeSearch(int key){
        if (this.values == null)
            this.values = new ArrayList<>();

        NodeWParent node = relativeNode(key, this.root);
        System.out.println(node.getKey());

        if (node != null){
           NodeWParent parent = node.getParent();

           NodeWParent node1 = node;

           if (node1.getLeft() != null){
               while (node1.getLeft() != null){
                   node1 = node1.getLeft();
               }
           } else {
               node1 = node1.getRight();
           }

           values.add(node1.getKey());

            if (node.getKey() == key)
                values.add(node.getKey());

            if (parent != null)
                values.add(parent.getKey());
            else
                values.add(node.getRight().getKey());
        }
        return values;
    }

    public boolean delete(int key){
        if (empty()){
            return false;
        } else {
            boolean found = find(key);
            if (found){
                return delete(key, findNode);
            }
            return false;
        }
    }

    public boolean find(int key){
        if (empty())
            return false;
        else
            return find(key, this.root);
    }

    public boolean insert(int key){
        if (empty()){
            this.root = new NodeWParent(key);
            size++;
            return true;
        } else {
            return insert(key, this.root);
        }
    }

    private boolean insert(int key, NodeWParent node){
        if (node == null || node.getKey() == key)
            return false;

        else if (key < node.getKey()){
            if (node.getLeft() == null){
                node.setLeft(new NodeWParent(key, node));
                size++;
                return true;
            } else
                return insert(key, node.getLeft());
        } else {
            if (node.getRight() == null){
                node.setRight(new NodeWParent(key, node));
                size++;
                return true;
            } else
                return insert(key, node.getRight());
        }
    }

    private boolean find(int key, NodeWParent node){
        if (node == null)
            return false;

        if (key == node.getKey()){
            this.findNode = node;
            return true;
        } else if (key < node.getKey()){
            return find(key, node.getLeft());
        } else {
            return find(key, node.getRight());
        }
    }

    private boolean delete(int key, NodeWParent node){
        if (isLeafNode(node)){
            return deleteLeafNode(key, node);
        } else if (isSingleNode(node)){
            return deleteSingleNode(key, node);
        } else if (isMultiNode(node)){
            return deleteMultiNode(key, node);
        }
        return false;
    }

    private void printInOrder(NodeWParent node){
        if (node != null){
            printInOrder(node.getLeft());
            System.out.print(node.getKey()+" ");
            printInOrder(node.getRight());
        }
    }

    private boolean isMultiNode(NodeWParent node){
        return (node.getLeft() != null && node.getRight() != null);
    }

    private boolean isSingleNode(NodeWParent node){
        boolean isLeft = (node.getLeft() == null);
        boolean isRight = (node.getRight() == null);

        if (isLeft && isRight) {
            return false;
        } else if (isLeft || isRight){
            return true;
        }

        return false;
    }

    private boolean isLeafNode(NodeWParent node){
        return (node.getLeft() == null && node.getRight() == null);
    }

    private boolean deleteLeafNode(int key, NodeWParent node){
        NodeWParent parent = node.getParent();

        if (parent != null){
            if (key < parent.getKey()){
                parent.setLeft(null);
                size--;
                return true;
            } else {
                parent.setRight(null);
                size--;
                return true;
            }
        } else {
            this.root = node.getLeft();
            size--;
            return true;
        }
    }

    private boolean deleteSingleNode(int key, NodeWParent node){
        NodeWParent parent = node.getParent();

        NodeWParent nonEmpty = null;
        if (node.getLeft() == null){
            nonEmpty = node.getRight();
        } else {
            nonEmpty = node.getLeft();
        }

        if (parent != null){
            if (key < parent.getKey()){
                parent.setLeft(nonEmpty);
                nonEmpty.setParent(parent);
                size--;
                return true;
            } else {
                parent.setRight(nonEmpty);
                nonEmpty.setParent(parent);
                size--;
                return true;
            }
        } else {
            this.root = nonEmpty;
            this.root.setParent(null);
            size--;
            return true;
        }
    }

    private boolean deleteMultiNode(int key, NodeWParent node){
        if (node.getParent() != null){
            NodeWParent minNode = minNode(node);
            int minKey = minNode.getKey();

            NodeWParent minNodeParent = minNode.getParent();
            minNodeParent.setLeft(null);
            node.setKey(minKey);
            size--;
            return true;
        } else {
            NodeWParent maxNode = maxNode(node.getLeft());
            node.setKey(maxNode.getKey());

            NodeWParent maxParent = maxNode.getParent();

            if (maxParent != this.root)
                maxParent.setRight(null);
            else{
                maxParent.setLeft(maxNode.getLeft());
            }
            size--;
            return true;
        }
    }

    private NodeWParent minNode(NodeWParent node){
        if (node == null || node.getLeft() == null)
            return node;

        return minNode(node.getLeft());
    }

    private NodeWParent maxNode(NodeWParent node){
        if (node == null || node.getRight() == null)
            return node;

        return maxNode(node.getRight());
    }

    private NodeWParent relativeNode(int key, NodeWParent node){
        if (node == null || key == node.getKey())
            return node;

        if (key < node.getKey()){
            if (node.getLeft() != null){
                if (key <= node.getLeft().getKey())
                    return node.getLeft();
                else
                    return relativeNode(key, node);
            }
        } else {
            if (node.getRight() != null){
                if (key >= node.getRight().getKey())
                    return node.getRight();
                else
                    return relativeNode(key, node.getRight());
            }
        }
        return node;
    }

    public int getSize(){
        return size;
    }

    public boolean empty(){
        return this.root == null;
    }
}

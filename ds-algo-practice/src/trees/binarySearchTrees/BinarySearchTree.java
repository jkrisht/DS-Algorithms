package trees.binarySearchTrees;

import java.util.NoSuchElementException;

public class BinarySearchTree {

    private Node root;
    private int size;

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(20);
        tree.insert(14);
        tree.insert(30);
        tree.insert(31);
        tree.insert(25);
        tree.insert(29);
        tree.insert(24);
        tree.insert(14);
        tree.insert(13);
        tree.insert(16);
        tree.insert(17);
        tree.insert(15);

        // Print from root
        tree.print(tree.root);
        System.out.println();

        // Size of the tree
        System.out.println(tree.size());

        // Find minimum value in the root
        System.out.println(tree.min());

        // Find maximum node
        System.out.println(tree.max());

        // Search for given key
        System.out.println(tree.search(-2));
        System.out.println(tree.search(12));

        // Delete given key
        tree.printPreOrder(tree.root);
        System.out.println();
        tree.delete(30);
        System.out.println("Root: "+ tree.root.getKey());
        tree.printPreOrder(tree.root);
        System.out.println();

        tree.delete(25);
        System.out.println("Root: "+ tree.root.getKey());
        tree.printPreOrder(tree.root);
        System.out.println();

        tree.delete(29);
        System.out.println("Root: "+ tree.root.getKey());
        tree.printPreOrder(tree.root);
        System.out.println();

        tree.delete(20);
        System.out.println("Root: "+ tree.root.getKey());
        tree.printPreOrder(tree.root);
        System.out.println();

        tree.delete(14);
        System.out.println("Root: "+ tree.root.getKey());
        tree.printPreOrder(tree.root);
        System.out.println();

        tree.delete(15);
        System.out.println("Root: "+ tree.root.getKey());
        tree.printPreOrder(tree.root);
        System.out.println();

        tree.delete(24);
        System.out.println("Root: "+ tree.root.getKey());
        tree.printPreOrder(tree.root);
        System.out.println();

        tree.delete(17);
        System.out.println("Root: "+ tree.root.getKey());
        tree.printPreOrder(tree.root);
        System.out.println();

        tree.delete(16);
        System.out.println("Root: "+ tree.root.getKey());
        tree.printPreOrder(tree.root);
        System.out.println();

        tree.delete(13);
        System.out.println("Root: "+ tree.root.getKey());
        tree.printPreOrder(tree.root);
        System.out.println();

        System.out.println(tree.delete(32));
        System.out.println(tree.delete(31));

        if (tree.root == null)
            System.out.println("Root is empty");
    }

    public boolean delete(int key){
        if (root != null){
            Node node = search(key, root);
            if (node != null){
                return delete(node);
            } else {
                return false;
            }
        }

        throw new NoSuchElementException("Tree is Empty");
    }

    public boolean search(int key){
        if (root != null)
            return search(key, root) != null;
        throw new NoSuchElementException("Tree is Empty");
    }

    public int max(){
        if (root != null)
            return maxNode(root).getKey();
        throw new NoSuchElementException("Tree is Empty");
    }

    public int min(){
        if (root != null){
            return minNode(root).getKey();
        }
        throw new NoSuchElementException("Tree is Empty");
    }

    public void insert(int key){
        if (empty()){
            root = new Node(key);
            size++;
        }
        else
            insert(key, root);
    }

    public void print(Node node){
        if (node != null){
            print(node.getLeft());
            System.out.print(node.getKey()+" ");
            print(node.getRight());
        }
    }

    private void printPreOrder(Node node){
        if (node != null){
            System.out.print(node.getKey()+" ");
            printPreOrder(node.getLeft());
            printPreOrder(node.getRight());
        }
    }

    private boolean delete(Node node){
        if (isLeafNode(node)){
            Node parent = getParentNode(node);
            if (parent != null){
                if (node.getKey() < parent.getKey()){
                    parent.setLeft(null);
                    size--;
                    return true;
                } else {
                    parent.setRight(null);
                    size--;
                    return true;
                }
            } else {
                root = null;
                size = 0;
                return true;
            }
        }
        else if (isSingleNode(node)){
            Node parent = getParentNode(node);
            if (parent != null){
                return setSingleNode(node, parent);
            } else {
                if (node.getLeft() != null){
                    node.setKey(node.getLeft().getKey());
                    node.setLeft(null);
                    return true;
                } else if (node.getRight() != null){
                    node.setKey(node.getRight().getKey());
                    node.setRight(null);
                    return true;
                }
                return false;
            }
        }
        else {
            Node maxNode = maxNode(node.getLeft());
            Node maxNodeParent = getParentNode(maxNode);
            node.setKey(maxNode.getKey());

            if (node == maxNodeParent || maxNodeParent == root)
                maxNodeParent.setLeft(null);
            else
                maxNodeParent.setRight(null);
        }
        return false;
    }

    private boolean setSingleNode(Node node, Node parent){
        if (node.getKey() > parent.getKey()){
            if (node.getLeft() != null){
                parent.setRight(node.getLeft());
                return true;
            }
            else{
                parent.setRight(node.getRight());
                return true;
            }
        } else {
            if (node.getLeft() != null){
                parent.setLeft(node.getLeft());
                return true;
            }
            else{
                parent.setLeft(node.getRight());
                return true;
            }
        }
    }

    private boolean isLeafNode(Node node){
        return (node.getLeft() == null && node.getRight() == null);
    }

    private boolean isSingleNode(Node node){

        if (node.getLeft() == null && node.getRight() != null)
            return true;

        if (node.getLeft() != null && node.getRight() == null)
            return true;

        return false;
    }

    private Node getParentNode(Node node){
        if (node == null || node == root)
            return null;
        else
            return getParentNode(node, root);
    }

    private Node getParentNode(Node node, Node parent){
        if (node == parent)
            return parent;

        if (parent == null)
            return null;

        if (node.getKey() < parent.getKey()){
            if (node == parent.getLeft())
                return parent;
            else
                return getParentNode(node, parent.getLeft());
        } else{
            if (node == parent.getRight())
                return parent;
            else
                return getParentNode(node, parent.getRight());
        }
    }

    private Node search(int key, Node node){
        if (node == null)
            return null;

        if (key == node.getKey())
            return node;

        if (key < node.getKey())
            return search(key, node.getLeft());
        else
            return search(key, node.getRight());
    }

    private Node maxNode(Node node){
        if (node.getRight() == null)
            return node;
        else
            return maxNode(node.getRight());
    }

    private Node minNode(Node node){
        if (node.getLeft() == null)
            return node;
        else
            return minNode(node.getLeft());
    }

    private void insert(int key, Node node){
        if (node == null || node.getKey() == key)
            return;

        if (key < node.getKey()){
            if (node.getLeft() == null){
                node.setLeft(new Node(key));
                size++;
            }
            else
                insert(key, node.getLeft());
        } else if (key > node.getKey()){
            if (node.getRight() == null){
                node.setRight(new Node(key));
                size++;
            }
            else
                insert(key, node.getRight());
        }
    }

    public boolean empty(){
        return root == null;
    }

    public int size(){
        return this.size;
    }
}

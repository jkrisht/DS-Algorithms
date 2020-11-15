package hash;

import java.math.BigInteger;

public class HashMapImpl {

    final int capacity = 6;
    private int size;
    private Node[] table;

    public HashMapImpl(){
        this.table = new Node[this.capacity];
    }

    public static void main(String[] args) {
        HashMapImpl hashMap = new HashMapImpl();

        for (int i = 1; i <= 100; i++) {
            hashMap.put(i, 1000+i);
        }

        for (int i = 1; i <= 100; i++) {
            System.out.println(hashMap.hash(i)+" "+hashMap.get(i));
        }

        System.out.println();

        System.out.println(hashMap.containsValue(4000));

        System.out.println(hashMap.remove(5));
        System.out.println(hashMap.remove(11));

        System.out.println();

        for (int i = 1; i <= 100; i++) {
            System.out.println(hashMap.get(i));
        }
    }

    public Integer remove(int key){
        Node node = table[hash(key)];
        Node previous = node;

        while (node != null){
            if (node.getKey() == key){
                int value = node.getValue();
                if (previous == node){
                    node = node.getNext();
                    table[hash(key)] = node;
                } else {
                    previous.setNext(node.getNext());
                    table[hash(key)] = previous;
                }
                return value;
            }
            previous = node;
            node = node.getNext();
        }
        return null;
    }

    public boolean containsValue(int value){
        for (int i = 0; i < table.length; i++) {
            Node node = table[hash(i)];
            while (node != null){
                Integer integer = get(i);
                if (integer != null && integer == value)
                    return true;
                node = node.getNext();
            }
        }

        return false;
    }

    public boolean containsKey(int key){
        Node node = table[hash(key)];

        while (node != null){
            if (node.getKey() == key)
                return true;
            node = node.getNext();
        }

        return false;
    }

    public Integer get(int key){
        int hash = hash(key);
        Integer value = null;

        Node node = table[hash];

        while (node != null){
            if (key == node.getKey()){
                value = node.getValue();
                break;
            }
            node = node.getNext();
        }

        return value;
    }

    public int put(int key, int value){
        int hash = hash(key);

        if (table[hash] == null){
            Node node = new Node(key, value, hash);
            table[hash] = node;
            size++;
            return value;
        } else {
            Node chain = table[hash];
            Node previous = chain;
            while (chain != null){
                if (chain.getKey() == key){
                    int oldValue = chain.getValue();
                    chain.setValue(value);
                    return oldValue;
                }
                previous = chain;
                chain = chain.getNext();
            }
            if (chain != null)
                chain.setNext(new Node(key, value, hash));
            else
                previous.setNext(new Node(key, value, hash));

            size++;
            return value;
        }
    }

    private int getSize(){
        return size;
    }

    private int hash(int key){
        return Math.abs(key % this.capacity);
    }

    public boolean empty(){
        return this.size == 0;
    }
}

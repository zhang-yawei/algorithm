package Finds;


/**
 * Created by zhang on 2017/6/20.
 * 顺序查找 无序链表
 */

public class SequentialSearchST<Key extends Comparable<Key>,Value > implements ST<Key ,Value >{

    private Node first;

    private class Node {

        Key key;
        Value val;
        Node next;


        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.val = value;
            this.next = next;
        }
    }


    public Value get(Key key){
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) return x.val;
        }
        return null;
    }

    public void put(Key key, Value val) {

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }

        }
        first = new Node(key, val, first);
    }


    /*删除key对应的键值对*/
    public void delete(Key key){

        if (first == null) return;

        if (first.key.equals(key)) {
            first = first.next;
            return;
        }


        for (Node x = first; x != null; x = x.next) {
            Node nextNode = x.next;
            if ( nextNode != null && key.equals(nextNode.key)){
                x.next = nextNode.next;
                return;
            }
        }
    }

    /*是否包含*/
    public boolean contains(Key key){
        for (Node x = first;x != null;x = x.next){
            if (key.equals(x.val)) return true;
        }
        return false;
    }

    /*是否为空*/
    public boolean isEmpty(){
        if (first == null) return true;
        return false;
    }

    /*符号表大小*/
    public int size(){

        int size = 0;
        for (Node x = first;x != null;x = x.next){
            size++;
        }
        return size;
    }

    public int rank(Key key)
    {
        return 0;
    }


}

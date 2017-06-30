package Finds;

import com.sun.org.apache.bcel.internal.generic.RET;

/**
 * Created by zhang on 2017/6/28.
 * 二叉查找树
 */
public class BST<Key extends Comparable<Key>,Value> implements ST<Key,Value> {


    Node root;

    private class Node{

        private Key key;
        private Value value;
        private Node left,right;
        private int N;  // 以该节点为根的子树中的节点数目

        public Node(Key key,Value value,int n) {
            this.key = key;
            this.value = value;
            this.N = n;
        }
    }



    /*插入新值*/
    public void put(Key key,Value value){

        put(root,key,value);

    }

    /*取值*/
    public Value get(Key key){
        return get(root,key);
    }

    /*删除key对应的键值对*/
    public void delete(Key key){

    }

    /*是否包含*/
    public boolean contains(Key key){
        return (get(key) == null);
    }

    /*是否为空*/
    public boolean isEmpty(){
        return (root == null);
    }

    /*符号表大小*/
    public int size(){
        return size(root);
    }

    /*小于key的键的数量*/
    public int rank(Key key){

    }




    // 给定的树的size
    public int size(Node node){
        if (node == null) return 0 ;
        return node.N;
    }

    public Key min(){
        if (root == null) return null;
        return min(root).key;
    }


    public Key floor(Node node){

    }



    /**------------------------------------------------------------------------*/


    // 在给定的树中查找节点.
    public Value get(Node node,Key key){
        if (node == null) return null;

        int result = node.key.compareTo(key);
        if (result > 0) return get(node.left,key);
        else if (result < 0) return get(node.right,key);
        return node.value;
    }






    // 把 key value 插入到给定的树中,返回树的根节点
    private Node put(Node node,Key key,Value value){

        if (node == null) return new  Node(key,value,1);
        int resule = key.compareTo(node.key);
        if (resule < 0) {
            node.left = put(node.left,key,value);
        }else if (resule > 0){
            node.right = put(node.right,key,value);
        }else {
            node.value = value;
        }

        node.N = size(node.left) + size(node.right) +1;  // 更新N的值
        return node;
    }


    // 返回给定的树中,最小的节点
    private Node min(Node node){
        if (node == null) return null;
        else if (node.left == null) return node;
        else return min(node.left);
        // 如果当前节点左子树为空,那么当前节点为最小值. 如果不为空,那么最小值为当前节点左子树中的最小值. 递归的思想
    }


    // 在给定的树中,找到小于key的最大键.
    private Node floor(Node node,Key key){
        if (node == null) return null;
        int res = key.compareTo(node.key);
        if (res < 0 )

    }



}

package Finds;

//import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.Queue;

/**
 * Created by zhang on 2017/6/28.
 * binary search tree
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

      root = put(root,key,value);

    }

    /*取值*/
    public Value get(Key key){
        return get(root,key);
    }

    /*删除key对应的键值对*/
    public void delete(Key key){
        root = delete(root, key);
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
        return rank(root,key);
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


    // 向下取整
    public Key floor(Node node){
        Node x = floor(root,node.key);
        if (x == null) return null;
        else  return x.key;
    }

    public Key select(int index){
    return select(root,index).key;

    }

    public void deleteMin(){
        root = deleteMin(root);
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




    // 把 key value 插入到给定的树中,返回树的根节点.  注意递归的调用
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


    // 在给定的树中,找到小于等于key的最大键.
    private Node floor(Node node,Key key){
        if (node == null) return null;

        int res = key.compareTo(node.key);

        if (res == 0) return node;
        else if (res < 0 ) return floor(node.left,key);

        Node t = floor(node.right,key);
        if (t != null) return t;
        else  return node;
    }


    // 小于等于key键的个数  .  key键在树种的排名
    private int rank(Node node,Key key) {
        if (node == null) return 0;
        int res = key.compareTo(node.key);
        if (res == 0) return size(node);
        else if (res < 0) return rank(node.left, key);
        return size(node.left) +1 + rank(node.right,key);

    }


    // 找到排名为index的节点
    private Node select(Node node,int index){
        if (node == null) return null;
        int compareResult = size(node) - index;
        if (compareResult == 0) return node;
        else if (compareResult < 0) return select(node.right,index - size(node.left) -1);
        else return select(node.left,index);

    }


    private Node deleteMin(Node node) {
        // 左子树为空的时候,将右子树返回即可.
        if (node.left == null) return node.right;

        node.left =  deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;

    }


    // 删除指定键的节点
    private Node delete(Node node, Key key){
        if (node == null) return null;
        int result = key.compareTo(node.key);
        if (result < 0) return delete(node.left,key);
        else if (result > 0) return delete(node.right,key);
        else {
            // 左子树为空,返回右子树.  右子树为空,返回左子树.   都不为空,取后继节点.
            if (node.right == null) return node.left;
            else if (node.left == null) return node.right;
            else{
                Node newNode = min(node.right);
                newNode.left = node.left;
                newNode.right = deleteMin(node.right);
                newNode.N = size(newNode.left) + size(newNode.right) + 1;
                return newNode;
            }

        }

    }




    // 中序遍历
    private void traverseTree(Node node){
        if (node.left != null) traverseTree(node.left);
        System.out.println("键为:" + node.key + "值为:" + node.value);
        if (node.right != null) traverseTree(node.right);

    }



    private void keys(Node node,Queue<Key> keyQueue,Key lo,Key hi){
        if (node == null) return;
        int lowCompareResult = lo.compareTo(node.key);
        int hightCompareResult = hi.compareTo(node.key);
        if (lowCompareResult < 0) keys(node.left,keyQueue,lo,hi);
        else if (lowCompareResult <=0 && hightCompareResult >= 0) keyQueue.add(node.key);
        else if (hightCompareResult > 0) keys(node.right,keyQueue,lo,hi);

    }


}

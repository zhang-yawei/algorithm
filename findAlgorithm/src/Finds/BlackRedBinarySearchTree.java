package Finds;

import com.sun.security.auth.NTDomainPrincipal;

/** 红黑二叉查找树
* 红链接: 链接两个2-节点,构成一个3-节点
* 黑链接: 2结点的普通链接
* 在红黑树中  1. 红链接均为左链接.   2.没有任何一个结点同时和两个红链接相连.   3 该树是完美黑色平衡的,即任意空连接到根结点的路径上的黑链接数量相等.
 * 满足这样的红黑树和相应的2-3树,是一一对应的.
 *
 * 红黑二叉查找树是由2-3树变化而来, 2-3树完美平衡,但是查找和插入复杂.  二叉树查找插入方便. 所以红黑树将两个算法的优点结合.
 *
* */
public class BlackRedBinarySearchTree <Key extends Comparable<Key>,Value> implements ST<Key,Value>{

    private  static final boolean RED = true;
    private  static final boolean BLACK = false;


    Node root; // 根节点


    private class  Node{
        Key key;
        Value value;
        Node left,right; // 左右子树
        int N;  // 这颗子树种的结点总数.
        boolean color;  // 指向这个结点的链接的颜色. red为true,  black 为 false;

        Node(Key key,Value val,int size,boolean color){
            this.key = key;
            this.value = val;
            this.N = size;
            this.color = color;
        }


    }






    /*插入新值*/
    public void put(Key key,Value value){

    }

    /*取值*/
    public Value get(Key key){
        return null;
    }

    /*删除key对应的键值对*/
    public void delete(Key key){

    }

    /*是否包含*/
    public boolean contains(Key key){
        return true;
    }

    /*是否为空*/
    public boolean isEmpty(){
        return true;
    }

    /*符号表大小*/
    public int size(){
        return size(root);
    }

    public int rank(Key key){
        return 0;
    }



/**********************************************************************************/


    private Node put(Node h,Key key,Value val){

        if (h == null) return new Node(key,val,1,RED);

        int cmp = key.compareTo(h.key);
        if (cmp < 0) h.left = put(h.left,key,val);
        else if (cmp > 0) h.right = put(h.right,key,val);
        else h.value = val;

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);  // 如果右子节点是红色,左子节点是黑色,进行左旋
        if (isRed(h.left) && isRed(h.left.left)) h= rotateRight(h); // 如果左子节点是红色,左子节点的左子节点也只是红色,进行右旋
        if (isRed(h.left) && isRed(h.right))  flipColors(h);        // 如果左子节点,右子节点都是红色,那么颜色转换

        h.N = size(h.left) + size(h.right) +1;
        return h;

    }




    private int size(Node node){
        if (node == null) return 0;
        return size(node.left) + size(node.right) +1;
    }



    // 判断结点是否为红树
    private  boolean isRed(Node node){
        if (node == null) return false;
        return node.color == RED;
    }

    // 有一个结点,如果这个结点的右链接是红链接,那么把这个红链接转化为左链接.  左旋转
    private Node rotateLeft(Node node){

        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        x.N = node.N;
        node.N = size(node.left) + size(node.right) +1;
        return x;


    }

    // 右旋转,作用是将左边两条连续的红链接,转为为一左一右的两条子链接
     private Node rotateRight(Node node){
         Node x = node.left;
         node.left = x.right;
         x.right = node;
         x.color = node.color;
         node.color = RED;
         x.N = node.N;
         node.N = size(node.left) + size(node.right) +1;
         return x;
     }


    private void flipColors(Node h){
         h.color = RED;
         h.left.color = BLACK;
         h.right.color = BLACK;
    }






}

package Finds;

import com.sun.javafx.image.PixelUtils;
import com.sun.org.apache.bcel.internal.generic.NEW;

/** 基于拉链法的散列表
*
* */
public class SeparaterChainingHashST <Key extends Comparable<Key>,Value> {

    private int N;  // 键值对总数
    private int M;  // 散列表的大小
    private SequentialSearchST<Key,Value>[] st;  // 存放链表对象的数组



    public   SeparaterChainingHashST(){
        this(997);
    }

    // 初始化,生产M个链表
    public SeparaterChainingHashST(int M){
        this.M = M;
        st =  new SequentialSearchST[M];
        for (int i=0;i<M;i++){
            st[i] = new SequentialSearchST<>();
        }

    }


    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key){
        return (Value) st[hash(key)].get(key);
    }

    public void  put(Key key,Value value){
        st[hash(key)].put(key,value);
    }




}

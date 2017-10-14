package Finds;

import java.util.Iterator;

/**
 * Created by zhang on 2017/6/14.
 */
public interface ST <Key extends Comparable<Key>,Value >{

    /*插入新值*/
    public void put(Key key,Value value);

    /*取值*/
    public Value get(Key key);

    /*删除key对应的键值对*/
    public void delete(Key key);

    /*是否包含*/
    public boolean contains(Key key);

    /*是否为空*/
    public boolean isEmpty();

    /*符号表大小*/
    public int size();

//    /*最小的键*/
//    public Key min();
//
//    /*最大的键*/
//    public Key max();
//
//    /*向上取整,小于等于key的最小整数*/
//    public Key ceiling(Key key);
//
//    /*向下取整*/
//    public Key floor(Key key);
//
//    /*排名为index的键*/
//    public Key select(int index);
//
    /*小于key的键的数量*/
     public int rank(Key key);
//
//    /*删除最小键*/
//    public void  deleteMin();
//
//    /*删除最大键*/
//    public void deleteMax();
//
//    /*lo..hi 之间建的数量*/
//    public int size(Key lo,Key hi);
//
//    /*li...hi之间所有的键,已排序*/
//    Iterable<Key> keys(Key lo,Key hi);
//
//    /*表中所有的键,已排序*/
//    Iterable<Key> keys();

}

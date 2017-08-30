package Finds;


import java.util.TreeMap;

/** 基于线性探测法的散列表
*  用大小为M的数组保存N个键值对,其中M>N.我们需要依靠数组中的空位解决碰撞冲突.基于这种策略的所有方法被统称为  开放地址 散列表
* */
public class LinerProbingHashST <Key,Value>{

    private int N; // 符号表中键值对的总数
    private int M = 16; // 线性探测表的大小
    private Key[] keys; // 键
    private Value[] vals; // 值

    public LinerProbingHashST(){
        keys = (Key[]) new Object[M];
        vals = (Value []) new Object[M];
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void  resize(int m){

        LinerProbingHashST<Key,Value> t;
        t = new LinerProbingHashST<>(m);
        for(int i=0;i<M;i+=){
            if (keys[i] != null){
                t.put(keys[i],vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;

    }



    public void put(Key key,Value value){

        if (N>=M/2) resize(2*M);


        int index = hash(key);
        while (keys[index] != null) {
            if (keys[index].equals(key)){
                vals[index] = value;
                return;
            }
            index= (index + 1)% M;

        }

        keys[index] = key;
        vals[index] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i=hash(key); keys[i] != null; i=(i+1) % M){
            if (keys[i].equals(key)){
                return vals[i];
            }
        }
        return null;
    }

    public boolean contains(Key key){
        return !(get(key) == null);
    }




/**
 * 删除的时候,把命中的键值对删除,然后把同一模后面的键值对删除后重新插入
 * */
    public void delete(Key key){
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i])){
            i = (i+1) % M;
        }

        keys[i] = null;
        vals[i] = null;

        i = (i+1)%M;
        while (keys[i] != null){
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N --;
            put(keyToRedo,valToRedo);
            i = ++i % M;

        }
        N--;

        if (N > 0 && N == M/8) resize(M/2);

    }




    public void  treeMap(){
        TreeMap
    }



}

package Finds;

/**
 * Created by zhang on 2017/6/20.
 * 有序数组,二分查找
 */
public class BinarySearchTree<Key extends Comparable<Key>,Value> implements ST<Key,Value>{


    private Key[] keys;
    private Value[] values;
    private int N;




    /*插入新值*/
    public void put(Key key,Value value){

        int i = rank(key);
        // 命中
        if (i < N && keys[i].compareTo(key) == 0) {
            values[i] = value;
            return;
        }
        for (int j = N;j > i;j--){
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        N++;

    }

    /*取值*/
    public Value get(Key key){
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return values[i];
        return null;
    }

    /*删除key对应的键值对*/
    public void delete(Key key){
        int low = 0, hight = N - 1;
        while (low <= hight) {
            int mid = (low + hight) / 2;
            Key midKey = keys[mid];
            if (key.compareTo(midKey) < 0) hight = mid - 1;
            else if (key.compareTo(midKey) > 0) low = mid + 1;
            else {

                int i = mid;
               while (i<N-1){
                   keys[i] = keys[i++];
                   values[i] = values[i++];
               }
               N--;
            };
        }
    }

    /*是否包含*/
    public boolean contains(Key key){

        int low = 0, hight = N - 1;
        while (low <= hight) {
            int mid = (low + hight) / 2;
            Key midKey = keys[mid];
            if (key.compareTo(midKey) < 0) hight = mid - 1;
            else if (key.compareTo(midKey) > 0) low = mid + 1;
            else return true;
        }
        return false;

    }



    /*是否为空*/
    public boolean isEmpty(){
        return N==0;
    }

    /*符号表大小*/
    public int size(){
        return N;
    }


    public int rank(Key key) {
        int low = 0;
        int hight = N - 1;
        while (low <= hight) {
            int mid = (low + hight) / 2;
            Key midKey = keys[mid];
            if (key.compareTo(midKey) < 0) hight = mid - 1;
            else if (key.compareTo(midKey) > 0) low = mid + 1;
            else return mid;
        }
        return low;

    }

}

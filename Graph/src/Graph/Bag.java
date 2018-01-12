package Graph;
import java.lang.Iterable;
import java.util.Iterator;
import java.util.Objects;

/**
 * Created by zhangdawei on 2018/1/9.
 */
public class Bag<Item> implements Iterable<Item>{

    private Item[] items;
    private int count;




    public Bag(int cap){

        items = (Item[]) new Object[cap];
        count = 0;
    }

    public void add(Item item){
        if (count == items.length) resize(count+1);

        items[count] = item;
        count ++;
    }

    public  boolean isEmpty(){
        return count == 0;
    }

    public int size(){
        return count;
    }


    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i=0; i<count;i++){
            temp[i] = items[i];
        }
        items = temp;
    }


    public Iterator<Item> iterator() {

        return new BagIterator();
    }



    private class BagIterator implements Iterator<Item>{

        private int i=0;

       public boolean hasNext(){
            return (i < count);
        }


        public Item next(){
            Object a = items[i];
            i++;
           return (Item) a;
        }




    }




}

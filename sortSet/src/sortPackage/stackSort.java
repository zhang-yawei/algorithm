package sortPackage;

/**
 * Created by zhangdawei on 2017/5/28.
 */
public class stackSort extends sortBaseClass {

    @Override
    public void sort(sortEntity[] comparaList){


    }


    /*下沉*/
    private void sink(sortEntity[] a,int start,int hight){
        int N = a.length;
        while (2*start<N){
            int j = 2*start;
            if (j<N &&less(a[j],a[j+1])) j++;
            if (!less(a[start],a[j])) break;
            exch(a,start,j);
            start = j;
        }
    }



    /*上浮*/
    private void swim(sortEntity[] a,int start,int low){

            while (start>1 && less(a[start/2],a[start])){
                exch(a,start,start/2);
                start = start/2;
            }

    }

}

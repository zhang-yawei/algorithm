package sortPackage;

/**
 * Created by zhang on 2017/4/13.
 */
public class chooseSort extends sortBaseClass {

    public chooseSort(){};

    @Override
    public void sort(sortEntity[] comparaList) {

        for (int i = 0; i < comparaList.length; i++) {
            /*找出第i个之后,最小的一个,和第i个交换*/
            int minIndex = min(comparaList,i);
            exch(comparaList,minIndex,i);
        }

    }


//    从第fromIndex,找出数组中的最小值
    private int min(sortEntity[] a,int fromIndex){
        for (int i = fromIndex; i < a.length; i++) {
            if (!less( a[fromIndex],a[i])){
                fromIndex=i;
            }
        }
        return fromIndex;
    }


}

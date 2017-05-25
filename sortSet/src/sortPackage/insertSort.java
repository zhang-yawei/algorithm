package sortPackage;

/**
 * Created by zhang on 2017/4/13.
 */
public class insertSort extends sortBaseClass {


    @Override
    public void sort(sortEntity[] comparaList) {
        for (int i = 0; i < comparaList.length; i++) {

            /*当第个元素小于第j-1 个元素时,交换它们的次序,直到第i个元素,放到比它小的元素后面*/
            for (int j = i; j>0 && less(comparaList[j],comparaList[j-1]); j--) {
                exch(comparaList,j,j-1);
            }
        }

    }

}

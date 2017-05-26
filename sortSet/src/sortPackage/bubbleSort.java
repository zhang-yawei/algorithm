package sortPackage;

/**
 * Created by zhang on 2017/5/26.
 */
public class bubbleSort extends sortBaseClass{

    @Override
    public void sort(sortEntity[] comparaList) {
        int N = comparaList.length;

        for (int i=0;i<N-1;i++){
            for (int j= N-1;j>i;j--){
                if (less(comparaList[j],comparaList[j-1])) exch(comparaList,j,j-1);
            }
        }

    }
}

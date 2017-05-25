package sortPackage;

/**
 * Created by zhang on 2017/5/24.
 * 希尔排序
 */
public class shellSort extends sortBaseClass{
    @Override
    public void sort(sortEntity[] comparaList) {
        int N = comparaList.length;
        int h = 0;
        while (h<N) h = h*3 +1;
        while (h>=1) {

            for (int j = h; j < N; j++) {
                for (int t=j;t>=h&&less(comparaList[t],comparaList[t-h]);t=t-h)
                { exch(comparaList,t,t-h);  }
            }
            h=h/3;

        }
    }

}

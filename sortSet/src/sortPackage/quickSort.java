package sortPackage;

/**
 * Created by zhang on 2017/5/26.
 * 快速排序
 */
public class quickSort extends sortBaseClass{

    @Override
    public void sort(sortEntity[] comparaList){
        sort(comparaList,0,comparaList.length-1);
    }

    private void sort(sortEntity[] a,int low,int hight){

        if (hight<=low) return;
        int mid = portition(a,low,hight);
         sort(a,low,mid-1);
         sort(a,mid+1,hight);

    }

    public int portition(sortEntity[] a,int low,int hight) {

        int i = low, j = hight + 1;
        sortEntity v = a[low];

        while (true) {
            while (less(a[++i], v)) if (i == hight) break;
            while (less(v, a[--j])) if (j == low) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, low, j);

        return j;
    }
}

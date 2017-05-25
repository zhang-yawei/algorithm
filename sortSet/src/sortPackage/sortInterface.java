package sortPackage;

/**
 * Created by zhang on 2017/4/13.
 */
public interface sortInterface {
    public void sort(sortEntity[] comparaList);
    public boolean less(sortEntity a,sortEntity b);
    public void  exch (sortEntity[] comparaList,int i,int j);
    public void show(sortEntity[] a);
    public boolean isSorted(sortEntity[] a);
}

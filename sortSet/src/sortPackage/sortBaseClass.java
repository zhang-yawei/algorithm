package sortPackage;

/**
 * Created by zhang on 2017/4/13.
 */
public class sortBaseClass implements sortInterface {


    public void sort(sortEntity[] comparaList){

    }
    
    public boolean less(sortEntity a,sortEntity b){
        return a.compareTo(b) <= 0;
    }

    
    public void  exch (sortEntity[] comparaList,int i,int j){
        sortEntity temp = comparaList[i];
        comparaList[i]=comparaList[j];
        comparaList[j] = temp;

    }
    
    public void show(sortEntity[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.println("第" + i +"个元素是:" + a[i].count);
        }

    }


    public boolean isSorted(sortEntity[] a){
        for (int i = 0; i < a.length-1; i++) {
            if (!less(a[i],a[i+1])) {
                System.out.println(".......排序失败.......");
                return false;
            }
        }
        System.out.println("!!!!!!!排序成功!!!!!!!");
        return true;
    }



}

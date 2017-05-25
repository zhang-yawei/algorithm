package sortPackage;

/**
 * Created by zhang on 2017/5/24.
 * 归并排序 自顶向下
 */
public class mergeSort extends sortBaseClass {

    private static sortEntity[] temp;

    @Override
    public void sort(sortEntity[] comparaList) {


        temp = new sortEntity[comparaList.length];

        sort(comparaList,0,comparaList.length-1);
    }


    //指定range 排序
    private void sort(sortEntity[] a,int start,int end) {

        if (start >= end) return;

        int mid = (end-start)/2 +start;

        sort(a,start,mid);
        sort(a,mid+1,end);
        merge(a,start,mid,end);

    }

    // 对于一个左右两半部,各自有序的数组,排序
    // mid 包括在前半部
    private void merge(sortEntity[] a, int low,int mid,int hight){

        System.out.println("************************************");
        System.out.println("--low="+ low + "--mid=" + mid +"--hight=" + hight);
        System.out.println("将要对a排序");
        show(a);

        for (int i=low;i<=hight;i++){
            temp[i] = a[i];
        }

        int moveMid = mid+1;
        int moveLow = low;

        for (int j = low;j<=hight;j++){
            if (moveLow>mid) a[j] = temp[moveMid++];
            else if (moveMid>hight) a[j] = temp[moveLow++];
            else if (less(temp[moveLow],temp[moveMid])) a[j] = temp[moveLow++];
            else a[j] = temp[moveMid++];
        }

    }
}

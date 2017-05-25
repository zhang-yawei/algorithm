package sortPackage;

/**
 * Created by zhangdawei on 2017/5/25.
 * 归并排序,自底向上
 */
public class mergeBU extends sortBaseClass {

    private  static sortEntity[] temp;

        @Override
        public void sort(sortEntity[] comparaList) {
            int N = comparaList.length;
            temp = new sortEntity[N];

            for (int size = 1;size<N;size=2*size){
                for (int low=0;low+size<=N;low+=2*size){
                    merge(comparaList,low,low+size-1,Math.min(low+2*size-1,N-1));
                }
            }

        }

    // 对于一个左右两半部,各自有序的数组,排序
    // mid 包括在前半部
    private void merge(sortEntity[] a, int low,int mid,int hight){

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

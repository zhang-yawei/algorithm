package sortPackage;



/**
 * Created by zhang on 2017/4/13.
 */
public class sortEntity implements Comparable<sortEntity> {


    public int count;
    /*构造函数*/
    public sortEntity(int a){
        this.count = a;
    }

/*实现comparable接口*/
    @Override
    public int compareTo(sortEntity o) {
        if (this.count > o.count) return 1;
        else if (this.count == o.count) return 0;
        else if (this.count < o.count) return -1;
        return 0;
    }

}

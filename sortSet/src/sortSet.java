import sortPackage.*;
import java.util.Random;


/**
 * Created by zhang on 2017/4/13.
 */
public class sortSet {
    public static void main(String[] args){

        sortSet sortTest = new sortSet();

       // sortTest.testChooseSort();
       // sortTest.testInsertSort();
       // sortTest.testShellSort();
        // sortTest.testMergeSort();
         sortTest.testMergeBU();

        //sortTest.testQuickSort();
      //  sortTest.testBubbleSort();


    }




    /**
     * 测试选择排序法
     */
    private void testChooseSort(){
        sortEntity[] source = getList();
        chooseSort choose = new chooseSort();
        choose.show(source);
        choose.sort(source);

        System.out.println("----------选择排序后-------------");
        choose.show(source);
    }
    /**
     * 测试插入排序
     * */
    private void testInsertSort(){
        sortEntity[] source = getList();
        insertSort insert = new insertSort();
        insert.show(source);
        insert.sort(source);

        System.out.println("----------插入排序后-------------");
        insert.show(source);
    }

    /**
     * 测试希尔排序
     * */
    private void testShellSort(){
        sortEntity[] source = getList();
        shellSort shell = new shellSort();
        shell.show(source);
        shell.sort(source);

        System.out.println("----------希尔排序后-------------");
        shell.show(source);
    }

    /**
     * 测试归并排序
     * */
    private void testMergeSort(){
        sortEntity[] source = getList();
        mergeSort merge = new mergeSort();
        merge.show(source);
        merge.sort(source);

        System.out.println("----------归并排序后-------------");
        merge.show(source);
    }


    /**
     * 测试自底向上的归并排序
     * */
    private void testMergeBU(){
        sortEntity[] source = getList();
        mergeBU merge_bu = new mergeBU();
        merge_bu.show(source);
        merge_bu.sort(source);

        System.out.println("---------自底向上的归并排序后-------------");
        merge_bu.show(source);
        merge_bu.isSorted(source);
    }


    /**
     * 测试快速排序
     * */
    private void testQuickSort(){
        sortEntity[] source = getList();
        quickSort quick = new quickSort();
        quick.show(source);
       // quick.portition(source,0,source.length-1);
        quick.sort(source);

        System.out.println("----------快递排序后-------------");
        quick.show(source);
        quick.isSorted(source);
    }


    /**
     * 测试冒泡排序
     * */
    private void testBubbleSort(){
        sortEntity[] source = getList();
        bubbleSort bubble = new bubbleSort();
        bubble.show(source);
        bubble.sort(source);

        System.out.println("----------快递排序后-------------");
        bubble.show(source);
        bubble.isSorted(source);
    }











    private sortEntity[] getList(){
        sortEntity[]  a = new sortEntity[100];

        for (int i= 0; i <100; i++) {
            int random = new  Random().nextInt(500);
            sortEntity entry = new sortEntity(random);
            a[i] = entry;

        }
        return a;
    }


}

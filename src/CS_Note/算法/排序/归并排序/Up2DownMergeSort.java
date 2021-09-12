package CS_Note.算法.排序.归并排序;

import CS_Note.算法.排序.TimeWatch;
import CS_Note.算法.排序.Utils;

/**
 * 归并排序  自顶向下归并排序
 *
 * 时间：248
 * @param <T>
 */
public class Up2DownMergeSort<T extends Comparable<T>> extends MergeSort<T>{
    @Override
    public void sort(T[] nums) {
        aux = (T[]) new Comparable[nums.length];
        sort(nums, 0, nums.length - 1);

    }

    /**
     * 这里是方法重载，实现算法
     * @param nums
     * @param l
     * @param h
     */
    public void sort(T[] nums,int l, int h){
        if(l>=h){
            return;
        }
        int mid = l + (h-l)/2;
        sort(nums,l,mid);
        sort(nums,mid+1,h);
        merge(nums,l,mid,h);
    }

    public static void main(String[] args) {
        Up2DownMergeSort<Integer> test = new Up2DownMergeSort<Integer>();
        Integer[] arrs = new Integer[10000];
        for (int i = 0;i<arrs.length;i++){
            arrs[i] = i%100+1;
        }
        TimeWatch.start();
        test.sort(arrs);
        TimeWatch.getTime();
        //test.aux = new Integer[arrs.length];
        //test.merge(arrs,0,4,arrs.length-1);
        Utils.printArrs(arrs);
    }
}

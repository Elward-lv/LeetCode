package CS_Note.算法.排序.快速排序;

import CS_Note.算法.排序.TimeWatch;
import CS_Note.算法.排序.Utils;

/**
 * 对于含有大量重复元素的数组排序可以使用三向切分的方法，是快速排序的一种变种
 */
public class ThreeWayQuickSort <T extends Comparable<T>> extends QuickSort<T> {
    @Override
    protected void sort(T[] nums, int l, int h) {
        if(h <= l){
            return;//结束条件
        }
        int lt = l,i = l + 1,gt = h;
        T t = nums[l];
        while (i <= gt){
            int res = nums[i].compareTo(t);
            if(res < 0){
                swap(nums,i++,lt++);
            }else if(res > 0){
                swap(nums,i,gt--);//这里可能换了之后的元素还需要比较，所以是i
            }else {
                i++;
            }
        }
        sort(nums, l, lt - 1);
        sort(nums, gt + 1, h);
    }

    public static void main(String[] args) {
        Integer[] arrs = new Integer[10000];
        for (int i = 0;i<arrs.length;i++){
            arrs[i] = i%100+1;
        }
        ThreeWayQuickSort quickSort = new ThreeWayQuickSort();
        TimeWatch.start();
        quickSort.sort(arrs);
        TimeWatch.getTime();
        Utils.printArrs(arrs);
    }
}

package CS_Note.算法.排序.快速排序;

import CS_Note.算法.排序.Sort;
import CS_Note.算法.排序.TimeWatch;
import CS_Note.算法.排序.Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    public static void main(String[] args) {
        Integer[] arrs = new Integer[10000];
        for (int i = 0;i<arrs.length;i++){
            arrs[i] = i%100+1;
        }
        QuickSort quickSort = new QuickSort();
        TimeWatch.start();
        quickSort.sort(arrs);
        TimeWatch.getTime();
        Utils.printArrs(arrs);
    }
    //切分,
    //简要思想：主要通过从两侧分别寻找，左侧找到第一个大于t的元素
    //右侧找到第一个小于t的元素，只要i>=j就说明此时就一个元素，那么就可以把t换到此位置
    //如果i<j说明可能不止一个元素需要交换，这时候就交换i和j的nums元素，即可把<t的转移到左边，>t的转移到右边
    private int partition(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        while (true) {
            while (less(nums[++i], v) && i != h) ;
            while (less(v, nums[--j]) && j != l) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    @Override
    public void sort(T[] nums) {
            shuffle(nums);
            sort(nums, 0, nums.length - 1);
    }

    protected void sort(T[] nums, int l, int h) {
        if (h <= l)
            return;
        int j = partition(nums, l, h);
        sort(nums, l, j - 1);
        sort(nums, j + 1, h);
    }

    private void shuffle(T[] nums) {
        List<Comparable> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }
}



package CS_Note.算法.排序.快速排序.复习2;

import CS_Note.算法.排序.Sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    /**
     * 快速排序
     * 先 打乱顺序 -> 切分 ->在对切分过的数组进行快排
     * @param nums
     */
    @Override
    public void sort(T[] nums) {
        shuffle(nums);
        sort(nums, 0 , nums.length);
    }

    private void shuffle(T[] nums) {
        List<T> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    private void sort(T[] nums, int low, int high) {
        if(low >= high) return;
        //用0号元素作为切割的中间元素
        int j = cut(nums, low , high);
        sort(nums, low , j);
        sort(nums , j+1 , high);

    }

    //切分--简单来说就是通过第一个元素作为分界点，把数组划分为两个数组
    private int cut(T[] nums, int l, int h) {
        int i = l, j = h + 1;
        T v = nums[l];
        while (true) {
            while (less(nums[++i], v) && i != h) ;
            while (less(v, nums[--j]) && j != l) ;
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums , l , h);
        return j;
    }

    public static void main(String[] args) {

    }
}

package CS_Note.算法.排序.选择排序;

import CS_Note.算法.排序.Sort;
import CS_Note.算法.排序.TimeWatch;

/**
 * 选择排序实现 时间:125
 *  从数组中选择最小元素，将它与数组的第一个元素交换位置
 *
 *  总是循环 n + n-1 + n-2 + n-3....0 //等差数列
 *  n(n+1)/2
 */
public class Selection extends Sort {
    @Override
    public void sort(Comparable[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int max = i;
            for (int j = i + 1; j < nums.length; j++) {
                if(less(nums[max],nums[j])){
                    max = j;
                }
            }
            if(max != i) swap(nums, max , i);
        }
    }

    public static void main(String[] args) {
        Integer[] arrs = new Integer[10000];
        for (int i = 0;i<arrs.length;i++){
            arrs[i] = i%100+1;
        }
        TimeWatch.start();
        Selection selection = new Selection();
        selection.sort(arrs);
        TimeWatch.getTime();
        for (Integer j : arrs) {
            System.out.print(j+",");
        }
    }
}

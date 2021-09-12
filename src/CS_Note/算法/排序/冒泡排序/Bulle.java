package CS_Note.算法.排序.冒泡排序;

import CS_Note.算法.排序.Sort;
import CS_Note.算法.排序.TimeWatch;

/**
 * 冒泡排序  时间：460
 * 从左到右不断交换相邻逆序的元素，在一轮的循环之后，可以让未排序的最大元素上浮到右侧。
 * @param <T>
 */
public class Bulle<T extends Comparable<T>> extends Sort<T> {
    public static void main(String[] args) {

        Integer[] arrs = new Integer[100];
        for (int i = 0;i<arrs.length;i++){
            arrs[i] = i%10+1;
        }
        TimeWatch.start();
        Bulle bulle =new Bulle();
        bulle.sort(arrs);
        TimeWatch.getTime();
        for (Integer j : arrs) {
            System.out.print(j+",");
        }
    }

    @Override
    public void sort(T[] nums) {
        //第二次
        //错误示例:思路
        //开始应该是最大的浮动到最右边，所以外层循环从最右侧开始
        //其次内存循环应该是从0到外层i即可，应为外层循环代表着正在寻找此次循环最大数字。此i到数组长度之中都是已经找到最值的
        /*for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1 ; j < nums.length; j++) {
                if(less(nums[j], nums[j-1])) swap(nums, j ,  j-1);
            }
        }*/
        boolean isSort = false;
        for (int i = nums.length - 1; i > 0 && !isSort; i--) {
            isSort = true;
            for (int j = 1; j < i; j++) {
                if(less(nums[j ], nums[j - 1])) {swap(nums, j , j-1);isSort =false;}
            }
        }
        /*
        //1
        int length = nums.length;
        boolean isSorted = false;
        for (int i = length - 1 ; i > 0 && !isSorted; i--) {
            isSorted = true;
            for (int j = 0; j < i; j++) {
                if(less(nums[j],nums[j+1])){
                    isSorted = false;
                    swap(nums,j,j+1);
                }
            }
        }*/
    }
}

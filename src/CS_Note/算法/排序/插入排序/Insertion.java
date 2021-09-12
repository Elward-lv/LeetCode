package CS_Note.算法.排序.插入排序;

import CS_Note.算法.排序.Sort;
import CS_Note.算法.排序.TimeWatch;

/**
 * 插入排序  时间：326
 * 每次都将当前元素插入到左侧已经排序的数组中
 * @param <T>
 */
public class Insertion<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {

        //2.假设左侧的数组已经有序，依次从数组右侧访问，开始数组长度为1(从0开始不到1为有序数组)，慢慢扩大。
        for (int i = 1; i < nums.length; i++) {
            for (int j = i ; j > 0 && less(nums[j ], nums[j - 1]); j--) {//最大的左移
                swap(nums, j , j-1);
            }
        }
        /*//1.
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for(int j = i; j> 0 && less(nums[j],nums[j-1]);j--){
                swap(nums,j,j-1);
            }
        }*/
    }

    public static void main(String[] args) {
        Integer[] arrs = new Integer[10000];
        for (int i = 0;i<arrs.length;i++){
            arrs[i] = i%100+1;
        }
        TimeWatch.start();
        Insertion insertion = new Insertion();
        insertion.sort(arrs);
        TimeWatch.getTime();
        for (Integer j : arrs) {
            System.out.print(j+",");
        }
    }
}

package CS_Note.算法.排序.希尔排序;

import CS_Note.算法.排序.Sort;
import CS_Note.算法.排序.TimeWatch;

/**
 * 希尔排序,建立在插入排序的基础上，这增加h 时间：16
 * @param <T>
 */
public class Shell<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        //1.
        /*int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }*/
        //2.
        //determine the h which is the distance of each small array
        int length = nums.length ,  h = 0;
        while ( h < length / 3 ){
            h = h * 3 + 1;
        }
        //sort
        while ( h > 1 ){
            //insert sort
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less( nums[j] , nums[j - h] ); j -= h ) {
                    swap(nums, j , j - h );
                }
            }
            //decrease  h
            h /= 3;
        }
    }

    public static void main(String[] args) {
        Integer[] arrs = new Integer[10000];
        for (int i = 0;i<arrs.length;i++){
            arrs[i] = i%100+1;
        }
        TimeWatch.start();
        Shell shell = new Shell();
        shell.sort(arrs);
        TimeWatch.getTime();
        for (Integer j : arrs) {
            System.out.print(j+",");
        }
    }
}

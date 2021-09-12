package book.algorithm_book.day2_selection_sort;

import java.util.ArrayList;

/**
 * 选择排序算法---O(n^2)
 *
 */
public class selection_sort {
    public static void main(String[] args) {
        int[] arrs = {2,5,4,90,46,35,72,18,50,13};
        ArrayList<Integer> arrayList = select_sort(arrs);
        System.out.println(arrayList);
    }

    public static ArrayList<Integer> select_sort(int[] arrs){
        /**
         * 每次找出最大值，然后剔除此值继续找最值
         */
        ArrayList<Integer> arrayList = new ArrayList<>();
        int[] arrs2 = arrs;
        for (int i = 0; i < arrs2.length; i++) {
            int max = findMax(arrs2);
            arrayList.add(arrs2[max]);
            arrs2[max] = -1;
        }
        return arrayList;
    }

    /**
     * 返回最大值的位置
     * @param arrs
     * @return
     */
    public static int findMax(int[] arrs){
        int max = 0;
        for (int i = 0; i < arrs.length; i++) {
            if(arrs[i] > arrs[max]){
                max = i;
            }
        }
        return max;
    }
}

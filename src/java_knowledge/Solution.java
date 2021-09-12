package java_knowledge;

import java.util.*;


public class Solution {
    public static void main(String[] args) {
        //10,10,[1,2,4,4,5,5,9,10,10,11]
        Solution s = new Solution();
        int i = s.upper_bound_(10, 10, new int[]{1,2,4,4,5,5,9,10,10,11});
        System.out.println(i);
    }

    /**
     * 二分查找
     *
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public int upper_bound_(int n, int v, int[] a) {
        // write code here
        if (v < a[0]) {
            return 1;
        } else if (v > a[a.length - 1]) {
            return a.length + 1;
        }

        int res = binarySearch(v, a);
        if (a[res - 1] == v) {
            for (int j = res; j >= 0; j--) {
                if (a[j] < v) {
                    return j + 2;
                }
            }
        }
        int i = 0;
        for (i = res + 1; i < a.length; i++) {
            if (a[i] >= v) {
                return i;
            }
        }
        return i + 1;
    }

    public int binarySearch(int v, int[] a) {
        //返回第一个和v相同的值位置
        int low = 0;
        int high = a.length - 1;
        int middle = 0;
        while (low <= high) {
            middle = (low + high) / 2;
            if (a[middle] < v) {
                low = middle + 1;
            } else if (a[middle] == v) {
                return middle;
            } else {
                high = middle - 1;
            }
        }
        return middle;
    }
}

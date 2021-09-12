package book.algorithm_book.day4_quick_sort;

import java.util.ArrayList;

/**
 * 快速排序算法
 * 需求：我需要对一个int数组进行排序，并且使用快速排序算法
 * 原理：
 *      1.建立基准线n
 *      2.数组划分为左右两个数组，分别是小于和大于基准的数组
 *      3.对左右两个数组重新调用快速排序
 *      4.组装左+基准+右即为结果
 * 问题：使用什么数据结构？
 *      数组？可以相加/可以合并吗？不行，因为数组初始化必须确定大小
 *      Arraylist 应该可以,实现！
 */
public class quick_sort {
    public static void main(String[] args) {
        int[] arrs = {10,3,50,1,68,18,26,34};
        ArrayList<Integer> list = new ArrayList<>();
        //数组初始化ArrayList
        for (int arr : arrs) {
            list.add(arr);
        }
        System.out.println(list);

        long l = System.currentTimeMillis();
        ArrayList<Integer> res = quicksort(list);
        long l1 = System.currentTimeMillis();
        System.out.println(res);
        System.out.println("time:"+(l1 - l));
    }

    private static ArrayList<Integer> quicksort(ArrayList<Integer> list) {
        //递归结束条件
        if(list.size() < 2){
            return list;
        }

        int basic = list.get(0);
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        //分类
        for (int i = 1; i < list.size(); i++) {
            if( list.get(i) < basic){
                left.add(list.get(i));
            }else {
                right.add(list.get(i));
            }
        }
        return convert(quicksort(left) , basic , quicksort(right));
    }

    /**
     * 合并数组
     * @param left
     * @param basci
     * @param right
     * @return
     */
    public static ArrayList<Integer> convert(ArrayList<Integer> left , int basci , ArrayList<Integer> right){
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer integer : right) {
            res.add(integer);
        }
        res.add(basci);
        for (Integer integer : left) {
            res.add(integer);
        }
        return res;
    }

}

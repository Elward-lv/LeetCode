package CS_Note.算法.排序.归并排序;

import CS_Note.算法.排序.Sort;

/**
 *
 * @param <T>
 */
public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {
    protected T[] aux;

    /**
     * 通过对索引的复用来实现表面上一个数组实际上两个数组
     * 此方法用来合并数组---没问题
     * @param nums
     * @param l
     * @param m
     * @param h
     */
    protected void merge(T[] nums,int l ,int m , int h){
        //复制数组
        for (int k = l;k<= h;k++){
            aux[k] = nums[k];
        }

        int i = l, j = m+1;
        for (int k = l ;k<= h;k++){
            if(i > m){
                nums[k] = aux[j++];
            }else if(j > h){
                nums[k] = aux[i++];
            }else if(aux[j].compareTo(aux[i]) <= 0){
                nums[k] = aux[j++];
            }else {
                nums[k] = aux[i++];
            }
        }
    }
}

package CS_Note.算法.排序.归并排序.复习2;

import CS_Note.算法.排序.Sort;

public abstract class MegretSort<T extends Comparable<T>> extends Sort<T> {
    protected T[] auxs;

    //合并两个数组,首先把数据复制到auxs，其次进行合并，依次比较low->mid和mid+1->high的大小
    public void MegreArr(T[] nums , int low , int mid , int high){
        for (int i = 0; i < nums.length; i++) {
            auxs[i] = nums[i];
        }

        int i = low, j = mid + 1 , k = low;
        for (int m = low; m <= high; m++) {
            if(i > mid){
                nums[k++] = auxs[j++];
            }else if( j > high){
                nums[k++] = auxs[i++];
            }
            else if(less(auxs[i] , auxs[j])){
                nums[k++] = auxs[i++];//从小到大
            }else {
                nums[k++] = auxs[j++];
            }
        }
    }
}

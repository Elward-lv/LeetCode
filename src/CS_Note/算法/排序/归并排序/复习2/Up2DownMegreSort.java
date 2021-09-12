package CS_Note.算法.排序.归并排序.复习2;

import CS_Note.算法.排序.TimeWatch;
import CS_Note.算法.排序.Utils;

public class Up2DownMegreSort<T extends Comparable<T>> extends MegretSort<T> {
    @Override
    public void sort(T[] nums) {
        auxs = (T[]) new Comparable[nums.length];
        sort(nums , 0 ,  nums.length - 1);
    }

    private void sort(T[] nums, int l,  int h) {
        if(l >= h){
            return;
        }
        int mid = l + (h-l)/2;
        sort(nums, l , mid);
        sort(nums, mid+1 , h);
        MegreArr(nums , l , mid , h);
    }

    public static void main(String[] args) {
        Up2DownMegreSort<Integer> test = new Up2DownMegreSort<Integer>();
        Integer[] arrs = new Integer[10000];
        for (int i = 0;i<arrs.length;i++){
            arrs[i] = i%100+1;
        }
        TimeWatch.start();
        test.sort(arrs);
        TimeWatch.getTime();
        //test.aux = new Integer[arrs.length];
        //test.merge(arrs,0,4,arrs.length-1);
        Utils.printArrs(arrs);
    }
}

package CS_Note.算法.排序.归并排序;

import CS_Note.算法.排序.Sort;
import CS_Note.算法.排序.TimeWatch;
import CS_Note.算法.排序.Utils;

/**
 * 归并排序  自底向上归并排序
 * 先归并那些微型数组，然后成对归并得到的微型数组。
 * 时间: 16
 * @param <T>
 */
public class Down2UpMergeSort<T extends Comparable<T>> extends MergeSort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        aux = (T[]) new Comparable[N];

        /*for (int sz = 1; sz < N; sz += sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(nums, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
            }
        }*/

        //自己覆写
        //最小数组长度从1开始到N，每次len长度需要合并很多小数组
        int len,start;
        for (len = 1; len < N; len += len){
            for ( start = 0; start < N -len; start += 2 * len ){
                //比如长度为len = 1时，
                //此时start从0开始，start+len-1 = 0，start+2*len-1=1  可以看出刚好为数组的中间和结尾
                //start下次为start+2*len 即2 ，start+len-1=2 ， start+2*len-1=3  也是第二个数组的中间和结尾
                //如此循环
                merge(nums,start,start+len-1,Math.min(start+2*len-1,N-1));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arrs = new Integer[10000];
        for (int i = 0;i<arrs.length;i++){
            arrs[i] = i%100+1;
        }
        Down2UpMergeSort test = new Down2UpMergeSort();
        TimeWatch.start();
        test.sort(arrs);
        TimeWatch.getTime();
        Utils.printArrs(arrs);
    }
}

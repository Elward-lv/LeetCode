package leetcode.editor.cn;
//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 770 👎 0


import java.util.Arrays;

public class MergeSortedArray{
        public static void main(String[] args){
            Solution solution = new MergeSortedArray()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路：
             * 1.利用双指针得特性，完成排序。复制另外一个nums1
             *          执行耗时:0 ms,击败了100.00% 的Java用户
             * 			内存消耗:38.6 MB,击败了41.55% 的Java用户
             * 	2.CSNOTE:
             * 	        需要从尾开始遍历，否则在 nums1 上归并得到的值会覆盖还未进行归并比较的值。
             * @param nums1
             * @param m
             * @param nums2
             * @param n
             */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //1.
        /*int i = 0, j = 0 , k = 0;
        int[] nums1_copy = Arrays.copyOfRange(nums1, 0 , m  );
        while ( k < m + n ){
            if(i >= m){
                nums1[k++] = nums2[j++];
            }else if( j >= n ){
                nums1[k++] = nums1_copy[i++];
            }else if( nums1_copy[i] > nums2[j] ){
                nums1[k++] = nums2[j++];
            }else{
                nums1[k++] = nums1_copy[i++];
            }
        }*/
        //2.
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
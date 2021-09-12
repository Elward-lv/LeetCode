package leetcode.editor.cn;
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 
// 👍 664 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence()
                .new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1.简单的我可以对数组进行排序。其次从排序结果之中找到最长的连续序列. 时间复杂度：O(n^2 / nlog^n)
         * 2.可以简单使用数组记录数字的值，和数组的索引对应。第一遍扫描记录值，第二次找最长连续序列.
         *              缺陷：中间有部分数字是连续的，可以直接保存入map，但是我用的是set，导致时间花费仍然很高
         *      执行耗时:2090 ms,击败了5.06% 的Java用户
         * 			内存消耗:42 MB,击败了5.04% 的Java用户
         * 3.CS NOTE 也是通过计数数字的个数.
         *          执行耗时:8 ms,击败了30.98% 的Java用户
         * 			内存消耗:39.5 MB,击败了16.58% 的Java用户
         * @param nums
         * @return
         */
        public int longestConsecutive(int[] nums) {
            //2.
            /*if (nums == null) return 0;

            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            int max = 0;
            for (int num : nums) {
                int m = searchForPre(num, set);
                System.out.println(m);
                max = Math.max(max , m);
            }
            return max;*/
            //3.
            Map<Integer, Integer> countForNum = new HashMap<>();
            for (int num : nums) {
                countForNum.put(num, 1);
            }
            for (int num : nums) {
                forward(countForNum, num);
            }
            return maxCount(countForNum);
        }

        private int forward(Map<Integer, Integer> countForNum, int num) {
            if (!countForNum.containsKey(num)) {
                return 0;
            }
            int cnt = countForNum.get(num);
            if (cnt > 1) {
                return cnt;
            }
            cnt = forward(countForNum, num + 1) + 1;
            countForNum.put(num, cnt);
            return cnt;
        }

        private int maxCount(Map<Integer, Integer> countForNum) {
            int max = 0;
            for (int num : countForNum.keySet()) {
                max = Math.max(max, countForNum.get(num));
            }
            return max;
        }

        private int searchForPre(int num , HashSet<Integer> set) {
            if(!set.contains(num)){
                return 0;
            }else if(!set.contains(num - 1)){
                return 1;
            }else {
                return 1 + searchForPre(num - 1 , set);
            }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

}
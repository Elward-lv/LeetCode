package leetcode.editor.cn;
//和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。 
//
// 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。 
//
// 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,2,2,5,2,3,7]
//输出：5
//解释：最长的和谐子序列是 [3,2,2,2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 哈希表 
// 👍 148 👎 0


import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence{
        public static void main(String[] args){
            Solution solution = new LongestHarmoniousSubsequence()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路
             * 1.找到每个元素的个数。依次从个数最多的元素开始向两侧拓展，找到和谐子序列；注意可以不连续
             * 2.找到每个元素的个数，其次计算两个连续的数字的次数之和
             *      代码参考CS NOTE 如下
             *      执行耗时:19 ms,击败了84.15% 的Java用户
             * 			内存消耗:39.3 MB,击败了80.67% 的Java用户
             * @param nums
             * @return
             */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        for (int num : countForNum.keySet()) {
            if (countForNum.containsKey(num + 1)) {
                longest = Math.max(longest, countForNum.get(num + 1) + countForNum.get(num));
            }
        }
        return longest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
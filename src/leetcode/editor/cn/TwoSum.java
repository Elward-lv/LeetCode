package leetcode.editor.cn;
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10240 👎 0


import java.util.HashMap;

public class TwoSum{
        public static void main(String[] args){
            Solution solution = new TwoSum()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路
             * 1.一次遍历。可以用哈希表保存此元素和target的差值 以及 此元素的索引
             *      只要下次循环时，map包含此元素直接返回，否则把它和target的差值 以及 它的索引 放入map之中
             *          执行耗时:0 ms,击败了100.00% 的Java用户
             * 			内存消耗:38.9 MB,击败了17.64% 的Java用户
             * @param nums
             * @param target
             * @return
             */
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        HashMap<Integer, Integer> value = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(value.containsKey(nums[i])){
                ret[0] = value.get(nums[i]);
                ret[1] = i;
                return ret;
            }else if(value.isEmpty() || !value.containsKey(target - nums[i])){
                value.put(target - nums[i], i);
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
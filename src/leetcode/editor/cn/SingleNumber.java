package leetcode.editor.cn;
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1675 👎 0


public class SingleNumber{
        public static void main(String[] args){
            Solution solution = new SingleNumber()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路
             * 1.利用相同数字异或为0的特性计算，所有数字或之后一定为单一的数字！
             *          执行耗时:1 ms,击败了99.99% 的Java用户
             * 			内存消耗:38.8 MB,击败了33.88% 的Java用户
             *
             * @param nums
             * @return
             */
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
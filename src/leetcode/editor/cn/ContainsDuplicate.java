package leetcode.editor.cn;
//给定一个整数数组，判断是否存在重复元素。 
//
// 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,1]
//输出: true 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: false 
//
// 示例 3: 
//
// 
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true 
// Related Topics 数组 哈希表 
// 👍 360 👎 0


import java.util.HashSet;

public class ContainsDuplicate{
        public static void main(String[] args){
            Solution solution = new ContainsDuplicate()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路
             * 1.使用hashset计数。m每次遍历都检查是否存在重复的键。这样多余的时间花费在检查重复上！
             *      执行耗时:9 ms,击败了26.32% 的Java用户
             * 			内存消耗:44.6 MB,击败了23.82% 的Java用户
             * 	2.hashset计数。遍历一次把所有的键都添加入set，最后比较set的大小和数组的大小
             * 	        执行耗时:6 ms,击败了61.77% 的Java用户
             * 			内存消耗:45.6 MB,击败了10.50% 的Java用户
             * @param nums
             * @return
             */
    public boolean containsDuplicate(int[] nums) {
        //1.
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if(!set.contains(num)){
                set.add(num);
            }else {
                return false;
            }
        }
        return true;
        //2.
        /*HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
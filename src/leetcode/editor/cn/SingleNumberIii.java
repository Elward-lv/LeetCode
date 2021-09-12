package leetcode.editor.cn;
//给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。 
//
// 示例 : 
//
// 输入: [1,2,1,3,2,5]
//输出: [3,5] 
//
// 注意： 
//
// 
// 结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。 
// 你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？ 
// 
// Related Topics 位运算 
// 👍 347 👎 0


import java.util.HashSet;
import java.util.Iterator;

public class SingleNumberIii{
        public static void main(String[] args){
            Solution solution = new SingleNumberIii()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路：
             * 1.简单的使用HashSet计数即可，重复则删除，不重复添加即可.
             *      时间：o(n) 内存o(n)
             * 2.位运算. 首先求出两个单一数字异或的结果；其次找出此结果之中最右侧的那一位1；利用这个1区分两个元素。
             *          区分过程：含有此1的都与res[0]异或，否则与res[1]异或，这样由于其他元素都是两个导致最后
             *          剩下的只有唯一的两个元素
             *
             *          执行耗时:1 ms,击败了99.93% 的Java用户
             * 			内存消耗:38.7 MB,击败了51.87% 的Java用户
             * @param nums
             * @return
             */
    public int[] singleNumber(int[] nums) {
        //1.
        /*int[] res = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) set.remove(nums[i]);
            else set.add(nums[i]);
        }
        int i = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            res[i] = iterator.next();
            i++;
        }
        return res;*/
        //2.
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= - diff;//得到最右侧的一位
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) res[0] ^= num;//即使有两个数字也进入此循环，由于是两个相同的数字，导致异或结果只剩那个单一的数字
            else res[1] ^= num;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
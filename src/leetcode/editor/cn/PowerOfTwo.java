package leetcode.editor.cn;
//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 274 👎 0


public class PowerOfTwo{
        public static void main(String[] args){
            Solution solution = new PowerOfTwo()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路
             * 1.2^n 有什莫特点。只有一个1,计数1的个数即可
             *      执行耗时:1 ms,击败了100.00% 的Java用户
             * 			内存消耗:35.5 MB,击败了43.40% 的Java用户
             * 2.利用 1000 & 0111 == 0 这种性质
             *
             * @param n
             * @return
             */
    public boolean isPowerOfTwo(int n) {
        //1
//        return n > 0 && Integer.bitCount(n) == 1;
        //2.
        return n > 0 && (n & (n - 1)) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;
//给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5
//输出：true
//解释：5 的二进制表示是：101
// 
//
// 示例 2： 
//
// 
//输入：n = 7
//输出：false
//解释：7 的二进制表示是：111. 
//
// 示例 3： 
//
// 
//输入：n = 11
//输出：false
//解释：11 的二进制表示是：1011. 
//
// 示例 4： 
//
// 
//输入：n = 10
//输出：true
//解释：10 的二进制表示是：1010. 
//
// 示例 5： 
//
// 
//输入：n = 3
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 位运算 
// 👍 90 👎 0


public class BinaryNumberWithAlternatingBits{
        public static void main(String[] args){
            Solution solution = new BinaryNumberWithAlternatingBits()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路
             * 1.右移一位之后和原数相异或全一.
             *      执行耗时:1 ms,击败了18.73% 的Java用户
             * 			内存消耗:35.2 MB,击败了53.00% 的Java用户
             * 2.思想类似。但是判断结果全1的方式不同。
             *      执行耗时:0 ms,击败了100.00% 的Java用户
             * 			内存消耗:35.5 MB,击败了7.41% 的Java用户
             * @param n
             * @return
             */
    public boolean hasAlternatingBits(int n) {
        //1.
        /*int t = n >> 1;
        return Integer.bitCount(t ^ n) == Integer.toBinaryString(n).length();*/
        //2.
        int a = (n ^ (n >> 1));
        return (a & (a + 1)) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;
//给定一个整数，写一个函数来判断它是否是 4 的幂次方。如果是，返回 true ；否则，返回 false 。 
//
// 整数 n 是 4 的幂次方需满足：存在整数 x 使得 n == 4x 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：n = 5
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// -231 <= n <= 231 - 1 
// 
//
// 
//
// 进阶： 
//
// 
// 你能不使用循环或者递归来完成本题吗？ 
// 
// Related Topics 位运算 
// 👍 159 👎 0


public class PowerOfFour{
    /**
     * 思路
     * 1.仿照2的运算，找出0的个数为偶数，并且1的个数为1
     *      执行耗时:2 ms,击败了10.64% 的Java用户
     * 			内存消耗:35.6 MB,击败了38.90% 的Java用户
     * 	2.这种数在二进制表示中有且只有一个奇数位为 1，例如 16（10000）。
     * 	        执行耗时:1 ms,击败了100.00% 的Java用户
     * 			内存消耗:35.4 MB,击败了78.21% 的Java用户
     * 	3.也可以使用正则表达式进行匹配。
     *          执行耗时:10 ms,击败了10.64% 的Java用户
     * 			内存消耗:38.1 MB,击败了5.17% 的Java用户
     * @param args
     */
        public static void main(String[] args){
            Solution solution = new PowerOfFour()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfFour(int n) {
        //1
        //return n == 1 | n > 0 && Integer.numberOfTrailingZeros(n) % 2 == 0 && Integer.bitCount(n) == 1;
        //2
//        return n > 0 && (n & (n - 1)) == 0 && (n & 0b01010101010101010101010101010101) != 0;
        //3.
        return Integer.toString(n, 4).matches("10*");
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
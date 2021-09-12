package leetcode.editor.cn;
//不使用运算符 + 和 - ，计算两整数 a 、b 之和。 
//
// 示例 1: 
//
// 输入: a = 1, b = 2
//输出: 3
// 
//
// 示例 2: 
//
// 输入: a = -2, b = 3
//输出: 1 
// Related Topics 位运算 
// 👍 363 👎 0


public class SumOfTwoIntegers{
        public static void main(String[] args){
            Solution solution = new SumOfTwoIntegers()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路
             * 1.使用位运算替代+。整数加法可以使用异或（求无进位加法结果）+ 进位结果(使用&可以获得此位置进位，通过左移即可进位) 即可。
             * @param a
             * @param b
             * @return
             */
    public int getSum(int a, int b) {

        return b == 0 ? a : getSum(( a ^ b ) , (a & b) << 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
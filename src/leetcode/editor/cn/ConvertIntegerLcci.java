package leetcode.editor.cn;
//整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。 
//
// 示例1: 
//
// 
// 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
// 输出：2
// 
//
// 示例2: 
//
// 
// 输入：A = 1，B = 2
// 输出：2
// 
//
// 提示: 
//
// 
// A，B范围在[-2147483648, 2147483647]之间 
// 
// Related Topics 位运算 
// 👍 20 👎 0


public class ConvertIntegerLcci{
        public static void main(String[] args){
            Solution solution = new ConvertIntegerLcci()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路
             * 1.只需要求出异或结果中1的个数即可
             *      执行耗时:0 ms,击败了100.00% 的Java用户
             * 			内存消耗:35.4 MB,击败了26.10% 的Java用户
             * 	2.也可以异或对求1的过程进行优化。使用n&(n-1)取出最高位的1
             * @param A
             * @param B
             * @return
             */
    public int convertInteger(int A, int B) {
        int t = A ^ B;
        return Integer.bitCount(t);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
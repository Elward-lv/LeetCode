package leetcode.editor.cn;
//给定一个正整数，输出它的补数。补数是对该数的二进制表示取反。 
//
// 
//
// 
// 
//
// 示例 1: 
//
// 输入: 5
//输出: 2
//解释: 5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
// 
//
// 示例 2: 
//
// 输入: 1
//输出: 0
//解释: 1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
// 
//
// 
//
// 注意: 
//
// 
// 给定的整数保证在 32 位带符号整数的范围内。 
// 你可以假定二进制数不包含前导零位。 
// 本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同 
// 
// Related Topics 位运算 
// 👍 200 👎 0


public class NumberComplement{
        public static void main(String[] args){
            Solution solution = new NumberComplement()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路：
             * 1.可以转化为字符串之后，分别取反
             * 2.位运算。00101和00111异或即可完成求反，问题转化为求00111？
             *      先定位最高位的1的位置即01000，随后-1可得00111
             *              执行耗时:0 ms,击败了100.00% 的Java用户
             * 			    内存消耗:35.5 MB,击败了11.94% 的Java用户
             * 3.可以利用 Java 的 Integer.highestOneBit() 方法来获得含有首 1 的数。
             *              执行耗时:0 ms,击败了100.00% 的Java用户
             * 			    内存消耗:35.2 MB,击败了64.44% 的Java用户
             * 	4.对于 10000000 这样的数要扩展成 11111111，可以利用以下方法：
             * 	        mask |= mask >> 1    11000000
             *          mask |= mask >> 2    11110000
             *          mask |= mask >> 4    11111111
             *              执行耗时:0 ms,击败了100.00% 的Java用户
             * 			    内存消耗:35.2 MB,击败了57.68% 的Java用户
             * @param num
             * @return
             */
    public int findComplement(int num) {
        //2.
        /*if( num == 0) return 1;
        int mask = 1 << 30;
        while ((mask & num) == 0) mask >>= 1;
        mask = (mask << 1) - 1;
        return  mask ^ num;*/
        //3.
        /*if(num == 0) return 1;
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return mask ^ num;*/
        //4.
        int mask = num;
        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;
        return (mask ^ num);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
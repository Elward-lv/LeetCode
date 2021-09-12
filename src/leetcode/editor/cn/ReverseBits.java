package leetcode.editor.cn;
//颠倒给定的 32 位无符号整数的二进制位。 
//
// 
//
// 示例 1： 
//
// 输入: 00000010100101000001111010011100
//输出: 00111001011110000010100101000000
//解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
//     因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。 
//
// 示例 2： 
//
// 输入：11111111111111111111111111111101
//输出：10111111111111111111111111111111
//解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
//     因此返回 3221225471 其二进制表示形式为 10111111111111111111111111111111 。 
//
// 
//
// 提示： 
//
// 
// 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的
//还是无符号的，其内部的二进制表示形式都是相同的。 
// 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -10737418
//25。 
// 
//
// 
//
// 进阶: 
//如果多次调用这个函数，你将如何优化你的算法？ 
// Related Topics 位运算 
// 👍 256 👎 0


import java.util.HashMap;

public class ReverseBits {
    private static HashMap<Byte , Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Solution solution = new ReverseBits()
                .new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        /**
         * 1.最先想到的。先转字符，当作字符串进行颠倒，之后从新转化为整数。
         * 2.逐位颠倒
         * 重点是测试一个人对数据类型和位操作的基本知识。
         * 尽管听起来很简单，但上述逻辑的不同实现产生不同的解决方案。
         * 例如，要检索整数 n 中最右边的位，可以应用模运算（即 n%2）或与运算（即 n &1）。另一个例子是，
         * 为了组合反转位（例如 2^a，2^b）的结果，可以使用加法运算（即 2^a+2^b）或再次使用位或运算（即 2^a | 2^b）。
         * 执行耗时:1 ms,击败了100.00% 的Java用户
         * 内存消耗:38.2 MB,击败了59.05% 的Java用户
         * 3.带记忆化的按字节颠倒
         * 每字节（8 位的比特位）反转可能更有效。由于该题的输入是固定的 32 位整数，所以在本题中不一定是这样的。但是在处理长字节流时，它会变得更有效。
         * 使用字节作为迭代单位的另一个隐含优点是，我们可以使用记忆化技术，可以缓存先前计算的值，以避免重新计算。
         * 记忆化的后续问题是：如果该函数多次被调用，你该如何优化。
         * <p>
         * 8位反转，反转之后将结果通过|合并到数字之中，再将数字左移8位即可完成迭代
         *
         * @param n
         * @return
         */
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            //2.
        /*int ret = 0;
        for (int i = 0; i < 32; i++) {
            ret <<= 1;
            ret |= (n & 1);//获取n最右侧一位 并把ret相应位置 置位
            n >>>= 1;//无符号右移
        }
        return ret;*/
            //3.
            int ret = 0;
            for (int i = 0; i < 4; i++) {
                ret <<= 8;
                ret |= reverseBytes((byte) (n & 0b11111111));
                n >>= 8;
            }
            return ret;
        }
    }

    private int reverseBytes(byte b) {
        if(cache.containsKey(b)) return cache.get(b);
        int ret = 0;
        byte t = b;
        for (int i = 0; i < 8; i++) {
            ret <<= 1;
            ret |= t & 1;
            t >>= 1;
        }
        cache.put(b, ret);
        return ret;
    }
//leetcode submit region end(Prohibit modification and deletion)

}
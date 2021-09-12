package leetcode.editor.cn;
//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划 
// 👍 494 👎 0


public class CountingBits {
    public static void main(String[] args) {
        Solution solution = new CountingBits()
                .new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路
         * 1.循环遍历num以下的数字，随后内部求每个数字的1的个数。
         *      如何求1的个数？Integer.bitCount().时间复杂度：O(n)  空间复杂度：O(n)
         * 2.位运算。n&(n-1) 去除 n 的位级表示中最低的那一位。leetcode解法1
         *      时间复杂度：O(nk) 空间复杂度：O(n)
         * 3.位运算！利用已有的计数结果来生成新的计数结果  ===  动态规划 + 最后设置位【通过】
         *   进阶：给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 要求算法的空间复杂度为O(n)。
         *      时间复杂度：O(n) 空间复杂度：O(n)
         *              执行耗时:2 ms,击败了60.41% 的Java用户
         * 			    内存消耗:42.7 MB,击败了21.27% 的Java用户
         * @param num
         * @return
         */
        public int[] countBits(int num) {
            //1.
            /*int[] ret = new int[num+1];//num 1 ; arr 0 1
            for (int i = 0; i <= num; i++) {
                ret[i] = Integer.bitCount(i);
            }
            return ret;*/
            //2.
            /*int[] ret = new int[num];
            for (int i = 1; i < num + 1; i++) {
                ret[i] = popCount(i);
            }
            return ret;*/
            //3.
            int[] ans = new int[num + 1];
            for (int i = 1; i <= num; ++i)
                ans[i] = ans[i & (i - 1)] + 1;//去掉最高位1之后的数字
            return ans;
        }

        private int popCount(int x) {
            int count;
            for(count = 0; x != 0 ; ++count){
                x &= x -1;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
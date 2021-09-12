package leetcode.editor.cn;
//给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。 
//
//
// 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。 
//
// 
//
// 示例 1： 
//
// 输入：[0,1,1]
//输出：[true,false,false]
//解释：
//输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
// 
//
// 示例 2： 
//
// 输入：[1,1,1]
//输出：[false,false,false]
// 
//
// 示例 3： 
//
// 输入：[0,1,1,1,1,1]
//输出：[true,false,false,false,true,false]
// 
//
// 示例 4： 
//
// 输入：[1,1,1,0,1]
//输出：[false,false,false,false,false]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 30000 
// A[i] 为 0 或 1 
// 
// Related Topics 数组 
// 👍 78 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    public static void main(String[] args) {
        Solution solution = new BinaryPrefixDivisibleBy5()
                .new Solution();
        System.out.println(solution.prefixesDivBy5(new int[]{1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Boolean> prefixesDivBy5(int[] A) {
            /**
             * 思路：计算过程始终保留余数，不保存每次的结果，所以不会出现溢出问题
             *  没想出来，涉及到位运算. 暴力破解会溢出
             *          执行耗时:4 ms,击败了92.76% 的Java用户
             * 			内存消耗:39.4 MB,击败了17.09% 的Java用户
             * 	总结：一注意题目中数组长度等条件
             * 	     二注意类型的越界和空指针现象
             */
            List<Boolean> res = new ArrayList<>();
            int length = A.length;
            int prefix = 0;

            for ( int i = 0 ; i < length ; i++ ) {
                prefix = ((prefix << 1) + A[i]) % 5;
                res.add(prefix == 0);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
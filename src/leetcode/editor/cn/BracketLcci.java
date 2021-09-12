package leetcode.editor.cn;
//括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。 
//
// 说明：解集不能包含重复的子集。 
//
// 例如，给出 n = 3，生成结果为： 
//
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法 
// 👍 50 👎 0


import java.util.*;

public class BracketLcci {
    public static void main(String[] args) {
        Solution solution = new BracketLcci()
                .new Solution();
        System.out.println(solution.generateParenthesis(4));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：
         * 1.先构建出((()))此类型的字符串，通过此字符串进行拓展，寻找其他的字符串
         * 失败，考虑的太片面 ❌❌
         * 2.回溯方法 ****暂时不会 没有提交****
         * 1)若左括号数小于n，则当前位置可以是左括号，进入递归分支1
         * 2)若右括号数小于左括号数，则当前位置可以是右括号，进入递归分支2
         * 3)当左括号数等于右括号数等于n，则收集结果并结束递归
         *
         * 每次的选择最多有两个，要么选左括号，要么右括号，“选择”会展开出一棵解的空间树。
         * 用 DFS 的方式遍历这棵树，找出所有的解，这个过程叫回溯。
         *
         * @param n
         * @return
         */
        List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {

            r(0, 0, n, new StringBuffer());
            return res;
        }

        void r(int cntL, int cntR, int n, StringBuffer sb) {
            if (cntL == cntR && cntL == n) {
                res.add(sb.toString());
                return;
            }
            if (cntL < n) {
                StringBuffer sb1 = new StringBuffer(sb);
                sb1.append("(");
                r(cntL + 1, cntR, n, sb1);
            }
            if (cntL > cntR) {
                StringBuffer sb2 = new StringBuffer(sb);
                sb2.append(")");
                r(cntL, cntR + 1, n, sb2);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
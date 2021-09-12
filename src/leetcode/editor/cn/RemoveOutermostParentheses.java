package leetcode.editor.cn;
//有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"
//，"(())()" 和 "(()(()))" 都是有效的括号字符串。 
//
// 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。 
//
// 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。 
//
// 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。 
//
// 
//
// 示例 1： 
//
// 输入："(()())(())"
//输出："()()()"
//解释：
//输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
//删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。 
//
// 示例 2： 
//
// 输入："(()())(())(()(()))"
//输出："()()()()(())"
//解释：
//输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
//删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
// 
//
// 示例 3： 
//
// 输入："()()"
//输出：""
//解释：
//输入字符串为 "()()"，原语化分解得到 "()" + "()"，
//删除每个部分中的最外层括号后得到 "" + "" = ""。
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 10000 
// S[i] 为 "(" 或 ")" 
// S 是一个有效括号字符串 
// 
// Related Topics 栈 
// 👍 150 👎 0


import com.sun.security.auth.UnixNumericGroupPrincipal;

import java.util.Arrays;
import java.util.LinkedList;

public class RemoveOutermostParentheses{
        public static void main(String[] args){
            Solution solution = new RemoveOutermostParentheses()
            .new Solution();
            System.out.println(solution.removeOuterParentheses("(()())(())"));

        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路：找到最外层的 ( 和 )
             *      1.辅助栈
             *          //执行耗时:7 ms,击败了39.95% 的Java用户
             *          //内存消耗:38.6 MB,击败了35.19% 的Java用户
             *      2.双指针
             *          执行耗时:3 ms,击败了78.52% 的Java用户
             * 			内存消耗:38.3 MB,击败了81.34% 的Java用户
             * @param S
             * @return
             */
    public String removeOuterParentheses(String S) {

        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        int len = chars.length;

        //1双指针
        /*int left = 0;
        int count = 0;
        int right = left +1;
        for (int i = 1; i < len; i++) {
            if(count == 0 && chars[i] == ')'){
                right = i;
                sb.append(S.substring(left + 1, right ));

                left = i + 1;
                right = left + 1;
                count = -1;
            }else if(chars[i] == '('){
                count ++;
            }else {
                count --;
            }
        }*/

        //2.辅助栈  (()())(())
        LinkedList<Character> stack = new LinkedList<Character>();
        int left = 0;
        for (int i = 0; i < len; i++) {
            if(stack.isEmpty() && chars[i] == '('){
                stack.push(chars[i]);
                left = i;
            }else if(stack.size() == 1 && chars[i] == ')'){
                sb.append(S, left + 1, i);
                stack.pop();
            }else if(chars[i] == '('){
                stack.push(chars[i]);
            }else if(chars[i] == ')'){
                stack.pop();
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
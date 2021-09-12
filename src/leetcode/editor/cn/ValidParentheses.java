package leetcode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2082 👎 0


import java.util.ArrayDeque;
import java.util.Objects;

public class ValidParentheses{
        public static void main(String[] args){
            String s = "]";
            Solution solution = new ValidParentheses()
            .new Solution();
            System.out.println(solution.isValid(s));

        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 使用字符串的方法转化为char数组
             * 左括号入栈，右括号出栈比对
             * 清除左括号和右括号的关系
             * 单个（（的情况
             * @param s
             * @return
             */
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<Character>();

        char[] array = s.toCharArray();
        if( array.length%2 != 0){
            return false;
        }
        for (Character c : array) {
            //为什么总是想着把原数据push呢，你也可以push ]然后直接取出比较
            if( c.equals('(') || c.equals('{') || c.equals('[')){
                stack.push(c);
            }else {
                if(stack.isEmpty()){
                    return false;
                }
                Character pop = stack.pop();
                int k = 0;
                if(pop.equals('(')){
                    k = 1;
                }else {
                    k = 2;
                }
                if( !pop.equals( (char)(c - k)) ){//犯s了
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
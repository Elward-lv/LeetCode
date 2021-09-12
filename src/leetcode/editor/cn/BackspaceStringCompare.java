package leetcode.editor.cn;
//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
// 
//
// 示例 2： 
//
// 输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
// 
//
// 示例 3： 
//
// 输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
// 
//
// 示例 4： 
//
// 输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S 和 T 只含有小写字母以及字符 '#'。 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// 
// Related Topics 栈 双指针 
// 👍 254 👎 0


import java.util.LinkedList;

public class BackspaceStringCompare{
        public static void main(String[] args){
            Solution solution = new BackspaceStringCompare()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String S, String T) {
        /**
         * 没必要只使用栈的数据结构做，什么样的结构更效率才是正道
         * 1.最简单的写法，通过两个栈进行比较
         * 2.使用StringBuffer当作栈来使用
         * 3.双指针的使用
         */
        /* ================1 by 吕燕伟=================
        //执行耗时:2 ms,击败了44.18% 的Java用户
        //内存消耗:36.9 MB,击败了11.92% 的Java用户
        LinkedList<Character> stack1 = new LinkedList<>();
        LinkedList<Character> stack2 = new LinkedList<>();
        char[] chars1 = S.toCharArray();
        char[] chars2 = T.toCharArray();

        for (Character c : chars1) {
            if(c.equals('#')){
                if(!stack1.isEmpty()) stack1.pop();
            }else {
                stack1.push(c);
            }
        }

        for (Character c : chars2) {
            if(c.equals('#')){
                if(!stack2.isEmpty()) stack2.pop();
            }else {
                stack2.push(c);
            }
        }
        if(stack1.size() == stack2.size()){
            while (!stack1.isEmpty()){
                if(!stack1.pop().equals(stack2.pop())){
                    return false;
                }
            }
            return true;
        }
        return false;*/

        //===============2 by internet================
        //执行耗时:1 ms,击败了84.14% 的Java用户
        //内存消耗:36.5 MB,击败了42.32% 的Java用户
        return build(S).equals(build(T));
    }

    public String build(String s){
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length ; i++) {
            char c = s.charAt(i);
            if(c == '#'){
                if(sb.length()>0) sb.deleteCharAt(sb.length() - 1);
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
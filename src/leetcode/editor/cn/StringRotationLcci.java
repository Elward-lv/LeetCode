package leetcode.editor.cn;
//字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。 
//
// 示例1: 
//
//  输入：s1 = "waterbottle", s2 = "erbottlewat"
// 输出：True
// 
//
// 示例2: 
//
//  输入：s1 = "aa", s2 = "aba"
// 输出：False
// 
//
// 
// 
//
// 提示： 
//
// 
// 字符串长度在[0, 100000]范围内。 
// 
//
// 说明: 
//
// 
// 你能只调用一次检查子串的方法吗？ 
// 
// Related Topics 字符串 
// 👍 48 👎 0


import java.util.LinkedList;

public class StringRotationLcci{
        public static void main(String[] args){
            Solution solution = new StringRotationLcci()
            .new Solution();
            System.out.println(solution.isFlipedString("eCQOKatuwIPRHFftkBmhQfakidjbtRVwblGdpLTtSLbjFzBwIjobHMsPvyucjIEs",
                    "kBmhQfakidjbtRVwblGdpLTtSLbjFzBwIjobHMsPvyucjIEseCQOKatuwIPRHFft"));

        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路：
             * @param s1
             * @param s2
             * @return
             */
    public boolean isFlipedString(String s1, String s2) {
        /*//自己的写法,特别麻烦
        //执行耗时:17 ms,击败了9.77% 的Java用户
			内存消耗:39.3 MB,击败了5.04% 的Java用户
        LinkedList<Integer> indexs = new LinkedList<Integer>();
        int length = s1.length();
        if(s2.length() != length ){
            return false;
        }
        if(length == 0 ){
            return true;
        }
        Character startChar = s2.charAt(length - 1);
        //find all the char in s1 and wirte down
        int startIndex = s1.indexOf(startChar);
        int endIndex = s1.lastIndexOf(startChar);
        if(startIndex != endIndex){
            indexs.push(startIndex);
            indexs.push(endIndex);
        }else {
            indexs.push(startIndex);
        }

        for(int i = startIndex + 1 ; i < endIndex ; i ++){
            if(startChar == s1.charAt(i)){
                indexs.push(i);
            }
        }

        //circle and compare is not the same as s2
        while (!indexs.isEmpty()){//s1 = "waterbottle", s2 = "erbottlewat"
            Integer index = indexs.pop();
            String str = s1.substring(index + 1) + s1.substring(0, index + 1) ;
            if(str.equals(s2)){
                return true;
            }
        }
        return false;*/
        //===天秀操作====
        //执行耗时:0 ms,击败了100.00% 的Java用户
        //内存消耗:38.5 MB,击败了38.57% 的Java用户
        if (s1.length()!=s2.length()) return false;
        String ss = s2+s2;
        return ss.contains(s1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
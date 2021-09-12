package leetcode.editor.cn;
//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 示例 1: 
//
// 
//输入: "aba"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "abca"
//输出: True
//解释: 你可以删除c字符。
// 
//
// 注意: 
//
// 
// 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。 
// 
// Related Topics 字符串 
// 👍 320 👎 0


public class ValidPalindromeIi {
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi()
                .new Solution();
        solution.validPalindrome("ebcbbececabbacecbbcbe");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路
         * 1.双指针法。当遇到不同时，尝试跳过某个字符进行匹配
         *          执行耗时:7 ms,击败了95.46% 的Java用户
         * 			内存消耗:38.9 MB,击败了79.10% 的Java用户
         * @param s
         * @return
         */
        public boolean validPalindrome(String s) {
            return validPalindrome(s, 0, s.length() - 1,true);
        }

        private boolean validPalindrome(String s, int st, int end , boolean recursiveFlg) {

            int low = st, high = end;
            while (low <= high) {
                if (s.charAt(low) != s.charAt(high)) {
                    if (recursiveFlg) {
                        //判断哪个指针移动
                        return validPalindrome(s, low, high - 1,false)
                                || validPalindrome(s, low + 1, high,false);
                    }else return false;
                }
                low++;
                high--;
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
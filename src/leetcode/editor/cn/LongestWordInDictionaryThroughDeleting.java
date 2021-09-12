package leetcode.editor.cn;
//给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符
//串。如果答案不存在，则返回空字符串。 
//
// 示例 1: 
//
// 
//输入:
//s = "abpcplea", d = ["ale","apple","monkey","plea"]
//
//输出: 
//"apple"
// 
//
// 示例 2: 
//
// 
//输入:
//s = "abpcplea", d = ["a","b","c"]
//
//输出: 
//"a"
// 
//
// 说明: 
//
// 
// 所有输入的字符串只包含小写字母。 
// 字典的大小不会超过 1000。 
// 所有输入的字符串长度不会超过 1000。 
// 
// Related Topics 排序 双指针 
// 👍 131 👎 0


import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public static void main(String[] args) {
        Solution solution = new LongestWordInDictionaryThroughDeleting()
                .new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：
         * 1.正则表达式。根据字典之中得每个string得所有char构建正则式，用这个正则表达式去匹配原string
         * 成功则说明包含此子串（且字母数量一致），否则不能通过原string删减字符得到字典中string。此过程之中保存最值即可
         * 2.双指针判断原string是否包含字典之中string(CS NOTE)
         *          执行耗时:30 ms,击败了32.74% 的Java用户
         * 			内存消耗:39.3 MB,击败了67.61% 的Java用户
         * @param s
         * @param d
         * @return
         */
        public String findLongestWord(String s, List<String> d) {
            String longestWord = "";
            for (String target : d) {
                int l1 = longestWord.length(), l2 = target.length();
                if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                    continue;
                }
                if (isSubstr(s, target)) {
                    longestWord = target;
                }
            }
            return longestWord;
        }

        private boolean isSubstr(String s, String target) {
            int i = 0, j = 0;
            while (i < s.length() && j < target.length()) {
                if (s.charAt(i) == target.charAt(j)) {
                    j++;
                }
                i++;
            }
            return j == target.length();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
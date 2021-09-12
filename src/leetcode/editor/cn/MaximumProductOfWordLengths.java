package leetcode.editor.cn;
//给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为
//每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。 
//
// 示例 1: 
//
// 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
//输出: 16 
//解释: 这两个单词为 "abcw", "xtfn"。 
//
// 示例 2: 
//
// 输入: ["a","ab","abc","d","cd","bcd","abcd"]
//输出: 4 
//解释: 这两个单词为 "ab", "cd"。 
//
// 示例 3: 
//
// 输入: ["a","aa","aaa","aaaa"]
//输出: 0 
//解释: 不存在这样的两个单词。 
// Related Topics 位运算 
// 👍 141 👎 0


public class MaximumProductOfWordLengths{
        public static void main(String[] args){
            Solution solution = new MaximumProductOfWordLengths()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路
             * 1.记录自己错误思路：想要找出哪两个字符串。而题目只要找出最大即可。所以只要双重循环即可.
             * 2.双重循环寻找替代Max的值，循环内部比较两个字符串是否含有公共字符。(参考CSnote)
             * 如何比较公共字符？可以通过使用一个int前26个位置来记录一个字符串之中含有的字符
             *      执行耗时:8 ms,击败了97.88% 的Java用户
             * 			内存消耗:38.4 MB,击败了91.18% 的Java用户
             * @param words
             * @return
             */
    public int maxProduct(String[] words) {
        int length = words.length;
        int[] values = new int[length];
        //标记每个字符串之中出现过的字符
        for (int i = 0; i < length; i++) {
            for (char c : words[i].toCharArray()) {
                values[i] |= 1 << (c - 'a');
            }
        }
        //循环找最大乘积
        int maxRet = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if((values[i] & values[j]) == 0){
                    maxRet = Math.max(maxRet , words[i].length() * words[j].length());
                }
            }
        }
        return maxRet;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
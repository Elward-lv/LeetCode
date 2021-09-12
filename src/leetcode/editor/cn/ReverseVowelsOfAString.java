package leetcode.editor.cn;
//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。 
//
// 
//
// 示例 1： 
//
// 输入："hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 输入："leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 元音字母不包含字母 "y" 。 //a、e、i、o、u
// 
// Related Topics 双指针 字符串 
// 👍 143 👎 0


import java.util.Arrays;
import java.util.HashSet;

public class ReverseVowelsOfAString {

    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString()
                .new Solution();
        solution.reverseVowels("hello");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：
         * 1.双指针。左指针从开始扫描，右指针从结束扫描。在两个指针相交之前，交换遇到得元音字母即可
         *      使用StringBuilder浪费了不少时间，其次是对于元音字母得判断
         *          执行耗时:44 ms,击败了5.02% 的Java用户
         * 			内存消耗:39.4 MB,击败了9.50% 的Java用户
         * 	2.CSNOTE .思想类似，使用map保存判断元音字母，提高效率，使用数组替换StringBuilder提高效率
         * 	        执行耗时:6 ms,击败了30.61% 的Java用户
         * 			内存消耗:38.5 MB,击败了57.76% 的Java用户
         * @param s
         * @return
         */
        private final HashSet<Character> vowels = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        public String reverseVowels(String s) {
            //1.
            /*if (s == null || s.length() == 1) return s;

            StringBuilder sb = new StringBuilder(s);
            char[] chars = {'a', 'A','e','E', 'i','I', 'o','O', 'u','U'};
            int left = 0, high = s.length() - 1;
            while (left <= high) {
                char l_char = 0;
                char h_char = 0;
                while (left < s.length() && !isInCharArr((l_char = s.charAt(left)), chars)) {//找到左侧元音字母
                    left++;
                }
                while (high >= 0 && !isInCharArr((h_char = s.charAt(high)), chars)) {//找到右侧元音字母
                    high--;
                }
                //交换元音字母
                if (left <= high) {
                    sb.replace(left, left + 1, String.valueOf(h_char));
                    left++;
                    sb.replace(high, high + 1, String.valueOf(l_char));
                    high--;
                }else break;
            }
            return sb.toString();*/
            //2.
            int i = 0, j = s.length() - 1;
            char[] result = new char[s.length()];
            while (i <= j) {
                char ci = s.charAt(i);
                char cj = s.charAt(j);
                if (!vowels.contains(ci)) {
                    result[i++] = ci;
                } else if (!vowels.contains(cj)) {
                    result[j--] = cj;
                } else {
                    result[i++] = cj;
                    result[j--] = ci;
                }
            }
            return new String(result);
        }

        private boolean isInCharArr(Character c, char[] arrs) {
            for (char arr : arrs) {
                if (c.equals(arr)) return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
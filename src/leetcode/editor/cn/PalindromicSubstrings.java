package leetcode.editor.cn;
//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 468 👎 0


public class PalindromicSubstrings{
        public static void main(String[] args){
            Solution solution = new PalindromicSubstrings()
            .new Solution();
            System.out.println(solution.countSubstrings("aa"));

        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路：
             * 1.枚举所有的子串,判断回文串
             * 2.枚举所有的回文中心.
             *      这样需要考虑奇数和偶数的回文中心情况
             *      执行耗时:4 ms,击败了77.27% 的Java用户
             * 		内存消耗:36.5 MB,击败了83.83% 的Java用户
             * @param s
             * @return
             */
    public int countSubstrings(String s) {
        //2.
        int sum = 0;
        for (int cur = 0; cur < s.length(); cur++) {
            int left = cur, right = cur , count = 0;
            //如何判断回文中心
            //奇数的回文中心
            while ( s.charAt(left) == s.charAt(right) ){
                count ++;
                if(left <= 0 || right >= s.length() - 1 ){
                    break;
                }
                left --;
                right ++;
            }
            //偶数的回文中心
            if(cur >= 1 && s.charAt(cur) == s.charAt(cur - 1)){
                count++;
                left = cur - 2;
                right = cur+1;
                while ( left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right) ){
                    count ++;
                    left --;
                    right ++;
                }
            }
            sum += count;
        }
        return sum;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
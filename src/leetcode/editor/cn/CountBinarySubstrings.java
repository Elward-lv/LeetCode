package leetcode.editor.cn;
//给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，并且这些子字符串中的所有0和所有1都是组合在一起的。 
//
// 重复出现的子串要计算它们出现的次数。 
//
// 示例 1 : 
//
// 
//输入: "00110011"
//输出: 6
//解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
//
//请注意，一些重复出现的子串要计算它们出现的次数。
//
//另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
// 
//
// 示例 2 : 
//
// 
//输入: "10101"
//输出: 4
//解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
// 
//
// 注意： 
//
// 
// s.length 在1到50,000之间。 
// s 只包含“0”或“1”字符。 
// 
// Related Topics 字符串 
// 👍 329 👎 0


public class CountBinarySubstrings{
        public static void main(String[] args){
            Solution solution = new CountBinarySubstrings()
            .new Solution();
            System.out.println(solution.countBinarySubstrings("00110011"));

        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路：
             * 1. 找到所有的01所在位置，从01往外拓展，找到其他01串
             *      执行耗时:23 ms,击败了6.54% 的Java用户
             * 		内存消耗:39 MB,击败了54.87% 的Java用户
             * @param s
             * @return
             */
    public int countBinarySubstrings(String s) {
        int left = 0 , right = left + 1 , sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            if( i>= 0 && i < s.length() - 1){
                if(s.charAt(i) == '0' && s.charAt(i+1) == '1' || s.charAt(i) == '1' && s.charAt(i+1) == '0'){
                    count++;
                    left = i - 1;
                    right = i + 2;
                    while (left >= 0 && right <= s.length() - 1){
                        if(s.charAt(left) != s.charAt(i) || s.charAt(right) != s.charAt(i+1)){
                            break;
                        }
                        left --;
                        right ++;
                        count++;
                    }
                }
            }
            sum += count;
        }
        return sum;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
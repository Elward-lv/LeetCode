package leetcode.editor.cn;
//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表 
// 👍 262 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome{
        public static void main(String[] args){
            Solution solution = new LongestPalindrome()
            .new Solution();
            System.out.println(solution.longestPalindrome("abccccdd"));

        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路：
             * 1. 通过hashmap来记录所有的字符的数量，最后计算偶数，奇数以及单独的char总个数
             *          执行耗时:11 ms,击败了9.69% 的Java用户
             * 			内存消耗:37.1 MB,击败了13.69% 的Java用户
             * 2.不使用map，仅使用一个指针和一个计数器来完成计数，在对chars排序之后
             *          执行耗时:3 ms,击败了46.45% 的Java用户
             * 			内存消耗:36.9 MB,击败了28.50% 的Java用户
             * @param s
             * @return
             */
    public int longestPalindrome(String s) {
        /*
        //1.
        Map<Character , Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();

        boolean singleFlag = true;
        int sumCount = 0;
        for (Character c : chars) {
            if(map.size() == 0 || !map.containsKey(c)){
                map.put(c , 1);
            }else {
                int count = map.get(c) + 1;
                map.put(c , count);
            }
        }
        //for and count the res
        for (Character character : map.keySet()) {
            if(map.get(character) == 1 && singleFlag){
                sumCount += 1;
                singleFlag = false;
            }else {
                int t = 0;
                if( (t = map.get(character)) % 2 == 0){
                    sumCount += t;
                }else {
                    sumCount += t - 1;
                    if(singleFlag) {
                        sumCount += 1;
                        singleFlag = false ;
                    }
                }
            }
        }
        return sumCount;*/

        //2.
        /*int sumCount = 0;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        char cur = chars[0];
        int count = 0;
        boolean oneflag = true;
        for (int i = 0; i < chars.length; i++) {//abccccdd
            if(cur == chars[i]){
                count++;
            }else{
                if(count % 2 == 0)
                {
                    sumCount += count;
                }else {
                    sumCount += count -1;
                    if(oneflag) oneflag = false;
                }

                cur = chars[i];
                count = 1;
            }

            if(i == chars.length - 1){
                if(count % 2 == 0)
                {
                    sumCount += count;
                }else {
                    sumCount += count -1;
                    if(oneflag) oneflag = false;
                }
            }
        }
        if(oneflag == false){
            sumCount += 1 ;
        }
        return sumCount;*/

        //3.大神写法====优雅！
        int[] cnt = new int[58];
        for (char c : s.toCharArray()) {
            cnt[c - 'A'] += 1;
        }

        int ans = 0;
        for (int x: cnt) {
            // 字符出现的次数最多用偶数次。
            ans += x - (x & 1);
        }
        // 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
        return ans < s.length() ? ans + 1 : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;
//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 327 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram{
        public static void main(String[] args){
            Solution solution = new ValidAnagram()
            .new Solution();
            System.out.println(solution.isAnagram("anagram", "nagaram"));

        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路：
             * 1.使用hashmap记录每个字母的个数，最后进行比较，字母和字母个数
             *          执行耗时:15 ms,击败了22.79% 的Java用户
             * 			内存消耗:39.1 MB,击败了17.44% 的Java用户
             * 2.简化算法：可以使用一个hashMap来完成计数即可，另外一个在此基础上递减
             *          执行耗时:31 ms,击败了5.00% 的Java用户
             * 			内存消耗:39.7 MB,击败了5.05% 的Java用户
             * 3.使用数组解决
             *          执行耗时:4 ms,击败了61.65% 的Java用户
             * 			内存消耗:38.7 MB,击败了52.90% 的Java用户
             * 4.对两个字符串转化之后的数组排序，如果排序之后相等则返回true
             *          执行耗时:2 ms,击败了99.89% 的Java用户
             * 			内存消耗:38.9 MB,击败了27.64% 的Java用户
             * @param s
             * @param t
             * @return
             */
    public boolean isAnagram(String s, String t) {

        /*//2
        Map<Character, Integer> sMap = getCharCountMap(s);

        for (Character character : t.toCharArray()) {
            if( !sMap.containsKey(character)){
                return false;
            }
            if(sMap.get(character) == 0){
                sMap.remove(character);
            }else {
                sMap.put(character , sMap.get(character) - 1);
                if(sMap.get(character) == 0){
                    sMap.remove(character);
                }
            }
        }
        if(sMap.size() == 0){
            return true;
        }
        return false;*/

        /*//3
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;*/
        //4.
        if(s.length() != t.length()) return false;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        char[] chart = t.toCharArray();
        Arrays.sort(chart);
        if(! new String(chars).equals(new String(chart))){
            return false;
        }
        return true;

    }

    public Map<Character , Integer> getCharCountMap(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if(map.containsKey(c)){
                map.put(c , map.get(c) + 1);
            }else {
                map.put(c , 1);
            }
        }
        return map;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
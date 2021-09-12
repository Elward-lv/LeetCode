package leetcode.editor.cn;
//给定两个字符串 s 和 t，判断它们是否是同构的。 
//
// 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。 
//
// 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。 
//
// 
//
// 示例 1: 
//
// 
//输入：s = "egg", t = "add"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "foo", t = "bar"
//输出：false 
//
// 示例 3： 
//
// 
//输入：s = "paper", t = "title"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 可以假设 s 和 t 长度相同。 
// 
// Related Topics 哈希表 
// 👍 321 👎 0


import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings{
        public static void main(String[] args){
            Solution solution = new IsomorphicStrings()
            .new Solution();
            System.out.println(solution.isIsomorphic("baddc", "baeba"));
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路：
             * 1.用两个数组保存字母的对应关系，防止出现一个字母对两个的情况  使用char的值减去‘a’ 对 应 索 引出错，因为这样的话索引可能为-
             * 2.用两个数组记录，每个字符上次出现的位置. 如果两个字符串中的字符上次出现的位置一样，那么就属于同构。
             * 3.两个hashmap记录字符之间的对应关系
             * 4.使用字符串的方法
             * @param s
             * @param t
             * @return
             */
    public boolean isIsomorphic(String s, String t) {
        /*//2.
        //执行耗时:5 ms,击败了87.98% 的Java用户
        //内存消耗:38.8 MB,击败了7.39% 的Java用户
        int[] arrs = new int[256];
        int[] arrt = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if(arrs[sc] != arrt[tc]){
                return false;
            }
            arrs[sc] = i + 1;//i+1的必要性：
            arrt[tc] = i + 1;
        }
        return true;*/

        //3.
        //执行耗时:16 ms,击败了44.02% 的Java用户
        //内存消耗:38.3 MB,击败了80.15% 的Java用户
        /*Map<Character , Character> Smap = new HashMap<>();
        Map<Character , Character> Tmap = new HashMap<>();
        for (int i = 0 ;  i< s.length() ; i++ ) {
            Character sc = s.charAt(i);
            Character tc = t.charAt(i);
            if(!Smap.containsKey(sc) && !Tmap.containsKey(tc)){
                Smap.put(sc , tc);
                Tmap.put(tc , sc);
            }else {
                if(!tc.equals(Smap.get(sc)) || !sc.equals(Tmap.get(tc))){
                    return false;
                }
            }
        }
        return true;*/

        //4.
        for(int i = 0; i < s.length(); i++){
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
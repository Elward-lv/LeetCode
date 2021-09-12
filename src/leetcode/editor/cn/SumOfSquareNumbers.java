package leetcode.editor.cn;
//给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。 
//
// 
//
// 示例 1： 
//
// 输入：c = 5
//输出：true
//解释：1 * 1 + 2 * 2 = 5
// 
//
// 示例 2： 
//
// 输入：c = 3
//输出：false
// 
//
// 示例 3： 
//
// 输入：c = 4
//输出：true
// 
//
// 示例 4： 
//
// 输入：c = 2
//输出：true
// 
//
// 示例 5： 
//
// 输入：c = 1
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= c <= 231 - 1 
// 
// Related Topics 数学 
// 👍 163 👎 0


public class SumOfSquareNumbers{
        public static void main(String[] args){
            Solution solution = new SumOfSquareNumbers()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 1.暴力破解。从0到c得开方
             * 2.二分查找。固定一个数字查找另外一个数字.没做出来
             * 3.双指针法
             *          执行耗时:2 ms,击败了98.37% 的Java用户
             * 			内存消耗:35.5 MB,击败了5.37% 的Java用户
             * @param c
             * @return
             */
    public boolean judgeSquareSum(int c) {
        //2.
        /*for (long a = 0; a * a <= c; a++) {
            int b = c - (int)(a * a);
            if (binary_search(0, b, b))
                return true;
        }
        return false;*/
        //3.
        int i =0 , j = (int)Math.sqrt(c);
        while (i <= j){
            int powSum = i *i + j* j;
            if(powSum == c){
                return true;
            }else if(powSum > c){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }

    private boolean binary_search(long s, long e, int n){
        if (s > e)
            return false;
        long mid = s + (e - s) / 2;
        if (mid * mid == n)
            return true;
        if (mid * mid > n)
            return binary_search(s, mid - 1, n);
        return binary_search(mid + 1, e, n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
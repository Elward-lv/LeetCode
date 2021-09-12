package leetcode.editor.cn;
//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。 
//
// 示例 1: 
//
// 输入: 121
//输出: true
// 
//
// 示例 2: 
//
// 输入: -121   (1*10 + 2)*10 + 1
//输出: false
//解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3: 
//
// 输入: 10
//输出: false
//解释: 从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 进阶: 
//
// 你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1364 👎 0


public class PalindromeNumber{
        public static void main(String[] args){
            Solution solution = new PalindromeNumber()
            .new Solution();
            System.out.println(solution.isPalindrome(22));

        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路：
             * 1.换成String运算
             *      执行耗时:11 ms,击败了48.99% 的Java用户
             * 		内存消耗:38 MB,击败了29.74% 的Java用户
             * 2.反转所有数字，最后比较和原来数字的大小,可能出现溢出
             *      执行耗时:10 ms,击败了77.80% 的Java用户
             * 		内存消耗:38.4 MB,击败了9.08% 的Java用户
             * 3.反转一半数字即可
             * @param x
             * @return
             */
    public boolean isPalindrome(int x) {
        //1.
        /*if( x < 0) return false;
        String value = String.valueOf(x);
        for (int i = 0; i < value.length(); i++) {
            if( i == value.length() - i - 1) break;
            if( value.charAt(i) != value.charAt(value.length() - i - 1) ) return false;
        }
        return true;*/
        //2.
        /*if( x < 0 ) return false;
        int  k = x;
        int sumX = 0;
        while ( k > 0){
            int ge = k % 10;
            k = k / 10;
            sumX = sumX * 10 + ge;
        }
        return sumX == x;*/

        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
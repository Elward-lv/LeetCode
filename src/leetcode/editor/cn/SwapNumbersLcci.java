package leetcode.editor.cn;
//编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。 
// 示例： 
// 输入: numbers = [1,2]
//输出: [2,1]
// 
// 提示： 
// 
// numbers.length == 2 
// 
// Related Topics 位运算 数学 
// 👍 37 👎 0


public class SwapNumbersLcci{
        public static void main(String[] args){
            Solution solution = new SwapNumbersLcci()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] swapNumbers(int[] numbers) {
        //执行耗时:0 ms,击败了100.00% 的Java用户
        //			内存消耗:36.5 MB,击败了54.55% 的Java用户
        numbers[0] = numbers[0] ^ numbers[1];//1未变 ； 0是 0和1异或的结果
        numbers[1] = numbers[0] ^ numbers[1];//1是 上次0和上次1异或 即开始0； 0仍然是0和1异或的结果
        numbers[0] = numbers[0] ^ numbers[1];//0是 上次0和上次1异或 即开始1；1还是上次结果未变；交换完成
        return numbers;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
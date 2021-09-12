package leetcode.editor.cn;
//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 609 👎 0


import java.util.Arrays;
import java.util.LinkedList;

public class DailyTemperatures{
        public static void main(String[] args){
            Solution solution = new DailyTemperatures()
            .new Solution();
            int[] arr = {73,74,75,71,69,72,76,73};
            System.out.println(Arrays.toString(solution.dailyTemperatures(arr)));

        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] T) {
        /**
         * 思路：
         * 1.暴力破解。一直循环找第二个比此数大的数字
         * 2.单调栈可以吗？走不通===>只是你用错了！可以，用栈保存索引
         *
         */
        LinkedList<Integer> stack = new LinkedList<>();
        int[] res = new int[T.length];

        for (int i = 0; i < T.length; i++) {
            if(stack.isEmpty() || T[stack.peek()] > T[i]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && T[stack.peek()] < T[i]){
                    Integer index = stack.pop();
                    res[index] = i - index;
                }
                stack.push(i);
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
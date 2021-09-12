package leetcode.editor.cn;
//给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第
//一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。 
//
// 示例 1: 
//
// 
//输入: [1,2,1]
//输出: [2,-1,2]
//解释: 第一个 1 的下一个更大的数是 2；
//数字 2 找不到下一个更大的数； 
//第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
// 
//
// 注意: 输入数组的长度不会超过 10000。 
// Related Topics 栈 
// 👍 243 👎 0


import java.util.Arrays;
import java.util.LinkedList;

public class NextGreaterElementIi{
        public static void main(String[] args){
            Solution solution = new NextGreaterElementIi()
            .new Solution();
            System.out.println(Arrays.toString(solution.nextGreaterElements(new int[]{0,-2,-3})));

        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路
             * 1.单调栈：a：由于是循环栈，所以数组最后的数字可能需要重新判断是否右侧有最大值，
             *          但是如果重复循环，这样又会导致这几个数字重新放入栈，并且找不到下一个更大的数字
             *          所以第二次遍历只需要遍历到数组中最大值即可，这样保证了不可能还有更大的元素
             *      总结：需要找到题目的特点/循环条件 比如这个题目，虽然需要使用单调栈，但是循环结束的条件是什莫？
             *          b：
             *
             *
             * @param nums
             * @return
             */
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        LinkedList<Integer> indexs = new LinkedList<Integer>();

        int length = nums.length ;
        int max = nums[0];
        for (int i = 0; i <  2 * length ; i++) {
            if(max < nums[i % length] && i < length){
                max = nums[i % length];
            }
            if( indexs.isEmpty() || nums[indexs.peek()] > nums[i % length] ){
                indexs.push(i % length);
            }else {
                while ( !indexs.isEmpty() && nums[indexs.peek()] < nums[i % length] ){
                    Integer index = indexs.pop();
                    if(res[index] == 0){
                        res[index] = nums[i % length ];
                    }
                }
                indexs.push(i % length);
            }

            if(i >= length && nums[i % length] == max){
                break;
            }
        }

        while (!indexs.isEmpty()){
            Integer index = indexs.pop();
            if(res[index] == 0) res[index] = -1;
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
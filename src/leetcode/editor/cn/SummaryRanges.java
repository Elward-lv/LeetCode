package leetcode.editor.cn;
//给定一个无重复元素的有序整数数组 nums 。 
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 num
//s 的数字 x 。 
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 示例 3： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 4： 
//
// 
//输入：nums = [-1]
//输出：["-1"]
// 
//
// 示例 5： 
//
// 
//输入：nums = [0]
//输出：["0"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -231 <= nums[i] <= 231 - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
// Related Topics 数组 
// 👍 106 👎 0


import java.util.ArrayList;
import java.util.List;

public class SummaryRanges{
        public static void main(String[] args){
            int[] nums = {0,2,3,4,6,8,9};
            Solution solution = new SummaryRanges()
            .new Solution();
            List<String> list = solution.summaryRanges(nums);
            System.out.println(list);

        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 数组升序，值互不相同，-231->231，数组长度小于20
             * @param nums
             * @return
             */
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        int length = nums.length;
        int i = 0;
        if(length == 1){
            res.add(Integer.toString(nums[i]));
        }else {
            while ( i < length ){
                int start = nums[i], j = 1 , k = i + 1 ;
                while (true){
                    if( k >= length ||  j != nums[k] - start){
                        break;
                    }
                    k++;
                    j++;
                }
                int end = nums[k-1];
                i = k ;
                if( end != start ){
                    res.add(new String(start+"->"+end));
                }else {
                    res.add(Integer.toString(start));
                }

            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;
//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。 
//
// 
//
// 示例 1: 
//
// 输入: [10,2]
//输出: "102" 
//
// 示例 2: 
//
// 输入: [3,30,34,5,9]  //30 3  34  5  9
//输出: "3033459" 
//
// 
//
// 提示: 
//
// 
// 0 < nums.length <= 100 
// 
//
// 说明: 
//
// 
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数 
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0 
// 
// Related Topics 排序 
// 👍 154 👎 0


import java.util.HashMap;
import java.util.Map;

public class BaShuZuPaiChengZuiXiaoDeShuLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZuPaiChengZuiXiaoDeShuLcof()
                .new Solution();
        solution.minNumber(new int[]{3,30,34,9,5});

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：
         * 1.按照个位，十位数字依次排序.太过麻烦
         * 2.根据比较式：若拼接字符串 x+y>y+x ，则 x>y ；若拼接字符串 x+y<y+x ，则 y>x ；(关键需要找准此公式)
         *      a.先把数字转化为字符串拼接之后转化为int，比较大小。这种会出现转换异常
         *      b.使用string的compareTo方法+插入排序
         *              执行耗时:12 ms,击败了15.11% 的Java用户
         * 			内存消耗:38.6 MB,击败了6.66% 的Java用户
         * 		c.使用string的compareTo方法+快速排序
         *
         * @param nums
         * @return
         */
        Map<Integer, String> cache = new HashMap<>();

        public String minNumber(int[] nums) {
            if (nums == null) return "";
            StringBuilder sb = new StringBuilder();
            //1.
            //寻找最大的位数
            for (int num : nums) {
                cache.put(num, String.valueOf(num));
            }
            //排序,主要使用插入排序的思想，把数字依次插入到已排序的数组之中
            for (int i = 1; i < nums.length; i++) {
                findPosInOrderedArr(nums, i);
            }
            for (int num : nums) {
                sb.append(num);
            }
            return sb.toString();
        }

        //综合比较的条件，插入排序
        private int findPosInOrderedArr(int[] nums, int st) {
            while (st > 0){
                String current = cache.get(nums[st]);
                String last = cache.get(nums[st - 1]);
                //a
                /*Integer cl = Integer.parseInt(current + last);//303
                Integer lc = Integer.parseInt(last + current);//330
                if(cl < lc) {
                    //交换j位和k位的数字
                    nums[st] = nums[st-1] ^ nums[st];
                    nums[st-1] = nums[st] ^ nums[st-1];
                    nums[st] = nums[st-1] ^ nums[st];
                    st--;
                }*/
                //b
                if((current+last).compareTo(last+current) <= 0 ) {
                    nums[st] = nums[st-1] ^ nums[st];
                    nums[st-1] = nums[st] ^ nums[st-1];
                    nums[st] = nums[st-1] ^ nums[st];
                    st--;
                }
                else break;
            }
            return st;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
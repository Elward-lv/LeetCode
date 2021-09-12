package leetcode.editor.cn;
//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。 
//
// 示例 1: 
//
// 
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 注意: 
//
// 
// 数组长度不超过1000。 
// 数组里整数的范围为 [0, 1000]。 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 263 👎 0


import java.util.Arrays;

public class ValidTriangleNumber {
    public static void main(String[] args) {
        Solution solution = new ValidTriangleNumber()
                .new Solution();
        int[] nums = new int[4];
        System.out.println(solution.triangleNumber(nums));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int triangleNumber(int[] nums) {
            return sortAndBinarySearch(nums);
        }
        //方法1：排序+二分查找
        public int sortAndBinarySearch(int[] nums){
            Arrays.sort(nums);
            int n = nums.length - 1, res = 0;//索引
            //确定两个边
            for (int i = 0; i <= n; i++) {
                if(nums[i] <= 0) continue;
                for (int j = i + 1; j <= n; j++) {
                    int left = j + 1, right = n, k = j;
                    while (left <= right) {

                        int mid = (right + left) / 2;
                        /**
                         * 找到第一个小于i 与 j之和的值的位置记为 k，
                         * 如果mid的值始终小于i + j，那么k一直会往右移
                         * 如果mid的值使用大于i + j，那么k会一直会左移
                         * 所以这里二分用的很巧妙，用来找第一个小于和的值
                         */
                        if (nums[mid] < nums[i] + nums[j]) {
                            k = mid;
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                    res += k - j;
                }
            }

            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
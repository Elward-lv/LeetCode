package leetcode.editor.cn;
//给定一个已按照 升序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
//
// 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0]
// < answer[1] <= numbers.length 。 
//
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
// 
//
// 示例 1： 
//
// 
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
// 
//
// 示例 2： 
//
// 
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
// 
//
// 示例 3： 
//
// 
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= numbers.length <= 3 * 104 
// -1000 <= numbers[i] <= 1000 
// numbers 按 递增顺序 排列 
// -1000 <= target <= 1000 
// 仅存在一个有效答案 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 474 👎 0


public class TwoSumIiInputArrayIsSorted{
        public static void main(String[] args){
            Solution solution = new TwoSumIiInputArrayIsSorted()
            .new Solution();
            solution.twoSum(new int[]{2,7,11,15},9);
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
            /**
             * 思路
             * 1.可以使用以前得hashmap得方法，把target-nums[i]添加到map.....
             * 2.二分查找。先固定一个元素，查找另外一个元素(时间复杂度：O(nlog n))
             *      执行耗时:3 ms,击败了28.85% 的Java用户
             * 			内存消耗:38.9 MB,击败了9.09% 的Java用户
             * 3.双指针。我以为双指针的话可能对于指针得移动很麻烦，结果实质上也是同样操作(时间复杂度：O(n))
             *          执行耗时:1 ms,击败了92.69% 的Java用户
             * 			内存消耗:38.9 MB,击败了16.92% 的Java用户
             * @param numbers
             * @param target
             * @return
             */
    public int[] twoSum(int[] numbers, int target) {

        //2.
        /*int k = 0;
        for (int i = 0; i < numbers.length; i++) {
            if( (k = binarySearch(numbers , target - numbers[i],i+1)) != -1){
                return new int[]{i+1 , k+1};
            }
        }
        return null;*/
        //3.
        int left = 0 , right = numbers.length - 1, temp = 0;
        while (left <= right ){
            temp = numbers[left] + numbers[right];
            if(temp == target){
                return new int[]{left +1, right +1};
            }else if(temp < target){
                left ++;
            }else {
                right --;
            }
        }
        return null;
    }

    private int binarySearch(int[] nums, int target, int start){
        int l = start , h = nums.length -1 , m ;
        while (l <= h){
            m = (l + h)/2;
            if(nums[m] == target){
                return m;
            }else if(nums[m] < target){
                l = m + 1;
            }else {
                h = m - 1;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
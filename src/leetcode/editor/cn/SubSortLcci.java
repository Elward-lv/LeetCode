package leetcode.editor.cn;
//给定一个整数数组，编写一个函数，找出索引m和n，只要将索引区间[m,n]的元素排好序，整个数组就是有序的。注意：n-m尽量最小，也就是说，找出符合条件的最短
//序列。函数返回值为[m,n]，若不存在这样的m和n（例如整个数组是有序的），请返回[-1,-1]。 
// 示例： 
// 输入： [1,2,4,7,10,11,7,12,6,7,16,18,19]
//输出： [3,9]
// 
// 提示： 
// 
// 0 <= len(array) <= 1000000 
// 
// Related Topics 排序 数组 
// 👍 59 👎 0


public class SubSortLcci {
    public static void main(String[] args) {
        Solution solution = new SubSortLcci()
                .new Solution();
        solution.subSort(new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 1.快速排序实现。先排序其次找不同的元素
         *          执行耗时:2195 ms,击败了5.06% 的Java用户
         * 			内存消耗:64.3 MB,击败了5.06% 的Java用户
         * 2.一遍遍历 + 双指针(没理解)
         *  原理：如果左侧最大值大于中间的最小值，则一定会被中间序列包括；同理，如果右侧最小值大于中间的最大值，则一定会被中间序列包括。
         *          执行耗时:4 ms,击败了38.72% 的Java用户
         * 			内存消耗:61.9 MB,击败了67.11% 的Java用户
         * @param array
         * @return
         */
        public int[] subSort(int[] array) {
            if (array == null || array.length <= 2) return new int[]{-1, -1};

            //1.
            /*int st = 0, end = array.length - 1;
            int[] temp = Arrays.copyOf(array, array.length);
            fastSort(array, 0, array.length - 1);
            System.out.println(Arrays.toString(array));
            while (st != end) {
                if (temp[st] == array[st]) {
                    st++;
                } else {
                    if (temp[end] == array[end]) {
                        end--;
                    } else {
                        return new int[]{st, end};
                    }
                }
            }
            return new int[]{-1, -1};*/

            //2.
            int last = -1, first = -1;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int len = array.length;
            for(int i = 0; i < len; i++){
                if(array[i] < max){
                    last = i;
                }else{
                    max = Math.max(max, array[i]);
                }

                if(array[len - 1 - i] > min){
                    first = len - 1 - i;
                }else{
                    min = Math.min(min, array[len - 1 - i]);
                }
            }
            return new int[] {first, last};
        }

        private void fastSort(int[] nums, int l, int h) {
            if (l >= h) return;
            //根据元素1进行切分
            int i = l, j = h + 1 , t = nums[l] , temp = 0;
            while (true){
                while (nums[++i] < t && i != h);
                while (nums[--j] > t && j != l);
                if( i >= j) break;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            temp = nums[l];
            nums[l] = nums[j];
            nums[j] = temp;

            //递归
            //这里出了个小问题，原本是j，导致死循环，应该从切割的上个元素到low，和下个元素开始到high
            fastSort(nums , l , j - 1);
            fastSort(nums , j+1, h);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
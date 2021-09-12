package leetcode.editor.cn;
//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性： 
//
// 
// 每行的元素从左到右升序排列。 
// 每列的元素从上到下升序排列。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,4,7,11,15],
//              [2,5,8,12,19],
//              [3,6,9,16,22],
//              [10,13,14,17,24],
//              [18,21,23,26,30]
//              ], target = 5
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= n, m <= 300 
// -109 <= matix[i][j] <= 109 
// 每行的所有元素从左到右升序排列 
// 每列的所有元素从上到下升序排列 
// -109 <= target <= 109 
// 
// Related Topics 二分查找 分治算法 
// 👍 577 👎 0


public class SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrixIi()
                .new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：类似于回溯法
         *
         * @param matrix
         * @param target
         * @return
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] <= target && matrix[i][matrix[i].length-1] >= target) {
                    if (binarySearch(matrix[i], target)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /**
         * 二分查找
         *
         * @param arrs
         * @param target
         * @return
         */
        public boolean binarySearch(int[] arrs, int target) {
            int st = 0, end = arrs.length - 1, mid;
            while (st <= end) {
                mid = ( end + st) / 2;
                if (arrs[mid] == target) {
                    return true;
                } else if (arrs[mid] < target) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
package leetcode.editor.cn;
//在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“
//房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。 
//
// 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。 
//
// 示例 1: 
//
// 输入: [3,2,3,null,3,null,1]
//
//     3
//    / \
//   2   3
//    \   \ 
//     3   1
//
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7. 
//
// 示例 2: 
//
// 输入: [3,4,5,1,3,null,1]
//
//     3
//    / \
//   4   5
//  / \   \ 
// 1   3   1
//输出: 9

//     3
//    / \
//   4   5
//  / \   \
// 2   3   1
//输出: 10 --如何计算的呢?
//解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
// 
// Related Topics 树 深度优先搜索 动态规划 二叉树 
// 👍 961 👎 0


public class HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new HouseRobberIii()
                .new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        /**
         * 1.我的：这不就是层级遍历嘛，计算基数层和偶数层的和比较大小,不是，因为有可能不是一层的 ×
         * 2.CSNOTE: 求隔层的和，然后求和,但是[3,4,5,2,3,null,1]是如何求出10的呢？在计算rob(4)的时候返回的是2+3=5
         * @param root
         * @return
         */
        public int rob(TreeNode root) {
            if(root == null) return 0;
            int val1 = root.val;
            if(root.left != null) val1 += rob(root.left.left) + rob(root.left.right);
            if(root.right != null) val1 += rob(root.right.left) + rob(root.right.right);
            int val2 = rob(root.left) + rob(root.right);
            return Math.max(val1, val2);
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
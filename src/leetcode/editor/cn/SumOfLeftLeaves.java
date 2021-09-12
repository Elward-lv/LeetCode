package leetcode.editor.cn;
//计算给定二叉树的所有左叶子之和。 
//
// 示例： 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24 
//
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 338 👎 0


public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution solution = new SumOfLeftLeaves()
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
         * 思路：
         * 1.我的：在递归遍历左右子树的同时，判断此节点是否为左叶子节点，左叶子节点即上个节点的左子树、而且它的左右均为空
         *      执行耗时:0 ms,击败了100.00% 的Java用户
         * 			内存消耗:36.2 MB,击败了57.94% 的Java用户
         * @param root
         * @return
         */
        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null) return 0;
            TreeNode left = root.left;
            int val = 0;
            if(left != null && left.left == null && left.right == null) val =  left.val;
            return val + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
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
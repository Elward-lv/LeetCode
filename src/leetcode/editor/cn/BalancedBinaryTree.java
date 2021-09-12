package leetcode.editor.cn;
//给定一个二叉树，判断它是否是高度平衡的二叉树。 
//
// 本题中，一棵高度平衡二叉树定义为： 
//
// 
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数在范围 [0, 5000] 内 
// -104 <= Node.val <= 104 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 743 👎 0


public class BalancedBinaryTree {
    public static void main(String[] args) {
        Solution solution = new BalancedBinaryTree()
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
        public boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }
            //平衡树
            //1.三个条件：第一 左右子树的高度差不能大于1   ×-不通过
            //        第二 左子树或右子树的最小和最大高度差不能大于1
            /*if(getMaxDeep(root.left) - getMaxDeep(root.right) >1) return false;
            if(getMinDeep(root.left)  - getMinDeep(root.right) > 1) return false;
            if(Math.abs(getMaxDeep(root.right) - getMinDeep(root.left)) >1) return false;
            if(Math.abs(getMaxDeep(root.left) - getMinDeep(root.right)) >1) return false;
            return true;*/
            //2.递归 判断 左右子树的高度差
            return isBalanceTree(root);
        }
        public boolean isBalanceTree(TreeNode root){
            if(root == null)  return true;
            if(Math.abs(getMaxDeep(root.left) - getMaxDeep(root.right)) >1 ) return false;
            return isBalanceTree(root.left) && isBalanceTree(root.right);
        }

        /**
         * 获取树的深度
         * @param root 节点
         * @return
         */
        public int getMaxDeep(TreeNode root){
            if(root == null){
                return 0;
            }
            return Math.max(getMaxDeep(root.left ) + 1, getMaxDeep(root.right) + 1);
        }

        /**
         * 获取树最低的”深度“
         * @param root 节点
         * @return
         */
        public int getMinDeep(TreeNode root){
            if(root == null) return 0;
            return Math.min(getMinDeep(root.left) + 1, getMinDeep(root.right) +1);
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
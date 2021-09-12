package leetcode.editor.cn;
//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// -109 <= Node.val <= 109 
// -1000 <= targetSum <= 1000 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 942 👎 0


public class PathSumIii {
    public static void main(String[] args) {
        Solution solution = new PathSumIii()
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
        private int res = 0;

        public int pathSum(TreeNode root, int targetSum) {
            /**
             * 1.我的尝试：结合上题判断是否有路径等于target，但是这样可能会漏掉其中一个子树的结果 ×
             * 2.CSNOTE：主函数递归求结果，分两种情况一种是从root开始的，另一种不从root开始    √
             *          即pathSum用来递归开始节点即可能root，也可能其他节点；pathSumStartWithRoot
             *          探索从此节点开始的所有左右分支是否含有路劲之和为目标值的分支
             */
            //1
            /*if(root == null) return 0;
            if (isPathSum(root, targetSum)) {
                res++;
            }
            pathSum(root.left, targetSum);
            pathSum(root.right, targetSum);
            return res;*/
            //2.
            if(root == null) return 0;
            int res = 0;
            res += pathSumStartWithRoot(root, targetSum)+
                    pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
            return res;
        }

        public int pathSumStartWithRoot(TreeNode root, int targetSum){
            if(root == null) return 0;
            int res = 0;
            if(root.val == targetSum) res++;
            return res + pathSumStartWithRoot(root.left, targetSum-root.val)
                    + pathSumStartWithRoot(root.right, targetSum-root.val);
        }

        public boolean isPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            if (targetSum == root.val) return true;
            return isPathSum(root.left, targetSum - root.val)
                    || isPathSum(root.right, targetSum - root.val);
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
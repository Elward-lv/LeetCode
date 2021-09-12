package leetcode.editor.cn;
//给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
//
// 注意：两个节点之间的路径长度由它们之间的边数表示。
//
// 示例 1: 
//
// 输入: 
//
// 
//              5
//             / \
//            4   5
//           / \   \
//          1   1   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 示例 2: 
//
// 输入: 
//
// 
//              1
//             / \
//            4   5
//           / \   \
//          4   4   5
// 
//
// 输出: 
//
// 
//2
// 
//
// 注意: 给定的二叉树不超过10000个结点。 树的高度不超过1000。 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 487 👎 0


public class LongestUnivaluePath {
    public static void main(String[] args) {
        Solution solution = new LongestUnivaluePath()
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
        //模仿cs-note 深度优先搜索
        private int path = 0;
        public int longestUnivaluePath(TreeNode root) {
            dfs(root);
            return path;
        }

        /**
         * 核心思想是在遍历的时候不不断更新path的最值。
         * 而且每次的递归结果不是返回0就是返回子树的最长路径，这取决于val的是否相同
         * @param root
         * @return
         */
        private int dfs(TreeNode root) {
            if(root == null) return 0;
            int leftPath = dfs(root.left);
            int rightPath = dfs(root.right);
            int left = root.left != null && root.left.val == root.val ? leftPath + 1 : 0;//下一层子树和root val相同取子树的最长路径 + 1，否则取0，即不相同直接重新从0开始计时
            int right = root.right != null && root.right.val == root.val ? rightPath + 1 : 0;
            path = Math.max(path, left + right);//如果直接返回这个结果，在网上递归的过程可能被淹没，所以需要记录最值
            return Math.max(left , right);//想一下，如果这里返回left+right的话，算什么root、left、right组成了路径（已经是围城了，不可能在拓展了），你求的是路径，所以返回左右子树的最大值
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
package leetcode.editor.cn;
//给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。 
//
// 
//
// 示例 : 
//给定二叉树 
//
//           1
//         / \
//        2   3
//       / \     
//      4   5    
// 
//
// 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。 
//
// 
//
// 注意：两结点之间的路径长度是以它们之间边的数目表示。 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 755 👎 0


public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new DiameterOfBinaryTree()
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
        private int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            //对于一部分情况这种是适用的：比如根左右子树都非空
            //但是对于其他情况的时候预测不准确了，如何在不重复遍历的基础上找到例外一个最深节点
            getDeepth(root);
            return max;
        }

        public int getDeepth(TreeNode root) {
            if (root == null) return 0;
            //1.我的思路如下
            //针对于只有单个子树的情况特殊处理，每出现一次都-2
            //虽然可以直接-2，但是当结果小于树高的时候需要取树高
            //上边这种情况也能解决部分用例，但是不能从根本 上解决问题
            //2.CS NOTE思路如下：
            int left = getDeepth(root.left);
            int right = getDeepth(root.right);
            max = Math.max(left +  right, max);//这一步可以随时比较是树高长 还是 子树的直径长度 从而更新最值
            return Math.max(left + 1, right + 1);
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
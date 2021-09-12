package leetcode.editor.cn;
//给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一
//个。 
//
// 更正式地说，root.val = min(root.left.val, root.right.val) 总成立。 
//
// 给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,2,5,null,null,5,7]
//输出：5
//解释：最小的值是 2 ，第二小的值是 5 。
// 
//
// 示例 2： 
//
// 
//输入：root = [2,2,2]
//输出：-1
//解释：最小的值是 2, 但是不存在第二小的值。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 25] 内 
// 1 <= Node.val <= 231 - 1 
// 对于树中每个节点 root.val == min(root.left.val, root.right.val) 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 220 👎 0


public class SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        Solution solution = new SecondMinimumNodeInABinaryTree()
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

        private int res = -1;

        private int top = 0;

        /**
         * 思路:
         * 1.我的：初始化记录top 为根节点、res 为 -1 ，用来记录可能的第二大的值
         *          找到大于根节点top的，并且res记录可能的第二个值
         *          开始res为-1，代表没被替代，随着左右子树出现大于top的值时，替换res为此值
         *          随后在发现比res更小但是比top大的可能值，遍历全部
         *              解答成功:
         * 			    执行耗时:0 ms,击败了100.00% 的Java用户
         * 			    内存消耗:35.8 MB,击败了28.99% 的Java用户
         * 2.CSNOTE：假设下一层已经递归完成，那么下一层第二大的值已经处理完成。
         *          我们如何利用下一层的第二大的值呢？
         *          如果均不等于-1，说明都有第二大的值，只需要返回两者之中最小值即可
         *          如果一方为-1，则返回另外一方的值即可。这种情况也可能返回-1.
         *                  解答成功:
         * 			        执行耗时:0 ms,击败了100.00% 的Java用户
         * 			        内存消耗:35.6 MB,击败了64.15% 的Java用户
         * @param root
         * @return
         */
        public int findSecondMinimumValue(TreeNode root) {
            //1.
            /*top = root.val;
            findIntenal(root);
            return res;*/
            //2.
            if (root == null) return -1;
            if (root.left == null && root.right == null) return -1;
            int leftVal = root.left.val;
            int rightVal = root.right.val;
            if (leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
            if (rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
            if (leftVal != -1 && rightVal != -1) return Math.min(leftVal, rightVal);
            if (leftVal != -1) return leftVal;
            return rightVal;
        }

        /**
         * 找到大于根节点top的，并且res记录可能的第二个值
         *  开始res为-1，代表没被替代，随着左右子树出现大于top的值时，替换res为此值
         *  随后在发现比res更小但是比top大的可能值，遍历全部
         * @param root
         * @return
         */
        private void findIntenal(TreeNode root) {
            if (root.left == null) return;
            int lval = root.left.val;
            int rval = root.right.val;
            int max = Math.max(lval, rval);
            if(max > top && (res == -1 || max < res)){
                res = max;
            }
            findIntenal(root.left);
            findIntenal(root.right);
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
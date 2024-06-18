//给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1180 👎 0


package repeat2024.leetcode.editor.cn;

import java.util.*;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
        public List<Integer> postorderTraversal(TreeNode root) {
            //1.递归实现后序遍历  如果不使用递归的话 需要自己维护栈 因为递归也是使用栈的方式保存对应的信息的 需要用栈记录所有的节点顺序信息
            List<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            //2.非递归实现
            Stack<TreeNode> stack = new Stack<>();
            Set<TreeNode> visitedNodes = new HashSet<>();
            stack.push(root);
            visitedNodes.add(root);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                if (root.left != null && !visitedNodes.contains(root.left)) {
                    stack.push(root.left);
                    visitedNodes.add(root.left);
                }
                if (root.right != null && !visitedNodes.contains(root.right)) {
                    stack.push(root.right);
                    visitedNodes.add(root.right);
                }
                result.add(node.val);
            }
            return result;
        }

        public static void dfs(TreeNode root, List<Integer> result) {
            if (root != null) {
                dfs(root.left, result);
                dfs(root.right, result);
                result.add(root.val);
            }
        }

        //leetcode submit region end(Prohibit modification and deletion)
    }
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
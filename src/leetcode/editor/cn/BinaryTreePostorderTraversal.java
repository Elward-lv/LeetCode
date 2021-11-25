package leetcode.editor.cn;
//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 710 👎 0


import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal()
                .new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        private List<Integer> ret = new ArrayList<>();

        /**
         * 1.我的： 递归
         * 2.我的： 迭代
         * 3.CSNOTE： 迭代
         * @param root
         * @return
         */
        public List<Integer> postorderTraversal(TreeNode root) {
            //1
            //postOrder(root);
            //2
            Stack<TreeNode> stack = new Stack<>();
            ArrayList<Integer> ret = new ArrayList<>();
            stack.add(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(node == null){
                    continue;
                }
                ret.add(node.val);
                stack.add(node.left);
                stack.add(node.right);
            }
            Collections.reverse(ret);
            return ret;
        }

        /**
         * 递归
         * @param root
         */
        private void postOrder(TreeNode root) {
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            ret.add(root.val);
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
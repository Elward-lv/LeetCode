package leetcode.editor.cn;
//给你二叉树的根节点 root ，返回它节点值的 前序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,2,3]
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
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[1,2]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 681 👎 0


import java.util.*;

public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePreorderTraversal()
                .new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 1.我的：递归
         * 2.CSNOTE：迭代  使用栈
         * 3.我的：迭代  使用队列  不行
         * @param root
         * @return
         */
        public List<Integer> preorderTraversal(TreeNode root) {
            //1.递归
            //preOrder(root);
            //2.迭代
            /*ArrayList<Integer> ret = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                if(node == null){
                    continue;
                }
                ret.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
            return ret;*/
            //3.queue
            ArrayList<Integer> ret = new ArrayList<>();
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node == null){
                    continue;
                }
                ret.add(node.val);
                queue.addLast(node.left);
                queue.addLast(node.right);
            }
            return ret;
        }

        /**
         * 递归算法
         * @param root
         */
        /*public void preOrder(TreeNode root){
            if(root == null){
                return;
            }
            System.out.println(root.val);
            res.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }*/
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
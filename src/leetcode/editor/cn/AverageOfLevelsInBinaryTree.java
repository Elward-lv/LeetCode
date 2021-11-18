package leetcode.editor.cn;
//给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。 
//
// 
//
// 示例 1： 
//
// 输入：
//    3
//   / \
//  9  20
//    /  \
//   15   7
//输出：[3, 14.5, 11]
//解释：
//第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
// 
//
// 
//
// 提示： 
//
// 
// 节点值的范围在32位有符号整数范围内。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 296 👎 0


import java.util.*;

public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        Solution solution = new AverageOfLevelsInBinaryTree()
                .new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 1.我的思想：层序遍历
         *          可以使用其他数据结构来帮助解题目,虽然实现了层序遍历但是如何能获取每一层的开始和结束呢？
         *          因为你过来掉了null值，所以不能使用节点的数量来计算平均值
         * 2.CSNOTE：
         * @param root
         * @return
         */
        public List<Double> averageOfLevels(TreeNode root) {
            //1
            //问题：这里为什么使用栈的话会导致结果不正确？比如（15 + 7 ）/2 = 12，但是在CSNOTE之中这个值却是11
            //破案了：原来是在先把左子树填入栈，后把右子树填入栈了，导致求平均数的数字都用错了
            ArrayList<Double> res = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if(root == null){
                return res;
            }
            stack.push(root);
            while(!stack.isEmpty()){
                int cnt = stack.size();
                double sum = 0;
                for (int i = 0; i < cnt; i++) {
                    TreeNode peek = stack.pop();
                    sum += peek.val;
                    System.out.println(peek.val);
                    if(peek.right != null) stack.push(peek.right);
                    if(peek.left != null) stack.push(peek.left);
                }
                System.out.println("sum:"+sum+", cnt:"+cnt+",res:" + sum/cnt);
                System.out.println("=================");
                res.add(sum  / cnt);
            }
            return res;
            //2
            /*List<Double> ret = new ArrayList<>();
            if (root == null) return ret;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int cnt = queue.size();
                double sum = 0;
                for (int i = 0; i < cnt; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                ret.add(sum / cnt);
            }
            return ret;*/
        }

        /**
         * 函数递归方式的层序遍历
         */
        public void levelSearch(){
            /*if(!stack.isEmpty()){
                TreeNode pop = stack.pop();
                System.out.println(pop.val);
                if(pop.right != null) stack.push(pop.right);
                if(pop.left != null) stack.push(pop.left);
                levelSearch();
            }
            return;*/
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
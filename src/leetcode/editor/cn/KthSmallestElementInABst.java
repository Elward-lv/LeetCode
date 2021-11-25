package leetcode.editor.cn;
//给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,1,4,null,2], k = 1
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：root = [5,3,6,2,4,null,null,1], k = 3
//输出：3
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 树中的节点数为 n 。 
// 1 <= k <= n <= 104 
// 0 <= Node.val <= 104 
// 
//
// 
//
// 进阶：如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化算法？ 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 528 👎 0


import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABst {
    public static void main(String[] args) {
        Solution solution = new KthSmallestElementInABst()
                .new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 1.我的：可以先中序遍历这样相当于排序，其次再筛选出第k个元素
         *          执行耗时:6 ms,击败了6.38% 的Java用户
         * 			内存消耗:39 MB,击败了25.55% 的Java用户
         *
         * 2.CSNOTE：
         *          中序：
         *                  执行耗时:0 ms,击败了100.00% 的Java用户
         * 			        内存消耗:38.2 MB,击败了64.29% 的Java用户
         * 			 递归：
         *              根据左右子树的特点，算出左右子树的节点数量，根据这个数量判断取何值
         *
         *                  执行耗时:0 ms,击败了100.00% 的Java用户
         * 			        内存消耗:38 MB,击败了92.24% 的Java用户
         * @param root
         * @param k
         * @return
         */
        //List<Integer> res = new ArrayList<>();

        private int cnt = 0;
        private int val;

        public int kthSmallest(TreeNode root, int k) {
            //1
            /*if(root == null) return 0;
            middleSearch(root);
            return res.get(k - 1);*/
            //2
            /*inOrder(root, k);
            return val;*/
            //3
            int leftCount = count(root.left);
            if(leftCount == k - 1) return root.val;
            if(leftCount > k - 1) return kthSmallest(root.left, k);
            return  kthSmallest(root.right, k - leftCount - 1);
        }

        private int count(TreeNode left) {
            if(left == null) return 0;
            return 1 + count(left.left) + count(left.right);
        }

        public void middleSearch(TreeNode root){
            //1
            /*if(root == null)
                return;
            middleSearch(root.left);
            res.add(root.val);
            middleSearch(root.right);*/
        }

        private void inOrder(TreeNode node, int k) {
            if (node == null) return;
            inOrder(node.left, k);
            cnt++;
            if (cnt == k) {
                val = node.val;
                return;
            }
            inOrder(node.right, k);
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
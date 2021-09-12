package leetcode.editor.cn;
//
// 
// 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则
//，返回 false 。 
//
// 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,4,5,1,2], subRoot = [4,1,2]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// root 树上的节点数量范围是 [1, 2000] 
// subRoot 树上的节点数量范围是 [1, 1000] 
// -104 <= root.val <= 104 
// -104 <= subRoot.val <= 104 
// 
// 
// 
// Related Topics 树 深度优先搜索 二叉树 字符串匹配 哈希函数 
// 👍 539 👎 0


import java.util.ArrayList;
import java.util.List;

public class SubtreeOfAnotherTree {
    public static void main(String[] args) {
        Solution solution = new SubtreeOfAnotherTree()
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
        //1
        private List<TreeNode> starts = new ArrayList<>();

        /**
         * 1.我的写法：先找出所有可能为子树开始节点的root节点记录下来 √
         *      执行耗时:4 ms,击败了45.16% 的Java用户
         * 			内存消耗:38.7 MB,击败了24.08% 的Java用户
         * 2.CSNOTE：不使用数据结构，直接使用递归计算。分两种情况，即是否把当前节点作为开始比较的起点
         *          --起点意思是两者的节点值相同，root的节点val和subroot根的val一致
         *              执行耗时:3 ms,击败了87.50% 的Java用户
         * 			内存消耗:38.7 MB,击败了28.35% 的Java用户
         * @param root
         * @param subRoot
         * @return
         */
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            //1
            /*
            //找到开始节点
            searchRoot(root, subRoot);
            if(starts.size() == 0) return false;
            //从开始节点开始和子树比较
            boolean res = false;
            for (TreeNode start : starts) {
                res = res | isSub(start, subRoot);
            }
            return res;*/
            //2.
            if(root == null) return false;
            return isSubtreeWithRoot(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        /**
         * 从root开始的子树，即根从此开始比较
         * @param t
         * @param s
         * @return
         */
        private boolean isSubtreeWithRoot(TreeNode t, TreeNode s) {
            if (t == null && s == null) return true;
            if (t == null || s == null) return false;
            if (t.val != s.val) return false;
            return isSubtreeWithRoot(s.left, t.left) && isSubtreeWithRoot(s.right, t.right);
        }

        /**
         * 比较两个树是否一致
         * @param root
         * @param subRoot
         * @return
         */
        public boolean isSub(TreeNode root, TreeNode subRoot){
            if(root == null && subRoot == null) return true;
            if(root == null && subRoot != null || root!=null && subRoot == null)   return false;
            boolean t = true;
            if(root.val != subRoot.val) t = false;
            return t && isSub(root.left, subRoot.left) && isSub(root.right, subRoot.right);
        }

        /**
         * 寻找开始节点
         * @param root
         * @param subRoot
         */
        public void searchRoot(TreeNode root, TreeNode subRoot){
            if(root == null) return;
            if(root.val == subRoot.val){
                starts.add(root);
            }
            searchRoot(root.left, subRoot);
            searchRoot(root.right, subRoot);
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
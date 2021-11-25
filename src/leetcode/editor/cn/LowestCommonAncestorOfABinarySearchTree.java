package leetcode.editor.cn;
//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 
// 👍 700 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LowestCommonAncestorOfABinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new LowestCommonAncestorOfABinarySearchTree()
                .new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        /**
         * 1.我的：
         *      找到节点并把找的过程之中的所有节点放入队列或者数组。其次再比较两个队列，找到最深的且相同的节点
         *      但是这样导致每次搜索的时候都会先把左数先添加进数组之中就难搞了
         *      但是又考虑到是二叉树，这样搜索就简单了，而且可以很好的区分出q p的位置
         *
         *              执行耗时:8 ms,击败了8.65% 的Java用户
         * 			内存消耗:39.4 MB,击败了31.95% 的Java用户
         * 2.CSNOTE:
         *          执行耗时:8 ms,击败了8.65% 的Java用户
         * 			内存消耗:39.2 MB,击败了62.12% 的Java用户
         * @param root
         * @param p
         * @param q
         * @return
         */
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //1.
            /*if(root == null || p == null || q == null) return null;
            //分布在左右子树
            if(q.val > root.val && p.val < root.val || q.val < root.val && p.val > root.val ||
                    p.val == root.val || q.val == root.val){
                return root;
            }
            //分布在同一个子树之上
            List<TreeNode> pArr = new ArrayList<>();
            List<TreeNode> qArr = new ArrayList<>();
            //遍历并且把路程之中的节点加入数组
            if(p.val < root.val){
                deepSearch(pArr, root.left, p);
                deepSearch(qArr, root.left, q);
            }else {
                deepSearch(pArr, root.right, p);
                deepSearch(qArr, root.right, q);
            }
            System.out.println(Arrays.toString(pArr.stream().mapToInt(node -> node.val).toArray()));
            System.out.println(Arrays.toString(qArr.stream().mapToInt(node -> node.val).toArray()));
            //比较两个数组
            int len = Math.min(pArr.size(), qArr.size());
            for (int i = 0; i < len ; i++) {
                if( pArr.get(i) != qArr.get(i)){
                    return pArr.get(i-1);
                }
            }
            return pArr.get(0);*/
            if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
            if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
            return root;
        }

        /**
         * 深度搜索
         * @param arr
         */
        public void deepSearch(List<TreeNode> arr, TreeNode root, TreeNode target){
            if(root == null) return;
            arr.add(root);
            if(root.val == target.val){
                return;
            }
            if(target.val < root.val){
                deepSearch(arr, root.left, target);
            }else {
                deepSearch(arr, root.right, target);
            };
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
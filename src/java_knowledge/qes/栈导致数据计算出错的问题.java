package java_knowledge.qes;

import leetcode.editor.cn.AverageOfLevelsInBinaryTree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * (15 + 7 ) / 2  = 22 / 2 = 11
 * 这里可见不是栈的问题，估计是数据传输之中double精度的问题;
 * 那为什么使用queue的时候代码类似却没有出现类似的问题呢？
 * @see leetcode.editor.cn.AverageOfLevelsInBinaryTree
 * @Author: lvyanwei
 * @Date: 2021-11-18
 */
public class 栈导致数据计算出错的问题 {
    public static void main(String[] args) {
        AverageOfLevelsInBinaryTree.TreeNode left = new AverageOfLevelsInBinaryTree.TreeNode(15);
        AverageOfLevelsInBinaryTree.TreeNode right = new AverageOfLevelsInBinaryTree.TreeNode(7);
        AverageOfLevelsInBinaryTree.TreeNode root = new AverageOfLevelsInBinaryTree.TreeNode(3, left, right);

        Stack<AverageOfLevelsInBinaryTree.TreeNode> stack = new Stack<>();
        ArrayList<Double> res = new ArrayList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            int cnt = stack.size();
            double sum = 0;
            for (int i = 0; i < cnt; i++) {
                AverageOfLevelsInBinaryTree.TreeNode peek = stack.pop();
                sum += peek.val;
                if(peek.left != null) stack.push(peek.left);
                if(peek.right != null) stack.push(peek.right);
            }
            res.add(sum  / cnt);
        }
        System.out.println(res);
    }
}

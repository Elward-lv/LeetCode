//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 2155 👎 0


package repeat2024.leetcode.editor.cn;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode l1 = new ListNode();
        ListNode l2 = new ListNode();
        ListNode l3 = new ListNode();
        ListNode l4 = new ListNode();
        l1.val =1;
        l1.next = l2;
        l2.val =2;
        l2.next = l3;
        l3.val =3;
        l3.next = l4;
        l4.val =4;
        Solution solution = new SwapNodesInPairs().new Solution();
        solution.swapPairs(l1);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
     class Solution {
        public ListNode swapPairs(ListNode head) {
            //1.迭代试试  index为需要交换的元素的前者 next为后者  pre为可能index之前的元素 交换指针即可
            /*ListNode index = head;
            ListNode pre = null;
            ListNode res = null;
            if(index == null || index.next == null){
                return head;
            }
            while (index != null && index.next != null){
                System.out.println(index != null ? index.val : null);
                ListNode next = index.next;
                if(res == null){
                    res = next;
                }
                if(pre != null){
                    pre.next = next;
                }
                index.next = index.next.next;
                next.next = index;
                pre = index;
                index = index.next;
            }
            return res;*/
            //2.递归实现  简单的嘞
            if(head == null || head.next == null){
                return head;
            }
            ListNode two = head.next;
            ListNode three = swapPairs(two.next);
            two.next = head;
            head.next = three;
            return two;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
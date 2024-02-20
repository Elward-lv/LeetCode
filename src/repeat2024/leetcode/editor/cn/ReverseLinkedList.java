//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
//
// 
// 
// 
// 
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
//
// Related Topics 递归 链表 👍 3501 👎 0


package repeat2024.leetcode.editor.cn;


import java.util.Stack;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedList().new Solution();
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
        public ListNode reverseList(ListNode head) {
            //堆栈实现
            /*Stack<ListNode> nodeStack = new Stack<>();
            ListNode a = head;
            while (a != null){
                nodeStack.push(a);
                a = a.next;
            }
            ListNode res = null;
            ListNode index = null;
            while (!nodeStack.isEmpty()){
                ListNode pop = nodeStack.pop();
                if(res == null){
                    res = pop;
                }
                if(index != null){
                    index.next = pop;
                }
                index = pop;
                index.next = null;
            }
            return res;*/
            //双指针
            ListNode current = null;
            ListNode front = null;
            ListNode next = null;
            if(head != null){
                current = head;
                next = head.next;
            }
            while (current != null){
                //断掉current和next current.next指向front
                current.next = front;
                front = current;
                current = next;
                if(next != null){
                    next = next.next;
                }
            }
            return front;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
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
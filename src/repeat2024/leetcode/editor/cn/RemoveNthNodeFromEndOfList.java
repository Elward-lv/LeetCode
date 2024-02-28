//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// Related Topics 链表 双指针 👍 2814 👎 0


package repeat2024.leetcode.editor.cn;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
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
        public ListNode removeNthFromEnd(ListNode head, int n) {
            //1.倒数转化成正数 使用堆栈或者数组计算链表的长度  或者 直接遍历一遍也行
            /*if(head == null){
                return head;
            }
            ListNode index = head;
            int len = 0;
            while (index != null){
                index = index.next;
                len ++;
            }
            System.out.println(len);
            ListNode indexPre = null;
            index = head;
            int pos = len - n;
            while (pos > 0){
                indexPre = index;
                index = index.next;
                pos --;
            }
            if(index == head){
                return head.next;
            }else {
                indexPre.next = index.next;
            }
            return head;*/
            //2.双指针（看答案的）：具体地，初始时 first\textit{first}first 和 second\textit{second}second 均指向头节点。我们首先使用 first\textit{first}first 对链表进行遍历，遍历的次数为 nnn。此时，first\textit{first}first 和 second\textit{second}second 之间间隔了 n−1n-1n−1 个节点，即 first\textit{first}first 比 second\textit{second}second 超前了 nnn 个节点。
            //在这之后，我们同时使用 first\textit{first}first 和 second\textit{second}second 对链表进行遍历。当 first\textit{first}first 遍历到链表的末尾（即 first\textit{first}first 为空指针）时，second\textit{second}second 恰好指向倒数第 nnn 个节点。
            //执行耗时:0 ms,击败了100.00% 的Java用户
            ListNode fast = head;
            while (n > 0){
                fast = fast.next;
                n --;
            }
            if(fast == null){return head.next;}
            ListNode slow = head;
            while (fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }
            slow.next = slow.next.next;
            return head;
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
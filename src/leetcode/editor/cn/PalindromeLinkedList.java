package leetcode.editor.cn;
//请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 链表 双指针 
// 👍 833 👎 0


import java.util.LinkedList;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList()
                .new Solution();

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
        /**
         * 思路：
         * 1.普通。
         *      执行耗时:4 ms,击败了31.23% 的Java用户
         * 		内存消耗:42.3 MB,击败了24.79% 的Java用户
         * 2.进阶。你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？一个找链表中点的方法
         *          切成两半，把后半段反转，然后比较两半是否相等。
         *             执行耗时:1 ms,击败了99.96% 的Java用户
         * 			内存消耗:40.9 MB,击败了84.68% 的Java用户
         * @param head
         * @return
         */
        public boolean isPalindrome(ListNode head) {
            /*
            //1.
            LinkedList<Integer> stack = new LinkedList<>();
            ListNode index = head;
            while (index != null){
                stack.push(index.val);
                index = index.next;
            }
            //judge the 回文
            while (!stack.isEmpty()){
                if(stack.pop() != head.val){
                    return false;
                }
                head = head.next;
            }
            return true;*/
            //2.
            if(head == null || head.next == null) return true;
            ListNode slow = head , fast = head.next;
            while (fast != null && fast.next != null ){
                slow = slow.next;
                fast = fast.next.next;
            }
            if(fast != null){
                slow = slow.next;
            }
            cut(head , slow);

            return isEqual(head, reverse(slow));
        }

        private void cut(ListNode head, ListNode cutNode) {
            while (head.next != cutNode) {
                head = head.next;
            }
            head.next = null;
        }

        private ListNode reverse(ListNode head) {
            ListNode newHead = null;
            while (head != null) {
                ListNode nextNode = head.next;
                head.next = newHead;
                newHead = head;
                head = nextNode;
            }
            return newHead;
        }

        private boolean isEqual(ListNode l1, ListNode l2) {
            while (l1 != null && l2 != null) {
                if (l1.val != l2.val) return false;
                l1 = l1.next;
                l2 = l2.next;
            }
            return true;
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
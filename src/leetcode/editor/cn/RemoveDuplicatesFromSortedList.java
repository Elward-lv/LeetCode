package leetcode.editor.cn;
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 456 👎 0


public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList()
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
         * 1.迭代法。通过指针来记录，正在遍历的node，两个指针分别记录元素开始和结束时的位置，最后只需要调整指针即可。
         *      执行耗时:1 ms,击败了33.35% 的Java用户
         * 			内存消耗:37.9 MB,击败了59.05% 的Java用户
         * 2.递归
         *      执行耗时:0 ms,击败了100.00% 的Java用户
         * 			内存消耗:38 MB,击败了31.98% 的Java用户
         * @param head
         * @return
         */
        public ListNode deleteDuplicates(ListNode head) {
           /* //1.
            if(head == null || head.next == null) return head;
            ListNode index = head.next;
            ListNode end = head;
            ListNode start = head;
            while (index != null ){
                if( index.val == start.val ){
                    end = index;
                }else {
                    if( start != end ){
                        start.next = index;
                    }
                    start = index;
                    end = index;
                }
                index = index.next;
            }
            if( start != end ){
                start.next = index;
            }
            return head;*/

           //2.递归
            if(head == null || head.next == null) return head;
            head.next = deleteDuplicates(head.next);
            return head.val == head.next.val ? head.next : head;
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
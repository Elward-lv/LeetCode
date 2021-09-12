package leetcode.editor.cn;
//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1457 👎 0


import java.util.List;

public class ReverseLinkedList{
        public static void main(String[] args){
            Solution solution = new ReverseLinkedList()
            .new Solution();
            
        }
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * 思路
     * 1.利用三个指针进行移动--迭代
     * 2.递归
     * 3.
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //1.迭代
        /*if( head == null || head.next == null ) return  head;
        ListNode left = null;
        ListNode index = head;
        ListNode right = head.next;
        while ( index != null ){
            index.next = left;
            left = index;
            index = right;
            if(right != null) right = right.next;
        }

        return left;*/

        //2.递归---较难理解
        //思想：我子节点下的所有节点都已经反转好了，现在就剩我和我的子节点
        // 没有完成最后的反转了，所以反转一下我和我的子节点。
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
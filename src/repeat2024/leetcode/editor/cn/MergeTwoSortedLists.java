//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 3442 👎 0


package repeat2024.leetcode.editor.cn;

import java_knowledge.对象为NULL对静态方法的影响;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        ListNode nodeA1 = new ListNode();
        nodeA1.val = 1;
        ListNode nodeA2 = new ListNode();
        nodeA2.val = 2;
        ListNode nodeA3 = new ListNode();
        nodeA3.val = 4;
        nodeA1.next = nodeA2;
        nodeA2.next = nodeA3;
        ListNode nodeB1 = new ListNode();
        nodeB1.val = 1;
        ListNode nodeB2 = new ListNode();
        nodeB2.val = 3;
        ListNode nodeB3 = new ListNode();
        nodeB3.val = 4;
        nodeB1.next = nodeB2;
        nodeB2.next = nodeB3;
        solution.mergeTwoLists(nodeA1, nodeB1);
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            //迭代  优化：可以初始化一个无用节点  结果取next即可
            /*ListNode head = null;
            ListNode next = null;
            ListNode nextA = list1;
            ListNode nextB = list2;
            while (nextA != null || nextB != null){
                if(nextA == null){
                    if (next != null){
                        next.next = nextB;
                    }else {
                        next = nextB;
                    }
                    if(head == null){
                        head = next;
                    }
                    break;
                }else if(nextB == null){
                    if (next != null){
                        next.next = nextA;
                    }else {
                        next = nextA;
                    }
                    if(head == null){
                        head = next;
                    }
                    break;
                }
                //迭代
                if (nextA.val >= nextB.val) {
                    if(next != null){
                        next.next = nextB;
                        next = next.next;
                        nextB = nextB.next;
                    }else {
                        next = nextB;
                        nextB = nextB.next;
                    }
                }else {
                    if(next != null){
                        next.next = nextA;
                        next = next.next;
                        nextA = nextA.next;
                    }else {
                        next = nextA;
                        nextA = nextA.next;
                    }
                }
                if(head == null){
                    head = next;
                }
            }
            return head;*/
            //2.递归 直接抄的
            if (list1 == null) {
                return list2;
            } else if (list2 == null) {
                return list1;
            } else if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
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
package leetcode.editor.cn;
//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
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
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 790 👎 0


public class SwapNodesInPairs {
    /**
     * 思路：
     * 1.迭代方法(我的)。 通过几个指针的移动完成迭代。
     *      执行耗时:23 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.7 MB,击败了5.07% 的Java用户
     * 2.迭代方法(leetcode)。
     *
     * 3.递归方法。递归的终止条件是链表中没有节点，或者链表中只有一个节点，此时无法进行交换。
     *      如果链表中至少有两个节点，则在两两交换链表中的节点之后，原始链表的头节点变成新的链表的第二个节点，原始链表的第二个节点变成新的链表的头节点。链表中的其余节点的两两交换可以递归地实现。在对链表中的其余节点递归地两两交换之后，更新节点之间的指针关系，即可完成整个链表的两两交换。
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs()
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
        public ListNode swapPairs(ListNode head) {
            /*//1
            if (head == null || head.next == null) return head;
            ListNode front = new ListNode(-1);
            front.next = head;
            ListNode re = head.next;
            ListNode index = head.next;
            ListNode temp = null;
            int count = 2;
            while (index != null) {
                if (count == 2) {
                    count = 1;
                    temp = index.next;
                    index.next = front.next;
                    front.next.next = temp;
                    front.next = index;
                    System.out.print(front.val + "," + index.val+","+(temp == null ? temp : temp.val));
                    front = index.next;

                    index = temp;
                }
                count++;
                if(index!= null) index = index.next;
                System.out.println(": count "+count);
            }
            return re;*/
            //3
            if (head == null || head.next == null) {
                return head;
            }
            ListNode newHead = head.next;
            head.next = swapPairs(newHead.next);
            newHead.next = head;
            return newHead;

            /**
             * //2
             * ListNode dummyHead = new ListNode(0);
             *         dummyHead.next = head;
             *         ListNode temp = dummyHead;
             *         while (temp.next != null && temp.next.next != null) {
             *             ListNode node1 = temp.next;
             *             ListNode node2 = temp.next.next;
             *             temp.next = node2;
             *             node1.next = node2.next;
             *             node2.next = node1;
             *             temp = node1;
             *         }
             *         return dummyHead.next;
             *
             */
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
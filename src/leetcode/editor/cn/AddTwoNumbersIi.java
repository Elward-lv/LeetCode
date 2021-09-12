package leetcode.editor.cn;
//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 进阶： 
//
// 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。 
//
// 
//
// 示例： 
//
// 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 8 -> 0 -> 7
// 
// Related Topics 链表 
// 👍 324 👎 0


import java.util.LinkedList;

public class AddTwoNumbersIi {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi()
                .new Solution();

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        /**
         * 思路：
         * 1.反转链表或者使用栈来达到计算的目的
         *          执行耗时:4 ms,击败了75.27% 的Java用户
         * 			内存消耗:38.6 MB,击败了90.85% 的Java用户
         * 2.开始计算链表的长度，即数字的位数，其次相加即可。
         * 肯定是可行的，但是首先计算长度，其次整数相加，
         * 最后整数转链表还需要创建新的节点（这点虽然不可避免，
         * 但是可以利用已经存在的节点），内存消耗是很大的，所以选择第一步
         * 3.进阶：不能修改原始链表！可以把节点之中的数字入栈，其后根据数字新建并重新链接节点。
         *  思路和1类似，代码上可以进行优化。
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int low = 0;
            ListNode head = new ListNode(-1);
            LinkedList<ListNode> stack1 = getStack(l1);
            LinkedList<ListNode> stack2 = getStack(l2);
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                ListNode n1 = stack1.pop();
                ListNode n2 = stack2.pop();
                //插入队首，head之后
                putTheNodeAfterHead(head, n1);

                int current = n1.val + n2.val + low;
                low = current / 10;
                n1.val = current % 10;
            }

            while (!stack1.isEmpty()) {
                putTheNodeAfterHead(head, stack1.pop());
                if (low != 0) {
                    int current = head.next.val + low;
                    head.next.val = current % 10;
                    low = current / 10;
                }
            }
            while (!stack2.isEmpty()) {
                putTheNodeAfterHead(head, stack2.pop());
                if (low != 0) {
                    int current = head.next.val + low;
                    head.next.val = current % 10;
                    low = current / 10;
                }
            }

            if (low > 0) {
                ListNode node = new ListNode(low);
                putTheNodeAfterHead(head, node);
            }
            return head.next;
        }

        public LinkedList<ListNode> getStack(ListNode l) {
            LinkedList<ListNode> stack = new LinkedList<ListNode>();
            while (l != null) {
                stack.push(l);
                ListNode next = l.next;
                l.next = null;
                l = next;
            }
            return stack;
        }

        public void putTheNodeAfterHead(ListNode head, ListNode temp) {
            ListNode next = head.next;
            head.next = temp;
            temp.next = next;
        }

        /**
         * //3.
         * public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         *     Stack<Integer> l1Stack = buildStack(l1);
         *     Stack<Integer> l2Stack = buildStack(l2);
         *     ListNode head = new ListNode(-1);
         *     int carry = 0;
         *     while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
         *         int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
         *         int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
         *         int sum = x + y + carry;
         *         ListNode node = new ListNode(sum % 10);
         *         node.next = head.next;
         *         head.next = node;
         *         carry = sum / 10;
         *     }
         *     return head.next;
         * }
         *
         * private Stack<Integer> buildStack(ListNode l) {
         *     Stack<Integer> stack = new Stack<>();
         *     while (l != null) {
         *         stack.push(l.val);
         *         l = l.next;
         *     }
         *     return stack;
         * }
         */
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
package leetcode.editor.cn;
//给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。 
//
// 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。 
//
// 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。 
//
// 返回一个符合上述规则的链表的列表。 
//
// 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ] 
//
// 示例 1： 
//
// 
//输入: 
//root = [1, 2, 3], k = 5
//输出: [[1],[2],[3],[],[]]
//解释:
//输入输出各部分都应该是链表，而不是数组。
//例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.ne
//xt.next.next = null。
//第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
//最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
// 
//
// 示例 2： 
//
// 
//输入: 
//root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
//输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
//解释:
//输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
// 
//
// 
//
// 提示: 
//
// 
// root 的长度范围： [0, 1000]. 
// 输入的每个节点的大小范围：[0, 999]. 
// k 的取值范围： [1, 50]. 
// 
//
// 
// Related Topics 链表 
// 👍 115 👎 0


public class SplitLinkedListInParts {
    public static void main(String[] args) {
        Solution solution = new SplitLinkedListInParts()
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
         * 1.计算链表长度和k的关系，随后确定数组中每个链表的长度，从哪测无所谓，只要确定了关系即可。如几个n/k，几个n/k +1
         *      执行耗时:9 ms,击败了13.18% 的Java用户
         * 			内存消耗:38.7 MB,击败了27.37% 的Java用户
         * 2.leetcode 写法，思想差不多。只是循环的条件不同，他用链表的个数作为循环的条件，
         *      随后通过指针下移并计数完成小链表的赋值，即可。
         *          执行耗时:0 ms,击败了100.00% 的Java用户
         * 			内存消耗:38.8 MB,击败了10.68% 的Java用户
         * @param root
         * @param k
         * @return
         */
        public ListNode[] splitListToParts(ListNode root, int k) {
            /*
            //1.
            ListNode[] res = new ListNode[k];
            //null的处理情况
            if( root == null ) return res;
            ListNode index = root;
            //make sure of the len and the member‘s len in the array
            int len = 1;
            while (index.next != null){
                len++;
                index = index.next;
            }

            int small = len / k;//小链表的节点数  len 4  k 2  -> 2
            int bigNum = len % k;//大链表的个数          0
            int smallNum = k - bigNum;//小链表的个数     2
            System.out.println(smallNum + ","+bigNum);

            int i = 1, id = 0 , bigCount = 0 ,  smallCount = 0;
            boolean flag = true;//到达新的链表
            while (root != null){
                ListNode next = root.next;
                if(flag){//flag of change the member of the array
                    res[id] = root;
                    flag = false;
                }
                //先填充大链表
                if(bigCount < bigNum){
                    if(i < small + 1){
                        i++;
                    }else {//到达每个链表的结尾
                        i = 1;
                        root.next = null;
                        id ++;
                        bigCount++;
                        flag = true;
                    }
                }else if(smallCount < smallNum){
                    if( i < small ){
                        i++;
                    }else {
                        i = 1;
                        root.next = null;
                        id ++;
                        smallCount++;
                        flag = true;
                    }
                }
                root = next;
            }
            return res;*/
            //2.
            int N = 0;
            ListNode cur = root;
            while (cur != null) {
                N++;
                cur = cur.next;
            }
            int mod = N % k;
            int size = N / k;
            ListNode[] ret = new ListNode[k];
            cur = root;
            for (int i = 0; cur != null && i < k; i++) {
                ret[i] = cur;
                int curSize = size + (mod-- > 0 ? 1 : 0);
                for (int j = 0; j < curSize - 1; j++) {
                    cur = cur.next;
                }
                ListNode next = cur.next;
                cur.next = null;
                cur = next;
            }
            return ret;
        }
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
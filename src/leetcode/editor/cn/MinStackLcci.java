package leetcode.editor.cn;
//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(
//1)。 示例： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
// minStack.push(-3); minStack.getMin();   --> 返回 -3. minStack.pop(); minStack.top
//();      --> 返回 0. minStack.getMin();   --> 返回 -2. Related Topics 栈 
// 👍 37 👎 0


import java.util.LinkedList;

public class MinStackLcci {
    public static void main(String[] args) {
        MinStack solution = new MinStackLcci()
                .new MinStack();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        /**
         * 思路：1.可以通过两个栈的方式来完成，一个记录入栈的元素，另外一个栈记录每次入栈时的最小值
         * 执行耗时:23 ms,击败了44.43% 的Java用户
         * 内存消耗:40.4 MB,击败了13.37% 的Java用户
         *       2.自定义数据结构。节点之中保存每个数据对应的min
         *       3.用一个栈，不过进行两次压栈，一次压栈是数据，一次压栈是最min值
         */
        LinkedList<Integer> values = null;
        LinkedList<Integer> mins = null;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            values = new LinkedList<Integer>();
            mins = new LinkedList<Integer>();
        }

        public void push(int x) {
            values.push(x);
            if (!mins.isEmpty() && mins.peek() < x) {
                mins.push(mins.peek());
            } else {
                mins.push(x);
            }
        }

        public void pop() {
            values.pop();
            mins.pop();
        }

        public int top() {
            return values.peek();
        }

        public int getMin() {
            return mins.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
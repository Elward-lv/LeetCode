package leetcode.editor.cn;
//使用队列实现栈的下列操作： 
//
// 
// push(x) -- 元素 x 入栈 
// pop() -- 移除栈顶元素 
// top() -- 获取栈顶元素 
// empty() -- 返回栈是否为空 
// 
//
// 注意: 
//
// 
// 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合
//法的。 
// 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。 
// 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。 
// 
// Related Topics 栈 设计 
// 👍 261 👎 0


import java.util.LinkedList;

public class ImplementStackUsingQueues{
        public static void main(String[] args){
            MyStack myStack = new ImplementStackUsingQueues().new MyStack();
            myStack.push(1);
            myStack.push(2);
            myStack.push(3);
            System.out.println(myStack.top());
            System.out.println(myStack.pop());
            System.out.println(myStack.top());
            System.out.println(myStack.pop());
            System.out.println(myStack.top());
            System.out.println(myStack.empty());
            System.out.println(myStack.pop());
            System.out.println(myStack.empty());//right res :[null,null,null,null,3,3,2,2,1,false,1,true]
        }
        //leetcode submit region begin(Prohibit modification and deletion)
class MyStack {
            LinkedList<Integer> queue = null;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        /**
         * 重新排列queue
         */
        int size = queue.size();
        if( size == 1 ){
            return queue.poll();
        }
        //resize the queue
        for ( int i = 0 ; i < size -1 ; i++ ){
            queue.offer(queue.poll());
        }
        return queue.poll();
    }
    
    /** Get the top element. */
    public int top() {
        int size = queue.size();
        if( size == 1 ){
            return queue.peek();
        }
        int res = 0 ;
        for (int i = 0; i < size; i++) {
            if( i == size -1 ){
                res = queue.peek();
            }
            queue.offer(queue.poll());
        }
        return res;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
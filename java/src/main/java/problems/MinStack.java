package problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/min-stack/description/

 * algorithms
 * Easy (31.08%)
 * Total Accepted:    182.2K
 * Total Submissions: 584.4K
 * Testcase Example:  '["MinStack","push","push","push","getMin","pop","top","getMin"]\n[[],[-2],[0],[-3],[],[],[],[]]'


 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.


 push(x) -- Push element x onto stack.


 pop() -- Removes the element on top of the stack.


 top() -- Get the top element.


 getMin() -- Retrieve the minimum element in the stack.




 Example:

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.
 */

public class MinStack {
    private Stack<Integer> values = new Stack<>();
    private int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        values.push(min);

        if (x < min) {
            min = x;
        }

        values.push(x);
    }

    public void pop() {
        values.pop();
        min = values.pop();
    }

    public int top() {
        return values.peek();
    }

    public int getMin() {
        return min;
    }
}

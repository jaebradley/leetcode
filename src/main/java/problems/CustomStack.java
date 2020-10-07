package problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/design-a-stack-with-increment-operation/
 *
 * Design a stack which supports the following operations.
 *
 * Implement the CustomStack class:
 *
 * CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack or do nothing if the stack reached the maxSize.
 * void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
 * int pop() Pops and returns the top of stack or -1 if the stack is empty.
 * void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, just increment all the elements in the stack.
 *
 *
 * Example 1:
 *
 * Input
 * ["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
 * [[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
 * Output
 * [null,null,null,2,null,null,null,null,null,103,202,201,-1]
 * Explanation
 * CustomStack customStack = new CustomStack(3); // Stack is Empty []
 * customStack.push(1);                          // stack becomes [1]
 * customStack.push(2);                          // stack becomes [1, 2]
 * customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
 * customStack.push(2);                          // stack becomes [1, 2]
 * customStack.push(3);                          // stack becomes [1, 2, 3]
 * customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
 * customStack.increment(5, 100);                // stack becomes [101, 102, 103]
 * customStack.increment(2, 100);                // stack becomes [201, 202, 103]
 * customStack.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
 * customStack.pop();                            // return 202 --> Return top of the stack 102, stack becomes [201]
 * customStack.pop();                            // return 201 --> Return top of the stack 101, stack becomes []
 * customStack.pop();                            // return -1 --> Stack is empty return -1.
 *
 *
 * Constraints:
 *
 * 1 <= maxSize <= 1000
 * 1 <= x <= 1000
 * 1 <= k <= 1000
 * 0 <= val <= 100
 * At most 1000 calls will be made to each method of increment, push and pop each separately.
 *
 * Approach:
 *
 * 1. Keep track of "adjustments" in an array that has a size equal to the max size of the stack
 * 2. Each index in this "adjustments" array represents the adjustments to the original values of the values
 *    from index 0 to X
 * 3. When a value is pushed to the stack, the adjustments array obviously won't apply to it (since adjustments
 *    are applied to the values at the bottom of the stack upwards)
 * 4. When a value is popped from the stack, the adjustments array value at that index is applied to the original value -
 *    this represents the "final" value after all the increment operations
 * 5. When popping a value, set the adjustment value of the index of the value that is being popped to 0 and
 *    add the current adjustment value to the adjustment of the previous index
 * 6. This basically "rolls over" the total increment operations up to that point to the next element at the top of the stack
 *    and keeps both the increment and pop operations O(1)
 */

public class CustomStack {
    private final int maxSize;
    private final Stack<Integer> values;
    private final int[] incrementValues;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        this.values = new Stack<>();
        this.incrementValues = new int[maxSize];
    }

    public void push(int x) {
        if (this.values.size() < this.maxSize) {
            this.values.push(x);
        }
    }

    public int pop() {
        if (this.values.isEmpty()) {
            return -1;
        }

        int size = this.values.size();
        int incrementAdjustment = this.incrementValues[size - 1];

        if (size > 1) {
            this.incrementValues[size - 2] += incrementAdjustment;
        }

        this.incrementValues[size - 1] = 0;
        return this.values.pop() + incrementAdjustment;
    }

    public void increment(int k, int val) {
        if (!this.values.isEmpty()) {
            this.incrementValues[Math.min(this.values.size(), k) - 1] += val;
        }
    }
}

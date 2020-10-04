package problems;

import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of the queue.
 * pop() -- Removes the element from in front of the queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Notes:
 *
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, the stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 *
 *
 * Example 1:
 *
 * Input
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * Output
 * [null, null, null, 1, 1, false]
 *
 * Explanation
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1);
 * myQueue.push(2);
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1
 * myQueue.empty(); // return False
 *
 * Approach:
 *
 * 1. push values onto a stack
 * 2. when these values need to be read / popped, pop them from the "input" or "push" stack and push them onto the "pop"
 *    or "output" stack.
 * 3. Because they are pushed to the output stack, they are now in the "correct" queue order (i.e. the opposite of the
 *    existing / input stack order)
 */

public class ImplementQueueUsingStacks {
    public static class MyQueue {
        private final Stack<Integer> pushStack;
        private final Stack<Integer> popStack;

        /** Initialize your data structure here. */
        public MyQueue() {
            pushStack = new Stack<>();
            popStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            pushStack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            peek();
            return popStack.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (popStack.isEmpty()) {
                while (!pushStack.isEmpty()) {
                    popStack.push(pushStack.pop());
                }
            }
            return popStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return pushStack.isEmpty() && popStack.isEmpty();
        }
    }
}

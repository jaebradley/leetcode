package problems;


import org.junit.Test;
import problems.ImplementQueueUsingStacks.MyQueue;

import static org.junit.Assert.*;

public class ImplementQueueUsingStacksTest {
    @Test
    public void testSinglePushCanPeekCorrectValue() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        assertEquals(1, queue.peek());
    }

    @Test
    public void testDoublePushCanPeekCorrectValue() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        assertEquals(1, queue.peek());
    }

    @Test
    public void testSinglePushPopCorrectValue() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        assertEquals(1, queue.pop());
    }

    @Test
    public void testDoublePushDoublePopCorrectValues() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        assertEquals(1, queue.pop());
        assertEquals(2, queue.pop());
    }

    @Test
    public void testEmptyQueueIsEmpty() {
        MyQueue queue = new MyQueue();
        assertTrue(queue.empty());
    }

    @Test
    public void testPushIsNonEmptyQueue() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        assertFalse(queue.empty());
    }

    @Test
    public void testPushPopIsEmptyQueue() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.pop();
        assertTrue(queue.empty());
    }
}

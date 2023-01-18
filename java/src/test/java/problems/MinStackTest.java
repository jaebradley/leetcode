package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinStackTest {

    @Test
    public void testPushPopTopGetMin() {
        MinStack stack = new MinStack();
        stack.push(-2);
        stack.push(0);

        assertEquals(-2, stack.getMin());
        assertEquals(0, stack.top());

        stack.push(-3);

        assertEquals(-3, stack.getMin());
        assertEquals(-3, stack.top());

        stack.pop();

        assertEquals(-2, stack.getMin());
        assertEquals(0, stack.top());

        stack.pop();

        assertEquals(-2, stack.getMin());
        assertEquals(-2, stack.top());
    }

    @Test
    public void anotherTestPushPopTopGetMin() {
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        assertEquals(0, stack.getMin());

        stack.pop();

        assertEquals(0, stack.getMin());
    }
}
package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomStackTest {

    @Test
    public void testPushingMaxNumberOfEntries() {
        try {
            CustomStack stack = new CustomStack(3);
            stack.push(1);
            stack.push(2);
            stack.push(3);
        } catch (Exception e) {
            fail("Should not throw exception when pushing max number of entries");
        }
    }

    @Test
    public void testPushingMoreThanMaxNumberOfEntries() {
        try {
            CustomStack stack = new CustomStack(3);
            stack.push(1);
            stack.push(2);
            stack.push(3);
            stack.push(4);
        } catch (Exception e) {
            fail("Should not throw exception when pushing max number of entries");
        }
    }

    @Test
    public void testPoppingPushedMoreThanNumberOfEntries() {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testPoppingEmptyStackReturnsNegativeOne() {
        assertEquals(-1, new CustomStack(3).pop());
    }

    @Test
    public void testIncrementingEmptyStackDoesNotApplyIncrementOperation() {
        CustomStack stack = new CustomStack(3);
        stack.increment(3, 10);
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test
    public void testIncrementThenPushDoesNotIncrementLastPushedValue() {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        stack.increment(2, 10);
        stack.push(3);
        assertEquals(3, stack.pop());
    }

    @Test
    public void testIncrementThenPushDoesNotIncrementLastPushedValueButIncrementsOtherValues() {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        stack.increment(2, 10);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(12, stack.pop());
        assertEquals(11, stack.pop());
    }

    @Test
    public void testMultipleIncrementOperations() {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.increment(3, 10);
        stack.increment(3, 2);
        assertEquals(15, stack.pop());
        assertEquals(14, stack.pop());
        assertEquals(13, stack.pop());
    }

    @Test
    public void testIncrementSubsetOfValues() {
        CustomStack stack = new CustomStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.increment(1, 10);
        stack.increment(2, 2);
        assertEquals(3, stack.pop());
        assertEquals(4, stack.pop());
        assertEquals(13, stack.pop());

    }
}
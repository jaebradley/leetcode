package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyCircularDequeTest {

    @Test
    public void testSuccessfulInsertToFrontOfEmptyDeque() {
        assertTrue(new MyCircularDeque(10).insertFront(1));
    }

    @Test
    public void testFailedInsertToFrontOfEmptyDequeWhenCapacityIs0() {
        assertFalse(new MyCircularDeque(0).insertFront(1));
    }

    @Test
    public void testFailedInsertASecondTimeWhenCapacityIs1() {
        MyCircularDeque deque = new MyCircularDeque(1);
        assertTrue(deque.insertFront(1));
        assertFalse(deque.insertFront(2));
    }

    @Test
    public void testSuccessfulInsertHasCorrectFrontValue() {
        MyCircularDeque deque = new MyCircularDeque(1);
        deque.insertFront(1);
        assertEquals(1, deque.getFront());
    }

    @Test
    public void testSuccessfulInsertHasCorrectBackValue() {
        MyCircularDeque deque = new MyCircularDeque(1);
        deque.insertFront(1);
        assertEquals(1, deque.getRear());
    }

    @Test
    public void testFailedInsertASecondTimeWhenCapacityIs1HasCorrectFrontValue() {
        MyCircularDeque deque = new MyCircularDeque(1);
        deque.insertFront(1);
        deque.insertFront(2);
        assertEquals(1, deque.getFront());
    }

    @Test
    public void testFailedInsertASecondTimeWhenCapacityIs1HasCorrectBackValue() {
        MyCircularDeque deque = new MyCircularDeque(1);
        deque.insertFront(1);
        deque.insertFront(2);
        assertEquals(1, deque.getRear());
    }

    @Test
    public void testSuccessfulInsertToLastOfEmptyDeque() {
        assertTrue(new MyCircularDeque(10).insertLast(1));
    }

    @Test
    public void testFailedInsertToLastOfEmptyDequeWhenCapacityIs0() {
        assertFalse(new MyCircularDeque(0).insertLast(1));
    }

    @Test
    public void testFailedInsertLastASecondTimeWhenCapacityIs1() {
        MyCircularDeque deque = new MyCircularDeque(1);
        assertTrue(deque.insertLast(1));
        assertFalse(deque.insertLast(2));
    }

    @Test
    public void testSuccessfulInsertLastHasCorrectLastValue() {
        MyCircularDeque deque = new MyCircularDeque(1);
        deque.insertLast(1);
        assertEquals(1, deque.getRear());
    }

    @Test
    public void testSuccessfulInsertLastHasCorrectBackValue() {
        MyCircularDeque deque = new MyCircularDeque(1);
        deque.insertLast(1);
        assertEquals(1, deque.getRear());
    }

    @Test
    public void testFailedInsertLastASecondTimeWhenCapacityIs1HasCorrectLastValue() {
        MyCircularDeque deque = new MyCircularDeque(1);
        deque.insertLast(1);
        deque.insertLast(2);
        assertEquals(1, deque.getRear());
    }

    @Test
    public void testFailedInsertLastASecondTimeWhenCapacityIs1HasCorrectBackValue() {
        MyCircularDeque deque = new MyCircularDeque(1);
        deque.insertLast(1);
        deque.insertLast(2);
        assertEquals(1, deque.getRear());
    }

    @Test
    public void testDeleteFrontForEmptyListIsFalse() {
        assertFalse(new MyCircularDeque(1).deleteFront());
    }

    @Test
    public void testDeleteFrontWithInsertedValueIsTrue() {
        MyCircularDeque deque = new MyCircularDeque(1);
        deque.insertFront(1);
        assertTrue(deque.deleteFront());
    }

    @Test
    public void testDeleteFrontWithSingleInsertedValueIsEmpty() {
        MyCircularDeque deque = new MyCircularDeque(1);
        deque.insertFront(1);
        deque.deleteFront();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testInsertFrontTwiceAndDeletingOnceHasCorrectFrontValue() {
        MyCircularDeque deque = new MyCircularDeque(2);
        deque.insertFront(1);
        deque.insertFront(2);
        deque.deleteFront();
        assertEquals(1, deque.getFront());
    }

    @Test
    public void testInsertFrontTwiceAndDeletingOnceHasCorrectBackValue() {
        MyCircularDeque deque = new MyCircularDeque(2);
        deque.insertFront(1);
        deque.insertFront(2);
        deque.deleteFront();
        assertEquals(1, deque.getRear());
    }

    @Test
    public void testInsertFrontTwiceAndDeletingOnceIsNotEmpty() {
        MyCircularDeque deque = new MyCircularDeque(2);
        deque.insertFront(1);
        deque.insertFront(2);
        deque.deleteFront();
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testDeleteLastForEmptyListIsFalse() {
        assertFalse(new MyCircularDeque(1).deleteLast());
    }

    @Test
    public void testDeleteLastWithInsertedValueIsTrue() {
        MyCircularDeque deque = new MyCircularDeque(1);
        deque.insertLast(1);
        assertTrue(deque.deleteLast());
    }

    @Test
    public void testDeleteLastWithSingleInsertedValueIsEmpty() {
        MyCircularDeque deque = new MyCircularDeque(1);
        deque.insertLast(1);
        deque.deleteLast();
        assertTrue(deque.isEmpty());
    }

    @Test
    public void testInsertLastTwiceAndDeletingOnceHasCorrectLastValue() {
        MyCircularDeque deque = new MyCircularDeque(2);
        deque.insertLast(1);
        deque.insertLast(2);
        deque.deleteLast();
        assertEquals(1, deque.getRear());
    }

    @Test
    public void testInsertLastTwiceAndDeletingOnceHasCorrectBackValue() {
        MyCircularDeque deque = new MyCircularDeque(2);
        deque.insertLast(1);
        deque.insertLast(2);
        deque.deleteLast();
        assertEquals(1, deque.getRear());
    }

    @Test
    public void testInsertLastTwiceAndDeletingOnceIsNotEmpty() {
        MyCircularDeque deque = new MyCircularDeque(2);
        deque.insertLast(1);
        deque.insertLast(2);
        deque.deleteLast();
        assertFalse(deque.isEmpty());
    }

    @Test
    public void testInsertTwiceDeleteTwiceInsertTwice() {
        MyCircularDeque deque = new MyCircularDeque(2);
        assertTrue(deque.insertFront(1));
        assertTrue(deque.insertFront(2));
        assertTrue(deque.deleteFront());
        assertTrue(deque.deleteFront());
        assertTrue(deque.insertFront(4));
        assertTrue(deque.insertFront(5));
        assertEquals(5, deque.getFront());
        assertEquals(4, deque.getRear());
    }

    @Test
    public void testInsertLastTwiceDeleteLastTwiceInsertTwice() {
        MyCircularDeque deque = new MyCircularDeque(2);
        assertTrue(deque.insertLast(1));
        assertTrue(deque.insertLast(2));
        assertTrue(deque.deleteLast());
        assertTrue(deque.deleteLast());
        assertTrue(deque.insertLast(4));
        assertTrue(deque.insertLast(5));
        assertEquals(5, deque.getRear());
        assertEquals(4, deque.getFront());
    }
}
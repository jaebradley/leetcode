package problems;

/**
 * https://leetcode.com/problems/design-circular-deque/
 *
 * Design your implementation of the circular double-ended queue (deque).
 *
 * Your implementation should support following operations:
 *
 * MyCircularDeque(k): Constructor, set the size of the deque to be k.
 * insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
 * insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
 * deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
 * deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
 * getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
 * getRear(): Gets the last item from Deque. If the deque is empty, return -1.
 * isEmpty(): Checks whether Deque is empty or not.
 * isFull(): Checks whether Deque is full or not.
 *
 *
 * Example:
 *
 * MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
 * circularDeque.insertLast(1);			// return true
 * circularDeque.insertLast(2);			// return true
 * circularDeque.insertFront(3);			// return true
 * circularDeque.insertFront(4);			// return false, the queue is full
 * circularDeque.getRear();  			// return 2
 * circularDeque.isFull();				// return true
 * circularDeque.deleteLast();			// return true
 * circularDeque.insertFront(4);			// return true
 * circularDeque.getFront();			// return 4
 *
 *
 * Note:
 *
 * All values will be in the range of [0, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in Deque library.
 *
 * Approach:
 *
 * 1. Use a doubly-linked list that keeps track of the head and tails
 */

public class MyCircularDeque {
    private final DoublyLinkedList list;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.list = new DoublyLinkedList(k);
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        return this.list.insertFront(value);
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        return this.list.insertLast(value);
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        return this.list.deleteFront();
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        return this.list.deleteBack();
    }

    /** Get the front item from the deque. */
    public int getFront() {
        return this.list.getFrontValue();
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return this.list.getBackValue();
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return this.list.isFull();
    }

    private static class DoublyLinkedList {
        private int size;
        private Node front;
        private Node end;
        private final int capacity;

        private static class Node {
            private final int value;
            private Node next;
            private Node previous;

            public Node(int value, Node next, Node previous) {
                this.value = value;
                this.next = next;
                this.previous = previous;
            }
        }

        public DoublyLinkedList(int size) {
            this.capacity = size;
            this.size = 0;
            this.front = null;
            this.end = null;
        }

        public boolean isEmpty() {
            return this.size == 0;
        }

        public boolean isFull() {
            return this.size >= this.capacity;
        }

        public boolean insertFront(int value) {
            if (this.isFull()) {
                return false;
            }

            Node nextNode = new Node(value, null, this.front);

            if (this.isEmpty()) {
                this.front = nextNode;
                this.end = this.front;
            } else {
                this.front.next = nextNode;
                this.front = nextNode;
            }

            this.size++;

            return true;
        }

        public boolean insertLast(int value) {
            if (this.isFull()) {
                return false;
            }

            Node nextNode = new Node(value, this.end, null);

            if (this.isEmpty()) {
                this.end = nextNode;
                this.front = this.end;
            } else {
                this.end.previous = nextNode;
                this.end = nextNode;
            }

            this.size++;

            return true;
        }

        public boolean deleteFront() {
            if (this.isEmpty()) {
                return false;
            }

            if (this.front.previous != null) {
                Node nextFront = this.front.previous;
                nextFront.next = null;
                this.front = nextFront;
            } else {
                this.front = null;
                this.end = null;
            }

            this.size--;
            return true;
        }

        public boolean deleteBack() {
            if (this.isEmpty()) {
                return false;
            }

            if (this.end.next != null) {
                Node nextEnd = this.end.next;
                nextEnd.previous = null;
                this.end = nextEnd;
            } else {
                this.front = null;
                this.end = null;
            }

            this.size--;
            return true;
        }

        public int getFrontValue() {
            if (this.isEmpty()) {
                return -1;
            }
            return this.front.value;
        }

        public int getBackValue() {
            if (this.isEmpty()) {
                return -1;
            }
            return this.end.value;
        }
    }
}

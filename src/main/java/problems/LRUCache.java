package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lru-cache/description/
 *
 * The idea is to use a doubly linked list to keep track of what keys have been used. When a key is used (get / put) it
 * is removed from it's place in the linked list and put it at the head of the list.
 *
 * When a key is added and the cache is at capacity, then remove the node at the tail of the linked list and remove the
 * tail's key from the store.
 */

class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> store;
    private Node head = new Node(0, 0);
    private Node tail = new Node(0, 0);

    private static class Node {
        private int value;
        private int key;
        private Node next;
        private Node previous;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
            this.previous = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.store = new HashMap<>(capacity);
        this.head.next = tail;
        this.tail.previous = head;
    }

    public int get(int key) {
        Node node = store.get(key);

        if (node == null) {
            return -1;
        }

        remove(node);
        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = store.get(key);

        if (node == null) {
            if (store.size() == capacity) {
                store.remove(tail.previous.key);
                remove(tail.previous);
            }
            node = new Node(key, value);
            moveToHead(node);
            store.put(key, node);
        } else {
            remove(node);
            moveToHead(node);
            node.value = value;
        }
    }

    private void remove(Node node) {
        node.previous.next = node.next;
        node.next.previous = node.previous;
    }

    private void moveToHead(Node node) {
        Node headNext = head.next;
        head.next = node;
        node.next = headNext;
        node.previous = head;
        headNext.previous = node;
    }
}


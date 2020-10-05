package problems;

import java.util.LinkedList;

/**
 * Design a HashMap without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * put(key, value) : Insert a (key, value) pair into the HashMap. If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 *
 * Example:
 *
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 *
 * Note:
 *
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 *
 * Approach:
 *
 * 1. Since the potential size(s) of the HasMap are known (i.e. 1000000 keys / values) can just create an array of that size
 * 2. THe array indices represent the potential slots for keys where the keys are hashed via modulo
 * 3. Each array index has a LinkedList to handle key collisions
 * 4. Handle case where key already exists in HashMap - other than that, setting and retrieving is finding the right array bucket
 *    and adding to, or searching from, the LinkedList at that index
 */

public class MyHashMap {
    private final LinkedList<ListNode>[] map;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this.map = new LinkedList[100000];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        LinkedList<ListNode> bucketNodes = this.map[this.calculateIndex(key)];
        if (bucketNodes == null) {
            bucketNodes = new LinkedList<>();
            bucketNodes.add(new ListNode(key, value));
            this.map[this.calculateIndex(key)] = bucketNodes;
        } else {
            for (ListNode currentNode : bucketNodes) {
                if (currentNode.key == key) {
                    currentNode.value = value;
                    return;
                }
            }
            bucketNodes.add(new ListNode(key, value));
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        LinkedList<ListNode> bucketNodes = this.map[this.calculateIndex(key)];
        if (bucketNodes != null) {
            for (ListNode currentNode : bucketNodes) {
                if (currentNode.key == key) {
                    return currentNode.value;
                }
            }
        }

        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        LinkedList<ListNode> bucketNodes = this.map[this.calculateIndex(key)];
        if (bucketNodes != null) {
            for (ListNode currentNode : bucketNodes) {
                if (currentNode.key == key) {
                    bucketNodes.remove();
                }
            }
        }
    }

    private int calculateIndex(int key) {
        return key % this.map.length;
    }

    private static class ListNode {
        private final int key;
        private int value;

        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }
}

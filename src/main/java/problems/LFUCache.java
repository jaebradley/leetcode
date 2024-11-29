package problems;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * https://leetcode.com/problems/lfu-cache/
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be evicted.
 *
 * Note that the number of times an item is used is the number of calls to the get and put functions for that item since it was inserted. This number is set to zero when the item is removed.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Approach:
 * 1. Keep track of the values and keys using a HashMap
 * 2. Keep track of the keys to their counts using a HashMap
 * 3. Keep track of the order of the keys for any given count using a HashMap of count value to an ordered LinkedHashSet
 * 4. When a value is fetched, increment the existing count for that key - if the count is the minimum count, and there
 *    are no more values for the existing count, increment the "minimum" count too
 * 5. This minimum count value helps make the lookup for the "least frequently used" value easier
 * 6. When a value is inserted and the cache is at capacity, look up the least frequently used value using the minimum
 *    count value and the map that links counts to the ordered LinkedHashSet of keys
 * 7. Remove the least frequently used value, reset the minimum count to 1 (since just inserted a value)
 */

public class LFUCache {
    private final int capacity;
    private final Map<Integer, Integer> keysToValues;
    private final Map<Integer, Integer> keysToCounts;
    private final Map<Integer, LinkedHashSet<Integer>> countsToOrderedKeys;

    private int minimumCount;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minimumCount = 1;
        this.keysToValues = new HashMap<>();
        this.keysToCounts = new HashMap<>();
        this.countsToOrderedKeys = new HashMap<>();
    }

    public int get(int key) {
        if (this.keysToValues.containsKey(key)) {
            int count = this.keysToCounts.get(key);
            int nextCount = count + 1;
            this.countsToOrderedKeys.get(count).remove(key);
            this.keysToCounts.put(key, nextCount);
            if (this.countsToOrderedKeys.containsKey(nextCount)) {
                this.countsToOrderedKeys.get(nextCount).add(key);
            } else {
                LinkedHashSet<Integer> keysForCount = new LinkedHashSet<>();
                keysForCount.add(key);
                this.countsToOrderedKeys.put(nextCount, keysForCount);
            }

            if (this.minimumCount == count && this.countsToOrderedKeys.get(count).isEmpty()) {
                this.minimumCount = nextCount;
            }

            return this.keysToValues.get(key);
        }

        return -1;
    }

    public void put(int key, int value) {
        if (this.capacity <= 0) {
            return;
        }

        if (this.keysToValues.containsKey(key)) {
            this.keysToValues.put(key, value);
            this.get(key);
            return;
        }

        if (this.keysToValues.size() >= this.capacity) {
            LinkedHashSet<Integer> leastRecentlyUsedKeys = this.countsToOrderedKeys.get(this.minimumCount);
            int leastRecentlyUsedKey = leastRecentlyUsedKeys.iterator().next();
            this.keysToValues.remove(leastRecentlyUsedKey);
            this.countsToOrderedKeys.get(this.minimumCount).remove(leastRecentlyUsedKey);
            this.keysToCounts.remove(key);
        }

        this.keysToValues.put(key, value);
        this.keysToCounts.put(key, 1);
        this.minimumCount = Math.min(this.minimumCount, 1);
        if (this.countsToOrderedKeys.containsKey(1)) {
            this.countsToOrderedKeys.get(1).add(key);
        } else {
            LinkedHashSet<Integer> keysForCount = new LinkedHashSet<>();
            keysForCount.add(key);
            this.countsToOrderedKeys.put(1, keysForCount);
        }
    }
}

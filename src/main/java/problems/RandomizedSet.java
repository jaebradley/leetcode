package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1/description/
 *
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of
 *  being returned.
 */

public class RandomizedSet {
    private final Map<Integer, Integer> unordered;
    private final List<Integer> ordered;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        this.unordered = new HashMap<>();
        this.ordered = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (unordered.containsKey(val)) {
            return false;
        }

        ordered.add(val);
        unordered.put(val, ordered.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer indexOfValue = unordered.get(val);
        if (indexOfValue == null) {
            return false;
        }

        // If value is not most recent value added
        // Swap it's location with the most recently added value
        // This is so we don't have to adjust every other value's location
        // While making sure our list has values at every index
        if (indexOfValue < ordered.size() - 1) {
            Integer lastValue = ordered.get(ordered.size() - 1);
            unordered.put(lastValue, indexOfValue);

            indexOfValue = ordered.size() - 1;
        }

        ordered.remove(indexOfValue);
        unordered.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        if (ordered.size() < 1) {
            throw new RuntimeException("No values in set");
        }

        return ordered.get((int) Math.floor(Math.random() * ordered.size()));
    }
}

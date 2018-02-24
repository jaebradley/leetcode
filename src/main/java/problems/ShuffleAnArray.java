package problems;

/**
 * https://leetcode.com/problems/shuffle-an-array/description/
 *
 * Shuffle a set of numbers without duplicates.
 */

public class ShuffleAnArray {
    private final int[] original;

    public ShuffleAnArray(int[] nums) {
        this.original = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] shuffled = this.original.clone();
        int indexToSwap = shuffled.length - 1;
        while (indexToSwap > 0) {
            int newIndex = (int) (Math.random() * (indexToSwap + 1));
            int value = shuffled[indexToSwap];
            int valueAtNewIndex = shuffled[newIndex];
            shuffled[newIndex] = value;
            shuffled[indexToSwap] = valueAtNewIndex;
            indexToSwap--;
        }
        return shuffled;
    }
}

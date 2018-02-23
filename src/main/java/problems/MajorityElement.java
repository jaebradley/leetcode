package problems;

/**
 * https://leetcode.com/problems/majority-element/description/
 *
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */

public class MajorityElement {
    /**
     * There has to be one element where subtracting the count of all other elements is >= 1.
     * This algorithm finds that element by swapping when the count is 0.
     *
     * @param nums array of possible majority elements
     * @return element that appears more than n / 2 times
     */
    public static int majorityElement(int[] nums) {
        int majority = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            int currentValue = nums[i];
            if (count == 0) {
                majority = currentValue;
                count++;
            } else if (majority == currentValue) {
                count++;
            } else {
                count--;
            }
        }
        return majority;
    }
}

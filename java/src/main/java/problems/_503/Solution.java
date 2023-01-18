package problems._503;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        final int[] results = new int[nums.length];
        Arrays.fill(results, -1);
        final Stack<Integer> lesserElementIndices = new Stack<>();
        for (int iteration = 0; iteration < 2; iteration += 1) {
            for (int currentElementIndex = 0; currentElementIndex < nums.length; currentElementIndex += 1) {
                final int currentElement = nums[currentElementIndex];
                while (!lesserElementIndices.isEmpty() && nums[lesserElementIndices.peek()] < currentElement) {
                    results[lesserElementIndices.pop()] = currentElement;
                }
                lesserElementIndices.push(currentElementIndex);
            }
        }
        return results;
    }
}

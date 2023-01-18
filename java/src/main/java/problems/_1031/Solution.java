package problems._1031;

public class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        final int[] sumsFromLeftToRight = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i += 1) {
            sumsFromLeftToRight[i + 1] = sumsFromLeftToRight[i] + nums[i];
        }

        return Math.max(
                calculateMaximumSumOfNonOverlappingSubarrays(sumsFromLeftToRight, firstLen, secondLen),
                calculateMaximumSumOfNonOverlappingSubarrays(sumsFromLeftToRight, secondLen, firstLen)
        );
    }

    private static int calculateMaximumSumOfNonOverlappingSubarrays(
            final int[] sumsFromLeftToRight,
            final int firstSubarrayLength,
            final int secondSubarrayLength
    ) {
        int maximumSumOfFirstSubarrayLength = Integer.MIN_VALUE;
        int maximumSum = Integer.MIN_VALUE;
        for (int i = firstSubarrayLength + secondSubarrayLength; i < sumsFromLeftToRight.length; i += 1) {
            maximumSumOfFirstSubarrayLength = Math.max(
                    maximumSumOfFirstSubarrayLength,
                    sumsFromLeftToRight[i - secondSubarrayLength] - sumsFromLeftToRight[i - secondSubarrayLength - firstSubarrayLength]
            );
            maximumSum = Math.max(
                    maximumSum,
                    maximumSumOfFirstSubarrayLength + sumsFromLeftToRight[i] - sumsFromLeftToRight[i - secondSubarrayLength]
            );
        }

        return maximumSum;
    }
}

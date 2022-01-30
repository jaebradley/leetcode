package problems._813;

public class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        final int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i += 1) {
            sums[i] = sums[i - 1] + nums[i];
        }
        final double[][] dp = new double[nums.length][k + 1];
        return helper(nums, sums, dp, k, 0);
    }

    private static double helper(final int[] nums, final int[] sums, final double[][] dp, final int groupsCount, final int startIndex) {
        if (0 != dp[startIndex][groupsCount]) {
            return dp[startIndex][groupsCount];
        }
        if (1 == groupsCount) {
            dp[startIndex][groupsCount] = (double) (sums[nums.length - 1] - sums[startIndex] + nums[startIndex]) / (nums.length - startIndex);
        } else {
            for (int i = startIndex; i + groupsCount <= nums.length; i += 1) {
                dp[startIndex][groupsCount] = Math.max(
                        dp[startIndex][groupsCount],
                        ((double) (sums[i] - sums[startIndex] + nums[startIndex]) / (i - startIndex + 1))
                                + helper(nums, sums, dp, groupsCount - 1, i + 1)
                );
            }
        }
        return dp[startIndex][groupsCount];
    }
}

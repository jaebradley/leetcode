package problems._1911;

public class Solution {
    public long maxAlternatingSum(int[] nums) {
        final int[][] sumsByIndices = new int[nums.length][2];
        return helper(sumsByIndices, nums, 0, 1);
    }

    private static int helper(final int[][] sumsByIndices, int[] values, final int index, final int isEven) {
        if (index < values.length) {
            final int value = values[index];
            final int chooseValue;
            final int skipValue;

            if (1 == isEven) {
                chooseValue = value + helper(sumsByIndices, values, index + 1, 0);
                skipValue = helper(sumsByIndices, values, index + 1, 1);

            } else {
                chooseValue = -value + helper(sumsByIndices, values, index + 1, 1);
                skipValue = helper(sumsByIndices, values, index + 1, 0);

            }
            sumsByIndices[index][isEven] = Math.max(chooseValue, skipValue);

            return sumsByIndices[index][isEven];
        }
        return 0;
    }

}

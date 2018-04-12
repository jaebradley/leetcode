package problems;

/**
 * https://leetcode.com/problems/target-sum/description/

 * algorithms
 * Medium (43.80%)
 * Total Accepted:    49.2K
 * Total Submissions: 112.4K
 * Testcase Example:  '[1,1,1,1,1]\n3'


 You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.


 Find out how many ways to assign symbols to make sum of integers equal to target S.


 Example 1:

 Input: nums is [1, 1, 1, 1, 1], S is 3.
 Output: 5
 Explanation:

 -1+1+1+1+1 = 3
 +1-1+1+1+1 = 3
 +1+1-1+1+1 = 3
 +1+1+1-1+1 = 3
 +1+1+1+1-1 = 3

 There are 5 ways to assign symbols to make the sum of nums be target 3.



 Note:

 The length of the given array is positive and will not exceed 20.
 The sum of elements in the given array will not exceed 1000.
 Your output answer is guaranteed to be fitted in a 32-bit integer.
 */

public class TargetSum {

    /**
     *
     * Each inner array value represents the count of ways that the sum, represented by the index, could have been generated
     * by that inner array's index value in the outer array.
     *
     * i.e targetSums[2][5] represents the number of ways by the second number that the value -target + 5 could have been
     * generated.
     *
     */

    public static int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (S > sum || S < -sum) {
            return 0;
        }

        int targetSumRowLength = 2 * sum + 1;
        int[][] targetSums = new int[nums.length + 1][targetSumRowLength];
        targetSums[0][sum] = 1;

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];

            for (int j = 0; j < targetSumRowLength; j++) {
                int additionValue = currentNum + j;
                int subtractionValue = -currentNum + j;

                if (additionValue < targetSumRowLength) {
                    targetSums[i + 1][j] += targetSums[i][additionValue];
                }

                if (subtractionValue >= 0) {
                    targetSums[i + 1][j] += targetSums[i][subtractionValue];
                }
            }
        }

        return targetSums[nums.length][sum + S];
    }
}

package problems;

/**
 * https://leetcode.com/problems/perfect-squares/description/

 * algorithms
 * Medium (37.74%)
 * Total Accepted:    108.4K
 * Total Submissions: 287.2K
 * Testcase Example:  '1'


 Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.



 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.


 Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */

public class PerfectSquares {
    public static int numSquares(int n) {
        int[] counts = new int[n + 1];
        counts[0] = 0;

        for (int value = 1; value <= n; value++) {
            int minimumCount = Integer.MAX_VALUE;

            for (int numberOfPerfectSquares = 1; value - numberOfPerfectSquares * numberOfPerfectSquares >= 0; numberOfPerfectSquares++) {
                minimumCount = Math.min(minimumCount, counts[value - numberOfPerfectSquares * numberOfPerfectSquares] + 1);
            }

            counts[value] = minimumCount;
        }

        return counts[n];
    }
}

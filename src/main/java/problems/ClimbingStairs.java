package problems;

/**
 * https://leetcode.com/problems/climbing-stairs/description/

 * algorithms
 * Easy (41.16%)
 * Total Accepted:    244.3K
 * Total Submissions: 592.5K
 * Testcase Example:  '2'

 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


 Note: Given n will be a positive integer.




 Example 1:

 Input: 2
 Output:  2
 Explanation:  There are two ways to climb to the top.

 1. 1 step + 1 step
 2. 2 steps



 Example 2:

 Input: 3
 Output:  3
 Explanation:  There are three ways to climb to the top.

 1. 1 step + 1 step + 1 step
 2. 1 step + 2 steps
 3. 2 steps + 1 step
 */

public class ClimbingStairs {
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] stepCounts = new int[n + 1];
        stepCounts[0] = 0;
        stepCounts[1] = 1;
        stepCounts[2] = 2;

        for (int i = 2; i < n; i++) {
            stepCounts[i + 1] = stepCounts[i] + stepCounts[i - 1];
        }

        return stepCounts[stepCounts.length - 1];
    }
}

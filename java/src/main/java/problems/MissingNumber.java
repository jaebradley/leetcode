package problems;

/**
 https://leetcode.com/problems/missing-number/description/

 * algorithms
 * Easy (45.04%)
 * Total Accepted:    165.2K
 * Total Submissions: 366.8K
 * Testcase Example:  '[3,0,1]'


 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.


 Example 1

 Input: [3,0,1]
 Output: 2



 Example 2

 Input: [9,6,4,2,3,5,7,0,1]
 Output: 8





 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?


 Credits:Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return (nums.length * (nums.length + 1) / 2) - sum;
    }
}

package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/

 * algorithms
 * Easy (51.14%)
 * Total Accepted:    84.9K
 * Total Submissions: 166K
 * Testcase Example:  '[4,3,2,7,8,2,3,1]'

 Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

 Find all the elements of [1, n] inclusive that do not appear in this array.

 Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

 Example:

 Input:
 [4,3,2,7,8,2,3,1]

 Output:
 [5,6]
 */

public class FindAllNumbersDisappearedInAnArray {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int absoluteIndexValue = Math.abs(nums[i]) - 1;
            int num = nums[absoluteIndexValue];
            if (num > 0) {
                nums[absoluteIndexValue] = -num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                numbers.add(i + 1);
            }
        }

        return numbers;
    }
}

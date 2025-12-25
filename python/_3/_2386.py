import heapq
from typing import List

"""
You are given an integer array nums and a positive integer k. You can choose any subsequence of the array and sum all of its elements together.

We define the K-Sum of the array as the kth largest subsequence sum that can be obtained (not necessarily distinct).

Return the K-Sum of the array.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

Note that the empty subsequence is considered to have a sum of 0.

Example 1:
Input: nums = [2,4,-2], k = 5
Output: 2
Explanation: All the possible subsequence sums that we can obtain are the following sorted in decreasing order:
6, 4, 4, 2, 2, 0, 0, -2.
The 5-Sum of the array is 2.

Example 2:
Input: nums = [1,-2,3,4,-10,12], k = 16
Output: 10
Explanation: The 16-Sum of the array is 10.

Constraints:
n == nums.length
1 <= n <= 105
-109 <= nums[i] <= 109
1 <= k <= min(2000, 2n)
"""


class Solution:
    """
    The largest possible sum will be the sum of all positive values.
    Then, there's a decision for calculating the next greatest value
    - Remove a positive value
    - Subtract a negative value

    One of the key points is that there's no real difference between the two - so convert the nums array into an array
    of non-negative numbers that represent the possible values to subtract from the max sum.

    Sort this array in ascending order, so that the smallest possible value to subtract from the max sum is evaluated
    first.

    Create a candidate difference heap, initialized with the first value to subtract, and the index 0.
    While the heap still has elements and the smallest identified differences is less than k
    - pop the smallest difference off of the candidate differences heap
    - add the smallest difference to the differences list
    - push the next smallest differences to the heap based on the previous smallest difference's index
    """

    def kSum(self, nums: List[int], k: int) -> int:
        max_sum, values_to_subtract_from_max_sum = 0, []
        for num in nums:
            if num > 0:
                max_sum += num
            values_to_subtract_from_max_sum.append(abs(num))

        values_to_subtract_from_max_sum.sort()

        candidate_differences, differences = [(values_to_subtract_from_max_sum[0], 0)], []
        while candidate_differences and len(differences) < k:
            minimum_value_to_subtract, index = heapq.heappop(candidate_differences)
            differences.append(minimum_value_to_subtract)
            if index < (len(values_to_subtract_from_max_sum) - 1):
                # Add next smallest sum to current minimum sum as a candidate
                heapq.heappush(candidate_differences,
                               (minimum_value_to_subtract + values_to_subtract_from_max_sum[index + 1], index + 1))
                # Add next smallest sum to current minimum sum MINUS the previous smallest sum as a candidate
                # By skipping the previous value, it allows for evaluating non-consecutive subtraction values
                heapq.heappush(candidate_differences, (values_to_subtract_from_max_sum[index + 1] + (
                            minimum_value_to_subtract - values_to_subtract_from_max_sum[index]), index + 1))

        sums = [max_sum]
        for index in range(k - 1):
            sums.append(max_sum - differences[index])

        return sums[k - 1]

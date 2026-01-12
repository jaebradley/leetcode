"""
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2

Output: [1,2]

Example 2:

Input: nums = [1], k = 1

Output: [1]

Example 3:

Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2

Output: [1,2]



Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
"""
from collections import defaultdict, Counter
from typing import List


class Solution:
    """
    Approach:
    Count the number frequencies.
    Iterate over counts, grouping by frequencies.
    There can be at most len(nums) for a frequency.
    Iterating backwards from len(nums), until k elements have been found, check to see if elements with the current
    frequency exist.
    If they do, add them to the result.
    Once k elements have been found, return the result.
    Runtime: O(n) where n is the length of nums. k <= n.
    Space: O(n) where n is the length of nums.
    """
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counts = Counter(nums)
        elements_with_count = defaultdict(set)
        for element, count in counts.items():
            elements_with_count[count].add(element)

        result = []
        for current_target_count in range(len(nums), -1, -1):
            elements = elements_with_count[current_target_count]
            for element in elements:
                result.append(element)

            if len(result) >= k:
                return result

        raise ValueError("should never get here")

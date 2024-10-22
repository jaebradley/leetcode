"""
https://leetcode.com/problems/median-of-two-sorted-arrays/description/
"""

from typing import List, Optional


class Solution:
    """
    This YouTube video helped me understand the concept: https://www.youtube.com/watch?v=LPFhl65R7ww
    Intuitive solution: https://leetcode.com/problems/median-of-two-sorted-arrays/solutions/2511/intuitive-python-o-log-m-n-solution-by-kth-smallest-in-the-two-sorted-arrays-252ms/
    """

    def findMedianSortedArrays(self, nums1: List[int], nums2: List[int]) -> float:
        combined_length = len(nums1) + len(nums2)
        target_median_index = combined_length // 2
        if 1 == (combined_length % 2):
            return self.find_target_index_element(nums1, nums2, target_median_index)

        return sum(
            (
                self.find_target_index_element(nums1, nums2, target_median_index),
                self.find_target_index_element(nums1, nums2, target_median_index - 1)
            )
        ) / 2

    def find_target_index_element(self, a: Optional[List[int]], b: Optional[List[int]], target_index: int):
        if not a and not b:
            raise RuntimeError("both arrays should never not exist")

        if not a and b:
            return b[target_index]

        if not b and a:
            return a[target_index]

        middle_index_a, middle_index_b = len(a) // 2, len(b) // 2
        middle_value_a, middle_value_b = a[middle_index_a], b[middle_index_b]

        if (middle_index_a + middle_index_b) < target_index:
            if middle_value_a > middle_value_b:
                return self.find_target_index_element(a, b[middle_index_b + 1:], target_index - middle_index_b - 1)

            return self.find_target_index_element(a[middle_index_a + 1:], b, target_index - middle_value_a - 1)
        else:
            if middle_value_a > middle_value_b:
                return self.find_target_index_element(a[:middle_index_a], b, target_index)

            return self.find_target_index_element(a, b[:middle_index_b], target_index)

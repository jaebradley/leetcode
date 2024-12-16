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

        if not a:
            return b[target_index]

        if not b:
            return a[target_index]

        middle_index_a, middle_index_b = len(a) // 2, len(b) // 2
        middle_value_a, middle_value_b = a[middle_index_a], b[middle_index_b]

        """
        If the target index is greater than the middle index of a + the middle index of b...
        
        If the middle value of a (i.e. the middle index value of a) is > the middle value of b (i.e. the middle index 
        value of b), then the target index can't be in the first half of b.
        
        This is because the target index is greater than the middle index of a AND the middle index of b. So at least 
        some of the first half of a is greater than some of the first half of b (an extreme case is that all of the 
        first half of a is greater than all of the first half of b, and the most extreme case is that all of a is
        greater than all of b).
        
        So to get to the target index, it is definitely not in the first half of b, and may be in the first (or second
        half of a) or in the second half of b.
        
        Similar logic is used for the case where the target index is less than the middle index of a + the middle index 
        of b, and when the middle value of a is greater / less than the middle value of b. 
        """
        if (middle_index_a + middle_index_b) < target_index:
            if middle_value_a > middle_value_b:
                return self.find_target_index_element(a, b[middle_index_b + 1:], target_index - middle_index_b - 1)

            return self.find_target_index_element(a[middle_index_a + 1:], b, target_index - middle_index_a - 1)
        else:
            if middle_value_a > middle_value_b:
                return self.find_target_index_element(a[:middle_index_a], b, target_index)

            return self.find_target_index_element(a, b[:middle_index_b], target_index)

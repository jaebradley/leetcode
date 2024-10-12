from heapq import heappop, heappush
from typing import List


class Solution:
    def kSmallestPairs(self, nums1: List[int], nums2: List[int], k: int) -> List[List[int]]:
        """
        Idea is to first add all the pairs from all the values in nums1 and nums2[0]. The heap should now be ordered
        with the minimum sums using only nums1 values and nums2[0].

        Popping the first element of the heap should have the minimum sum, since it's using nums1[0] and nums2[0]. Add
        this element to the pairs to return.

        If the nums2 index value that was popped is less than the length of nums2 (i.e. there's a potential next nums2
        value) add it to the heap as it could be a value that is less than all the current candidate nums1 + nums2[0]
        sums.

        Continue this k times to guarantee that at least k nums2 values have been explored.
        """
        pairs = []
        heap = []
        for i in range(len(nums1)):
            heappush(heap, (nums1[i] + nums2[0], [i, 0]))

        counter = k

        while counter > 0 and heap:
            value, (nums1_index, nums2_index) = heappop(heap)
            pairs.append([nums1[nums1_index], nums2[nums2_index]])

            if nums2_index < (len(nums2) - 1):
                heappush(heap, (nums1[nums1_index] + nums2[1 + nums2_index], [nums1_index, 1 + nums2_index]))

            counter -= 1

        return pairs

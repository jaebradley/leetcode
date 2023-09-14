import heapq
from typing import List


class Solution:
    def maxScore(self, nums1: List[int], nums2: List[int], k: int) -> int:
        combinations = sorted(zip(nums1, nums2), key=lambda combination: combination[1], reverse=True)

        max_score = float("-inf")
        current_minimum_multiplier = float("inf")
        pq = []
        current_sum = 0

        for (first_number, second_number) in combinations:
            current_sum += first_number
            heapq.heappush(pq, first_number)
            current_minimum_multiplier = min(current_minimum_multiplier, second_number)
            if len(pq) > k:
                current_sum -= heapq.heappop(pq)

            if len(pq) == k:
                max_score = max(max_score, current_sum * current_minimum_multiplier)

        return max_score

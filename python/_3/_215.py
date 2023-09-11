import heapq
from typing import List


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        negated_values = list(map(lambda x: -x, nums))
        heapq.heapify(negated_values)
        for _ in range(k - 1):
            heapq.heappop(negated_values)

        return -heapq.heappop(negated_values)

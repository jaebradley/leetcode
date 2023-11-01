import sys
from typing import List


class Solution:
    """
    Min(
        Min(cost of 1 step + min cost from next step, cost of 2 steps + min cost from 2 steps) from step 0,
        Min(cost of 1 step + min cost from next step, cost of 2 steps + min cost from 2 steps) from step 1
    )
    """

    def minCostClimbingStairs(self, cost: List[int]) -> int:
        costs = [sys.maxsize] * (len(cost) + 1)
        costs[0] = 0
        costs[1] = 0
        costs[2] = 0
        for stair_index in range(2, len(cost) + 1):
            costs[stair_index] = min(
                costs[stair_index - 1] + cost[stair_index - 1],
                costs[stair_index - 2] + cost[stair_index - 2]
            )
        return costs[-1]

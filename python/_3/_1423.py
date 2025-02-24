from typing import List


class Solution:
    def maxScore(self, cardPoints: List[int], k: int) -> int:
        left_prefix_sum = sum(cardPoints[0:k])
        right_prefix_sum = 0
        max_score = max(0, left_prefix_sum + right_prefix_sum)
        for left_prefix_index in range(0, k):
            left_prefix_sum -= cardPoints[k - 1 - left_prefix_index]
            right_prefix_sum += cardPoints[len(cardPoints) - 1 - left_prefix_index]
            max_score = max(max_score, left_prefix_sum + right_prefix_sum)

        return max_score
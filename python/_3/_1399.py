import sys
from collections import Counter


class Solution:
    def countLargestGroup(self, n: int) -> int:
        group_counts = Counter()
        previous_digit_sums = {0: 0}
        for i in range(1, n + 1):
            q, remainder = divmod(i, 10)
            current_digit_sum = previous_digit_sums[q] + remainder
            previous_digit_sums[i] = current_digit_sum
            group_counts[current_digit_sum] += 1
        max_value, largest_group_counts = -sys.maxsize, 0
        for value in group_counts.values():
            if value > max_value:
                largest_group_counts = 1
                max_value = value
            elif value == max_value:
                largest_group_counts += 1
        return largest_group_counts

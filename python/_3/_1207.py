from typing import List


class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        counts_by_value = {}
        for value in arr:
            count = counts_by_value.get(value, 0)
            counts_by_value[value] = 1 + count
        unique_counts = set()
        for count in counts_by_value.values():
            if count in unique_counts:
                return False

            unique_counts.add(count)

        return True

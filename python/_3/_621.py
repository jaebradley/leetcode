from collections import Counter
from typing import List


class Solution:
    """
    Think of each grouping as array slots
    0: [a, b, c, etc, (and any "padding" before next "a/b/c")]
    1: [a, b, etc, (and any "padding" before next "a/b/c")]
    2: [a]

    So total number of array slots is based off of most frequent element.
    Width of array slots is n (unless n is less than the total number of elements that have the most frequent count - like if n is 1).
    Last array slot is unique where its length is the number of elements that have the most frequenet count.
    Maximum of
    - Total task length (in cases where n is 1 (or similar))
    - (Highest frequency element count - 1 (for last row)) * (# of CPU cycles + 1 (for the highest frequency element)) + final row (total # of elements that have the highest frequency)
    """

    def leastInterval(self, tasks: List[str], n: int) -> int:
        c = Counter(tasks)
        most_common_elements, most_common_count = 0, 0
        for mce, mce_count in c.most_common():
            if most_common_elements == 0:
                most_common_count = mce_count
            elif mce_count < most_common_count:
                break

            most_common_elements += 1

        return max(len(tasks), (most_common_count - 1) * (n + 1) + most_common_elements)

import heapq
from collections import Counter
from typing import List


class MathematicalSolution:
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


class PriorityQueueSolution:
    """
    Max heap of element with the greatest frequency element.
    Pop elements off the heap and decrement their frequency.
    Add these elements to a temporary array.
    If heap is empty but n + 1 iterations haven't occurred yet, increment the counter by the remaining iterations.
    Push elements onto the heap (or heapify the temporary array) and create a new temp array.
    Repeat this process until heap is empty.

    O(n) (for counting element frequency) + O(n x log k) (for heapifying the counted elements)
    Since k = # of characters = 26, log 26 reduces to a constant.
    O(n) + O(n x some constant) reduces to O(n)
    """

    def leastInterval(self, tasks: List[str], n: int) -> int:
        time, c = 0, Counter(tasks)
        character_counts = list(map(lambda v: -v[1], c.most_common()))
        heapq.heapify(character_counts)
        while character_counts:
            seen_counts, remaining_iterations, task_count = [], n + 1, 0
            while remaining_iterations > 0 and character_counts:
                frequency = heapq.heappop(character_counts)
                if frequency < -1:
                    seen_counts.append(frequency + 1)
                task_count += 1
                remaining_iterations -= 1
            for count in seen_counts:
                heapq.heappush(character_counts, count)
            time += n + 1 if character_counts else task_count
        return time

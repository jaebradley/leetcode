from collections import defaultdict
from heapq import heappush, heappop

"""
Design a number container system that can do the following:

    Insert or Replace a number at the given index in the system.
    Return the smallest index for the given number in the system.

Implement the NumberContainers class:

    NumberContainers() Initializes the number container system.
    void change(int index, int number) Fills the container at index with the number. If there is already a number at that index, replace it.
    int find(int number) Returns the smallest index for the given number, or -1 if there is no index that is filled by number in the system.

"""


class NumberContainers:
    """
    Map<Index, Number> numbersByIndex: keep track of the last number for a given index
    Map<Number, List<Index>> orderedIndicesByNumber: keep ordered index values for a given number
    """
    def __init__(self):
        self.ordered_indices_by_number = defaultdict(list)
        self.numbers_by_index = {}

    """
    Replace the mapping of the last number for a given index 
    - O(1)
    Add the index value to the set of seen ordered indices associated with a given number
    - O(log # of operations) in worst case
    - Only "change" operations for one number
    """
    def change(self, index: int, number: int) -> None:
        self.numbers_by_index[index] = number
        heappush(self.ordered_indices_by_number[number], index)

    """
    Get the ordered indices associated with the specified number.
    Iterate over the indices one at a time (should be sorted from smallest index to largest, since it's a min-heap).
    If the most recent number for the minimum index is the number we're trying to find, return it.
    Else pop the minimum value from the heap and re-heapify.
    """
    def find(self, number: int) -> int:
        ordered_indices = self.ordered_indices_by_number[number]
        while ordered_indices:
            current_minimum_index = ordered_indices[0]
            if self.numbers_by_index[current_minimum_index] == number:
                return current_minimum_index
            heappop(ordered_indices)
        return -1

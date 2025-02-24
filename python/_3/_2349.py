from heapq import heapify

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

    def __init__(self):
        self.indices_by_number = {}
        self.ordered_indices_by_number = {}
        self.numbers_by_index = {}

    """
    Have to recalculate existing index and ordering for that number, if it exists
    
    Map<Number, Set<Index>> indicesByNumber
    Map<Number, List<Index>> orderedIndicesByNumber
    
    orderedIndicesByNumber is only recalculated (from the set of numbers) if the first element in the list is removed (can use heapsort O(n log n)).
    """

    def change(self, index: int, number: int) -> None:
        current_number_for_index = self.numbers_by_index.get(index, None)
        indices_for_current_number = self.indices_by_number.get(current_number_for_index, set([]))
        if current_number_for_index is not None and current_number_for_index != number and current_number_for_index not in indices_for_current_number:
            indices_for_current_number.remove(index)
            self.indices_by_number[current_number_for_index] = indices_for_current_number

        self.numbers_by_index[index] = number

        updated_indices_for_number = self.indices_by_number.get(number, set([]))
        updated_indices_for_number.add(index)
        self.indices_by_number[number] = updated_indices_for_number

    def find(self, number: int) -> int:
        indices = list(self.indices_by_number.get(number, set([])))
        heapify(indices)
        self.ordered_indices_by_number[number] = indices
        if self.ordered_indices_by_number[number]:
            return self.ordered_indices_by_number[number][0]
        return -1

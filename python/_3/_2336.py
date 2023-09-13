import heapq


class SmallestInfiniteSet:

    def __init__(self):
        self.natural_numbers = [1]
        self.added_back_natural_numbers = []
        self.distinct_added_back_natural_numbers = set(self.added_back_natural_numbers)

    def popSmallest(self) -> int:
        next_natural_number = self.natural_numbers[0]
        next_added_back_natural_number = self.added_back_natural_numbers[0] \
            if self.distinct_added_back_natural_numbers \
            else None
        if next_added_back_natural_number and next_natural_number > next_added_back_natural_number:
            value = heapq.heappop(self.added_back_natural_numbers)
        else:
            value = heapq.heappop(self.natural_numbers)
            heapq.heappush(self.natural_numbers, 1 + value)
            if next_natural_number == next_added_back_natural_number:
                heapq.heappop(self.added_back_natural_numbers)
        if value in self.distinct_added_back_natural_numbers:
            self.distinct_added_back_natural_numbers.remove(value)
        return value

    def addBack(self, num: int) -> None:
        if num not in self.distinct_added_back_natural_numbers:
            heapq.heappush(self.added_back_natural_numbers, num)
            self.distinct_added_back_natural_numbers.add(num)

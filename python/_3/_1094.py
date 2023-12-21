from typing import List


class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        passenger_count_by_stop = [0] * 1001

        for (passengers, from_index, to_index) in trips:
            for index in range(from_index, to_index):
                passenger_count_by_stop[index] += passengers

        return all(map(lambda passenger_count: passenger_count <= capacity, passenger_count_by_stop))

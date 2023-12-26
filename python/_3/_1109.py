from typing import List


class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        temp = [0] * (n + 1)

        for (starting_index, ending_index, seats) in bookings:
            temp[starting_index - 1] += seats
            temp[ending_index] -= seats

        results = [0] * (n + 1)
        current_sum = 0
        for index, value in enumerate(temp):
            current_sum += temp[index]
            results[index] = current_sum

        return results[:-1]
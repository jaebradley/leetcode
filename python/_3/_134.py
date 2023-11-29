from typing import List


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        number_of_stations = len(gas)
        total_surplus = 0
        current_surplus = 0
        starting_index = 0

        for station_index in range(number_of_stations):
            cost_to_travel_to_next_index = gas[station_index] - cost[station_index]
            total_surplus += cost_to_travel_to_next_index
            current_surplus += cost_to_travel_to_next_index

            if current_surplus < 0:
                current_surplus = 0
                starting_index = 1 + station_index

        return -1 if total_surplus < 0 else starting_index

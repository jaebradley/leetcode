from typing import List


class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        current_altitude = maximum_altitude = 0
        for relative_elevation_change in gain:
            current_altitude += relative_elevation_change
            maximum_altitude = max(maximum_altitude, current_altitude)
        return maximum_altitude

"""
There are n cars at given miles away from the starting mile 0, traveling to reach the mile target.

You are given two integer arrays position and speed, both of length n, where position[i] is the starting mile of the ith car and speed[i] is the speed of the ith car in miles per hour.

A car cannot pass another car, but it can catch up and then travel next to it at the speed of the slower car.

A car fleet is a single car or a group of cars driving next to each other. The speed of the car fleet is the minimum speed of any car in the fleet.

If a car catches up to a car fleet at the mile target, it will still be considered as part of the car fleet.

Return the number of car fleets that will arrive at the destination.



Example 1:

Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]

Output: 3

Explanation:

The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12. The fleet forms at target.
The car starting at 0 (speed 1) does not catch up to any other car, so it is a fleet by itself.
The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
Example 2:

Input: target = 10, position = [3], speed = [3]

Output: 1

Explanation:

There is only one car, hence there is only one fleet.
Example 3:

Input: target = 100, position = [0,2,4], speed = [4,2,1]

Output: 1

Explanation:

The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The car starting at 4 (speed 1) travels to 5.
Then, the fleet at 4 (speed 2) and the car at position 5 (speed 1) become one fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.


Constraints:

n == position.length == speed.length
1 <= n <= 105
0 < target <= 106
0 <= position[i] < target
All the values of position are unique.
0 < speed[i] <= 106
"""
from typing import List


class Solution:
    """
    Order cars by their starting position.

    (Target location - position) / speed = time it takes car to get to target.

    If the car with the greatest starting position takes less time (i.e. has a faster speed) than the car with the next
    largest starting position, the car behind it won't ever catch up, meaning the lead car is in its own fleet (and thus,
    can be removed from contention).

    If the lead car can be caught, then it must have a slower speed than the car that caught it (since it had a greater
    starting position) so add it back to the top of the stack and see if the next car can catch this lead car.

    There should only be one car remaining (at most) - this car will be it's own fleet.
    """
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        durations_by_index = dict(map(lambda index: [index, (target - position[index]) / speed[index]], range(len(position))))
        indexed_sorted_positions_ascending = sorted(enumerate(position), key=lambda index_and_position: index_and_position[1])
        fleets = 0
        while len(indexed_sorted_positions_ascending) > 1:
            lead_car_index, lead_car_duration = indexed_sorted_positions_ascending.pop()
            second_car_index, second_car_duration = indexed_sorted_positions_ascending[-1]
            lead_car_duration, second_car_duration = durations_by_index[lead_car_index], durations_by_index[second_car_index]
            if lead_car_duration < second_car_duration:
                fleets += 1
            else:
                indexed_sorted_positions_ascending[-1] = [lead_car_index, lead_car_duration]

        return fleets + int(bool(indexed_sorted_positions_ascending))



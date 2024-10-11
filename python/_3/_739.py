from typing import List


class Solution:
    """
    Approach is to work backwards from end of temperatures list.

    Keep track of seen temperatures in a stack.

    If the current temperature (working from the right of the temperatures list to the left of the temperatures list)
    is less than the top temperature in the stack, then the # of days is the difference between the index
    of the top temperature in the stack and the current temperature index.

    If the current temperature is greater than the top temperature in the stack, it can replace any candidate
    temperatures that currently exist in the stack, because the current temperature will be a better "next greatest temperature"
    for the remaining temperatures (to the left of the current temperature) that need to be evaluated.

    This means that all temperatures in the stack < the current temperature can be removed. If no temperatures in the stack are
    greater than the current temperature, insert a 0 in the result array as no temperatures to its right are greater than it.
    """

    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        result = [0] * len(temperatures)
        greatest_temperatures_seen = []

        for current_temperature_index in range(len(temperatures) - 1, -1, -1):
            current_temperature = temperatures[current_temperature_index]
            while 0 < len(greatest_temperatures_seen) \
                    and greatest_temperatures_seen[-1][0] <= current_temperature:
                greatest_temperatures_seen.pop()

            if 0 == len(greatest_temperatures_seen):
                result[current_temperature_index] = 0
            else:
                current_greatest_temperature = greatest_temperatures_seen[-1]
                result[current_temperature_index] = current_greatest_temperature[1] - current_temperature_index
            greatest_temperatures_seen.append([current_temperature, current_temperature_index])

        return result

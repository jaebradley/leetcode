"""
https://leetcode.com/problems/interval-list-intersections/
"""

from typing import List


class Solution:
    """
    First index and second index pointers, which point to the next index in each list.

    Cases:
    If at end of either list, stop and return results.
    First element is before second element. No overlap, and should iterate over first element.
    First element is after second element. No overlap, should iterate over second element.

    Take max of starting value and min of ending value for these cases:
    First element fully contains second element. Add second element to results.
    Second element fully contains first element. Add first element to results.
    First element starts before and ends before second element.
    Second element starts before and ends before first element.

    Runtime: O(length of first list + length of second list) - have to inspect each element of each list
    Memory: O(min(length of first list, length of second list)) - in worst case, each element in at least one of the
    lists overlaps one list in the other list and so the length of the returned intersections is the length of the smallest list
    """

    def intervalIntersection(self, firstList: List[List[int]], secondList: List[List[int]]) -> List[List[int]]:
        first_element_index = 0
        second_element_index = 0
        intersections = []

        while first_element_index < len(firstList) and second_element_index < len(secondList):
            first_element = firstList[first_element_index]
            second_element = secondList[second_element_index]

            # first element ends before second element starts
            if first_element[1] < second_element[0]:
                first_element_index += 1
            # second element ends before first element starts
            elif second_element[1] < first_element[0]:
                second_element_index += 1
            else:
                intersections.append(
                    [
                        max(first_element[0], second_element[0]),
                        min(first_element[1], second_element[1])
                    ]
                )
                if first_element[1] < second_element[1]:
                    first_element_index += 1
                else:
                    second_element_index += 1

        return intersections

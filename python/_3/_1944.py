from typing import List

"""
There are n people standing in a queue, and they numbered from 0 to n - 1 in left to right order. You are given an 
array heights of distinct integers where heights[i] represents the height of the ith person.

A person can see another person to their right in the queue if everybody in between is shorter than both of them. More 
formally, the ith person can see the jth person if i < j and 
min(heights[i], heights[j]) > max(heights[i+1], heights[i+2], ..., heights[j-1]).

Return an array answer of length n where answer[i] is the number of people the ith person can see to their right in the
queue.
"""


class Solution:
    """
    At any given index, you can see the right next greater element.
    The next greater element on your let can also see you.

    If current value is greater than last element in stack, this element can't see past the current value.
    So pop the element from the stack.
    If stack is not empty, then top of the stack is next greatest element on the left. This element can see the current
    element. So increment the left element's count
    """

    def canSeePersonsCount(self, heights: List[int]) -> List[int]:
        results, stack = [0] * len(heights), []

        for index, height in enumerate(heights):
            while stack and height > heights[stack[-1]]:
                results[stack.pop()] += 1

            if stack:
                results[stack[-1]] += 1

            stack.append(index)

        return results

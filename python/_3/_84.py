"""
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
return the area of the largest rectangle in the histogram.

Example 1:
Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:
Input: heights = [2,4]
Output: 4

Constraints:
1 <= heights.length <= 105
0 <= heights[i] <= 104
"""
from typing import List


class Solution:
    """
    Keep track of seen elements in the stack.
    Use a sentinel value of -1 to indicate the end of the stack. This is to help with the width calculation.
    When a seen height decreases compared to the previously seen height, calculate the area using the previously seen
    height.
    This involves iterating backwards through the stack until a height that is strictly less than the current
    height is seen. Then the area is calculated and compared to the previous maximum area.
    Need to also do this same process at the end as there can be heights left in the stack (for example, if the input
    array was strictly monotonically increasing).
    """

    def largestRectangleArea(self, heights: List[int]) -> int:
        max_area = 0
        stack = [-1]

        for index, height in enumerate(heights):
            while stack[-1] > -1 and heights[stack[-1]] >= height:
                current_height = heights[stack.pop()]
                # since the index at stack[-1] represents the first prior element that is
                # strictly less than the current_height value, the true width is to include
                # the element after this index value, which means decrementing the index - stack[-1] "width"
                # by 1.
                current_width = index - stack[-1] - 1
                max_area = max(max_area, current_height * current_width)

            stack.append(index)

        # This loop iterates over any remaining heights in the stack (for example, if the heights were monotonically
        # increasing).
        while stack[-1] > -1:
            current_height = heights[stack.pop()]
            current_width = len(heights) - stack[-1] - 1
            max_area = max(max_area, current_height * current_width)

        return max_area

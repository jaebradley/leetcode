from typing import List


class Solution:

    def trap(self, height: List[int]) -> int:
        left_index, right_index = 0, (len(height) - 1)
        left_max, right_max, amount = 0, 0, 0

        while left_index < right_index:
            # Water could, potentially, fill everything from left to right, if there is nothing in between.
            left_index_height = height[left_index]
            right_index_height = height[right_index]
            # If the current elevation is greater than the previous maximum, water cannot occupy the current index.
            #
            # However, we do know that everything from the previous maximum to the current index, has been optimally
            # filled, as we've been adding water to the brim of the last maximum.
            if left_index_height < right_index_height:
                if left_index_height >= left_max:
                    # We've found a new maximum, and look to see how much water we can fill from this point on.
                    left_max = left_index_height
                else:
                    # If we've yet to find a maximum, we know that we can fill the current point with water up to the
                    # previous maximum.

                    # We subtract the current height, as that is the elevation of the ground
                    amount += (left_max - left_index_height)
                left_index += 1
            else:
                if right_index_height >= right_max:
                    right_max = right_index_height
                else:
                    amount += (right_max - right_index_height)
                right_index -= 1

        return amount

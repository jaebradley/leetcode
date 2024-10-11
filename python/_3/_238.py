from typing import List


class Solution:
    """
    [a:b] is closed interval from a to b

    First value: product of [1:]
    Second value: product of [0] and [2:]
    Third value: product of [0:1] and [3:]

    First array is products from right to left (starting from last element to 2nd element):
    [1, [n], [n-1:], [n-2:],...,[2:], [1:]]

    Second array is products from left to right (starting from first element to 2nd to last element):
    [1, [0], [0:1], [0:2],...,[0:n-4], [0:n-3], [0:n-2], [0:n-1]]
    """

    def productExceptSelf(self, nums: List[int]) -> List[int]:
        left_to_right, right_to_left, numbers_count = [1], [1], len(nums)
        for left_to_right_index in range(numbers_count - 1):
            left_to_right_number = nums[left_to_right_index]
            right_to_left_index = numbers_count - 1 - left_to_right_index
            right_to_left_number = nums[right_to_left_index]

            left_to_right.append(left_to_right[-1] * left_to_right_number)
            right_to_left.append(right_to_left[-1] * right_to_left_number)

        products = []
        for index in range(numbers_count):
            left_to_right_product = left_to_right[index]
            right_to_left_product = right_to_left[numbers_count - 1 - index]

            products.append(left_to_right_product * right_to_left_product)

        return products

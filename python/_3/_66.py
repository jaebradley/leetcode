"""
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.



Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].


Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.
"""
from typing import List


class Solution:
    """
    Start from least significant digit to most significant digit (so right-most index to left-most index).
    Keep track of carry.
    While carry is non-zero, keep adding digits.
    If carry is zero, can combine the remaining digits in the digits array with the summed digits in the output array.
    """
    def plusOne(self, digits: List[int]) -> List[int]:
        summed_digits, has_carry = [], True
        for index in range(len(digits) - 1, -1, -1):
            next_digit = digits[index] + int(has_carry)
            has_carry = next_digit > 9
            summed_digits.append(next_digit % 10)
            if not has_carry:
                return digits[:index] + list(reversed(summed_digits))

        if has_carry:
            summed_digits.append(1)

        return list(reversed(summed_digits))
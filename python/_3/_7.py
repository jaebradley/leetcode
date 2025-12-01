"""
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-2^31, 2^31 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).



Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21


Constraints:

-231 <= x <= 231 - 1
"""
import math


class Solution:
    """
    Divide by 10 and get the remainder to get the digit.
    Apply the remainder directly to the reversed value. Start the reversed value from 0.
    If the reversed value is greater than the max allowable value, return 0.
    Set the quotient as the current value to evaluate the next digit.
    Runtime is O(# of digits in x) => O(log base 10 of x)
    Space is O(1)
    """

    def reverse(self, x: int) -> int:
        sign, current_value, max_value, reversed_value = -1 if x < 0 else 1, abs(x), math.pow(2, 31) - 1, 0
        while current_value > 0:
            quotient, remainder = divmod(current_value, 10)
            reversed_value = reversed_value * 10 + remainder
            if reversed_value > max_value:
                return 0

            current_value = quotient

        return sign * reversed_value

"""
Given two integers a and b, return the sum of the two integers without using the operators + and -.



Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5


Constraints:

-1000 <= a, b <= 1000
"""


class Solution:
    """
    The mask is a 32 set bits. By &-ind with the mask, any other set bits are unset. This eliminates any other bits that
    might have been set outside of the 32-bit space.

    Negative numbers will have the most significant bit (the 32nd from the right) set to 1.

    Addition works by XOR-ing the two values until the "carry" is zero.
    The carry is the AND of the two values + bit shift to the left ANDed with the 32 bit mask.

    Subtraction works by XOR-ing the two values until the "borrow" is zero.
    Borrow is the NOT operation applied to the first value ANDed with the second value, bit-shifted to the left.

    If the result is greater than the maximum 32-bit positive integer (0 bit followed by 31 1-bits), then need to "clip"
    off bits outside the 32-bit range by XOR-ing with the mask.

    XOR-ing will flip any set bits, so to reverse this, need to NOT the result.
    """
    def getSum(self, a: int, b: int) -> int:
        mask = 0xFFFFFFFF
        while b != 0:
            a, b = (a ^ b) & mask, ((a & b) << 1) & mask

        return a if a < 0x7FFFFFFF else ~(a ^ mask)

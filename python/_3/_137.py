from typing import List


class Solution:
    """
    Every value occurs 3 times except a single value, which only occurs one time.

    Keep track of bits that appear once and bits that appear twice.

    ANDing the current number with the negation of the bits appearing twice results in a number where all the 1 bits
    represent bits that did NOT appear twice (including the current number).

    XORing this result (bits that have not appeared twice ANDed with the current number) with the current bits that have
    appeared once results in a number where all 1 bits are bits that have appeared once.

    ANDing the current number with the negation of the bits appearing once results in a number where all the 1 bits are
    bits that have NOT appeared only once (including the current number).

    XORing this result (bits that have not appeared once ANDed with the current number) with the current bits that have
    appeared twice results in a number where all 1 bits are bits that have not been seen once.
    """

    def singleNumber(self, nums: List[int]) -> int:
        bits_appearing_once = 0
        bits_appearing_twice = 0
        for num in nums:
            bits_appearing_once ^= num & ~bits_appearing_twice
            bits_appearing_twice ^= num & ~bits_appearing_once
        return bits_appearing_once

import operator


class Solution:
    """
    a | b is what we need to change in order to get c
    XORing a | b with c defines all differing bits in a | b vs. c
    One other case where we need to count differing bits - when bit in a is 1, bit in b is 1, and bit in c is 0.
    This requires two bit flips (one of which has been counted when XORing a | b with c).
    To count the "other" bit flip in this case, need to find all cases of this occurrence.
    a & b finds all the bits that are set in a and b.
    (a | b) ^ c finds all differing bits between a | b and c.
    (a & b) & ((a | b) ^ c) finds all the bits that are set in a and b that differ between (a | b) and c.
    """
    def minFlips(self, a: int, b: int, c: int) -> int:
        return Solution.count_set_bits(operator.xor(operator.or_(a, b), c)) \
            + Solution.count_set_bits(operator.and_(operator.and_(a, b), operator.xor(operator.or_(a, b), c)))

    @staticmethod
    def count_set_bits(value: int) -> int:
        counter = 0
        while 0 != value:
            if Solution.is_last_bit_set(value):
                counter += 1

            value >>= 1

        return counter

    @staticmethod
    def is_last_bit_set(value: int) -> bool:
        return 1 == (value & 0x01)

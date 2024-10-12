import math
from typing import List


class Solution:
    def countBits(self, n: int) -> List[int]:
        bits = [0] * (n + 1)
        for number in range(1, n + 1):
            bits[number] = bits[int(math.floor(number / 2))] + (number % 2)
        return bits

import sys


class Solution:
    def twoEggDrop(self, n: int) -> int:
        result = [[0] * (1 + n), [0] * (1 + n), [0] * (1 + n)]

        def drop(floors, eggs, result):
            if eggs == 1 or floors <= 1:
                return floors

            if result[eggs][floors] > 0:
                return result[eggs][floors]

            current_minimum = sys.maxsize
            for i in range(1, 1 + n):
                current_minimum = min(current_minimum,
                                      1 + max(drop(i - 1, eggs - 1, result), drop(floors - i, eggs, result)))

            result[eggs][floors] = current_minimum
            return current_minimum

        return drop(n, 2, result)

class Solution:
    def tribonacci(self, n: int) -> int:
        first = 0
        second = 1
        third = 1

        if 0 == n:
            return first

        if 1 == n:
            return second

        if 2 == n:
            return third

        for _ in range(3, n + 1):
            current_value = first + second + third
            first = second
            second = third
            third = current_value

        return current_value

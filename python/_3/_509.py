class Solution:
    def fib(self, n: int) -> int:
        prev_prev, prev = 0, 1
        if n == 0:
            return prev_prev

        if n == 1:
            return prev

        current = prev_prev + prev

        for current_fib in range(2, n):
            next_current = current + prev
            prev = current
            current = next_current

        return current
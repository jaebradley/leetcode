"""
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).



Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25


Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104
"""


class RecursiveSolution:
    """
    When positive, it means multiplying by itself n times.
    When negative, it means 1 / positive.
    When 0, return 1.
    Binary exponentiation: pow(2, 100) = pow((2 x 2), 50) = pow(4 x 4, 25).
    Since the process squares / halves each step, the time complexity is O(log n).
    Iterative approach has a space complexity of O(1), while recursive approach has space complexity of O(log n) due to
    call stack.
    """

    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1
        if n == 1:
            return x
        if n < 0:
            return 1 / self.myPow(x, -n)

        return self.myPow(x, n % 2) * self.myPow(x * x, n // 2)

class IterativeSolution:
    def myPow(self, x: float, n: int) -> float:
        product, current_value, counter = 1, x, abs(n)
        while counter > 0:
            if counter % 2 == 1:
                product *= current_value
            counter = counter // 2
            current_value *= current_value

        if n > 0:
            return product

        return 1 / product

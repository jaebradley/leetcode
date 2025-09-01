class Solution:
    def mySqrt(self, x: int) -> int:
        def binary_search(value: int, target: int, low: int, high: int) -> int:
            if value == low or value == high:
                return value

            squared_value = value * value
            if squared_value < target:
                return binary_search((high + value) // 2, target, value, high)

            if squared_value > target:
                return binary_search((low + value) // 2, target, low, value)

            return value
        if x == 1:
            return x
        return binary_search(x // 2, x, 0, x)
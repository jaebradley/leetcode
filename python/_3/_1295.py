from decimal import Decimal

class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        count = 0
        for value in nums:
            exponent = Decimal(value).log10()
            if int(exponent) % 2 != 0:
                count += 1

        return count
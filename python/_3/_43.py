"""
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.



Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"


Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
"""


class Solution:
    """
    Initialize starting list that can be, at most, the combined total length of both input lists.
    Start with least significant digits for each and multiply them, adding carried digits to the appropriate location.
    Strip leading 0s when serializing back to a string.
    Runtime + Space = O(length of num 1 + length of num2)
    """

    def multiply(self, num1: str, num2: str) -> str:
        total = [0] * (len(num1) + len(num2))

        for power_of_ten_num1 in range(len(num1) - 1, -1, -1):
            num1_digit = int(num1[power_of_ten_num1])

            for power_of_ten_num2 in range(len(num2) - 1, -1, -1):
                num2_digit = int(num2[power_of_ten_num2])

                product = num1_digit * num2_digit
                temporary_total = total[power_of_ten_num1 + power_of_ten_num2 + 1] + product
                total[power_of_ten_num1 + power_of_ten_num2 + 1] = temporary_total % 10
                total[power_of_ten_num1 + power_of_ten_num2] += temporary_total // 10

        product = ''.join(map(str, total)).lstrip('0')
        return product if product else "0"

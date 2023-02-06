"""
https://leetcode.com/problems/add-strings/
"""


class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        output = []
        carry = 0
        first_number_index = len(num1) - 1
        second_number_index = len(num2) - 1
        zero_code = ord('0')
        while first_number_index >= 0 or second_number_index >= 0 or carry == 1:
            first_digit = 0 if first_number_index < 0 else ord(num1[first_number_index]) - zero_code
            second_digit = 0 if second_number_index < 0 else ord(num2[second_number_index]) - zero_code
            digit_sum = int(first_digit + second_digit + carry)
            output.append(digit_sum % 10)
            carry = int(digit_sum / 10)

            first_number_index -= 1
            second_number_index -= 1

        return "".join(map(str, reversed(output)))

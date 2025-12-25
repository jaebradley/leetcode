"""
Given a string s, return whether s is a valid number.

For example, all the following are valid numbers: "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789", while the following are not valid numbers: "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53".

Formally, a valid number is defined using one of the following definitions:

An integer number followed by an optional exponent.
A decimal number followed by an optional exponent.
An integer number is defined with an optional sign '-' or '+' followed by digits.
A decimal number is defined with an optional sign '-' or '+' followed by one of the following definitions:

Digits followed by a dot '.'.
Digits followed by a dot '.' followed by digits.
A dot '.' followed by digits.
An exponent is defined with an exponent notation 'e' or 'E' followed by an integer number.

The digits are defined as one or more digits.

Example 1:
Input: s = "0"
Output: true

Example 2:
Input: s = "e"
Output: false

Example 3:
Input: s = "."
Output: false

Constraints:
1 <= s.length <= 20
s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.
"""


class Solution:
    """
    Break up identification between whether the string is a valid integer number or a valid decimal number.

    Integer numbers are defined with an optional sign.
    Signs are followed by digits.
    Digits are followed by an optional exponent.
    Exponent is e or E followed by an integer number.

    Decimal numbers also followed by an optional exponent.
    Also have a sign.
    Can be optional digits followed by a dot.
    Optional digits can follow the dot.
    """

    def isNumber(self, s: str) -> bool:
        def is_integer(candidate: str) -> bool:
            for index, character in enumerate(candidate):
                if not character.isdigit():
                    if not (index == 0 and (character == "-" or character == "+")):
                        return False

            return (len(candidate) > 1 and (candidate[0] == "-" or candidate[0] == "+")) or (len(candidate) > 0 and candidate[0].isdigit())

        def is_non_decimal_number(candidate: str) -> bool:
            lower_cased_candidate = candidate.lower()
            numbers = lower_cased_candidate.split("e")
            return len(numbers) <= 2 and all(map(lambda number: len(number) > 0, numbers)) and all(map(lambda number: is_integer(number), numbers))

        def is_decimal(candidate: str) -> bool:
            lower_cased_candidate = candidate.lower()
            parts = lower_cased_candidate.split("e")
            before_exponent, is_valid_exponent = parts[0], True

            if len(parts) == 2:
                is_valid_exponent = is_integer(parts[1])
            elif len(parts) >= 3:
                return False

            decimal_parts = before_exponent.split(".")
            if len(decimal_parts) == 0:
                return False

            if len(decimal_parts) == 1:
                return is_integer(decimal_parts[0]) and is_valid_exponent

            if len(decimal_parts) == 2:
                if is_integer(decimal_parts[0]):
                    return (decimal_parts[1].isdigit() or decimal_parts[1] == "") and is_valid_exponent
                elif decimal_parts[0] == "" or decimal_parts[0] == "-" or decimal_parts[0] == "+":
                    return decimal_parts[1].isdigit() and is_valid_exponent

            return False

        return is_non_decimal_number(s) or is_decimal(s)

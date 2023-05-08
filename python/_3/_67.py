class Solution:
    def addBinary(self, a: str, b: str) -> str:
        carry = False
        max_input_length = max(len(a), len(b))
        result = ""
        for index in range(1, max_input_length + 1):
            a_digit = a[len(a) - index] if index <= len(a) else "0"
            b_digit = b[len(b) - index] if index <= len(b) else "0"
            if carry:
                if a_digit == b_digit:
                    result += "1"
                    carry = "1" == a_digit
                else:
                    result += "0"
            else:
                if a_digit == b_digit:
                    result += "0"
                    carry = "1" == a_digit
                else:
                    result += "1"

        if carry:
            result += "1"

        return result[::-1]

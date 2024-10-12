import pytest

from _151 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            ("the sky is blue", "blue is sky the"),
            ("  hello world  ", "world hello"),
            ("a good   example", "example good a"),
        ])
    def test(self, input, expected):
        assert expected == Solution().reverseWords(input)

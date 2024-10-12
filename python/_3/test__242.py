import pytest

from _242 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (["anagram", "nagaram"], True),
            (["rat", "car"], False),
            (["a", "ab"], False)
        ])
    def test(self, inputs, expected):
        assert expected == Solution().isAnagram(*inputs)

import pytest

from _290 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, result",
        [
            (["abba", "dog cat cat dog"], True),
            (["abba", "dog cat cat fish"], False),
            (["aaaa", "dog cat cat dog"], False),
        ])
    def test(self, arguments, result):
        assert Solution().wordPattern(*arguments) == result

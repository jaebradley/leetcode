import pytest

from _383 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, result",
        [
            (["a", "b"], False),
            (["aa", "ab"], False),
            (["aa", "aab"], True),
        ])
    def test(self, arguments, result):
        assert Solution().canConstruct(*arguments) == result

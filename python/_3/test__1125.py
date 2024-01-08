import pytest

from _1125 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "arguments, expected",
        [
            ([
                 ["java", "nodejs", "reactjs"],
                 [["java"], ["nodejs"], ["nodejs", "reactjs"]]
             ],
             [0, 2]),
            ([
                 ["algorithms", "math", "java", "reactjs", "csharp", "aws"],
                 [
                     ["algorithms", "math", "java"],
                     ["algorithms", "math", "reactjs"],
                     ["java", "csharp", "aws"],
                     ["reactjs", "csharp"],
                     ["csharp", "math"],
                     ["aws", "java"]
                 ]],
             [1, 2]),
        ])
    def test(self, arguments, expected):
        assert Solution().smallestSufficientTeam(*arguments) == expected

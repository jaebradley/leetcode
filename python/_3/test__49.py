import pytest

from _49 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "strings, expected",
        [
            (
                    ["eat","tea","tan","ate","nat","bat"],
                    [["bat"],["nat","tan"],["ate","eat","tea"]]
            ),
            (
                [""], [[""]]
            ),
            (
                ["a"], [["a"]]
            )
        ])
    def test(self, strings, expected):
        sorted_expected_values = list(map(lambda values: sorted(values), expected))
        groups = Solution().groupAnagrams(strings)
        groups2 = Solution().groupAnagramsByCount(strings)
        assert len(groups) == len(expected)
        assert len(groups2) == len(expected)
        for group in groups:
            assert sorted(group) in sorted_expected_values

        for group in groups2:
            assert sorted(group) in sorted_expected_values

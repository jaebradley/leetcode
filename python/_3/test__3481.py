import pytest

from _3481 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        (
                (([["A","abc"],["B","def"]], "%A%_%B%"), "abc_def"),
                (([["A","bce"],["B","ace"],["C","abc%B%"]], "%A%_%B%_%C%"), "bce_ace_abcace"),
                (([["A","bce"],["B","%D%"],["C","abc%B%"],["D", "jae"]], "%A%_%B%_%C%"), "bce_jae_abcjae"),
                (([["Z","kqes"],["B","%Z%e%Z%"]], "%Z%_%B%"), "kqes_kqesekqes"),
        ))
    def test(self, inputs, expected):
        assert Solution().applySubstitutions(*inputs) == expected

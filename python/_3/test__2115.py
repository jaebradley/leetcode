import pytest

from _2115 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            # ([["bread"], [["yeast", "flour"]], ["yeast", "flour", "corn"]], ["bread"]),
            # ([
            #      ["bread", "sandwich"],
            #      [["yeast", "flour"], ["bread", "meat"]],
            #      ["yeast", "flour", "meat"]],
            #  ["bread", "sandwich"]),
            # ([
            #      ["bread", "sandwich", "burger"],
            #      [["yeast", "flour"], ["bread", "meat"], ["sandwich", "meat", "bread"]],
            #      ["yeast", "flour", "meat"]],
            #  ["bread", "sandwich", "burger"]),
            ([
                 ["xevvq", "izcad", "p", "we", "bxgnm", "vpio", "i", "hjvu", "igi", "anp", "tokfq", "z", "kwdmb", "g",
                  "qb", "q", "b", "hthy"],
                 [["wbjr"], ["otr", "fzr", "g"], ["fzr", "wi", "otr", "xgp", "wbjr", "igi", "b"],
                  ["fzr", "xgp", "wi", "otr", "tokfq", "izcad", "igi", "xevvq", "i", "anp"], ["wi", "xgp", "wbjr"],
                  ["wbjr", "bxgnm", "i", "b", "hjvu", "izcad", "igi", "z", "g"], ["xgp", "otr", "wbjr"],
                  ["wbjr", "otr"],
                  ["wbjr", "otr", "fzr", "wi", "xgp", "hjvu", "tokfq", "z", "kwdmb"],
                  ["xgp", "wi", "wbjr", "bxgnm", "izcad", "p", "xevvq"], ["bxgnm"], ["wi", "fzr", "otr", "wbjr"],
                  ["wbjr", "wi", "fzr", "xgp", "otr", "g", "b", "p"], ["otr", "fzr", "xgp", "wbjr"],
                  ["xgp", "wbjr", "q", "vpio", "tokfq", "we"], ["wbjr", "wi", "xgp", "we"], ["wbjr"], ["wi"]],
                 ["wi", "otr", "wbjr", "fzr", "xgp"],
             ],
             ["xevvq", "izcad", "bxgnm", "i", "hjvu", "tokfq", "z", "g", "b", "hthy"])
        ])
    def test(self, inputs, expected):
        assert set(expected) == set(Solution().findAllRecipes(*inputs))

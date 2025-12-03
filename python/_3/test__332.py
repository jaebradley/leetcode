import pytest

from _332 import Solution


class TestSolution:
    @pytest.mark.parametrize(
        "itinerary, expected",
        [
            ([["JFK", "SFO"], ["JFK", "ATL"], ["SFO", "ATL"], ["ATL", "JFK"], ["ATL", "SFO"]],
             ["JFK", "ATL", "JFK", "SFO", "ATL", "SFO"]),
            ([["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]], ["JFK", "MUC", "LHR", "SFO", "SJC"]),
        ])
    def test(self, itinerary, expected):
        assert Solution().findItinerary(itinerary) == expected

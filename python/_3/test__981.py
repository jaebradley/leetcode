import pytest

from _981 import TimeMap


class TestSolution:
    def test(self):
        tm = TimeMap()
        tm.set("foo", "bar", 1)
        assert tm.get("foo", 1) == "bar"
        assert tm.get("foo", 3) == "bar"

        tm.set("foo", "bar2", 4)
        assert tm.get("foo", 5) == "bar2"
        assert tm.get("foo", 4) == "bar2"
        assert tm.get("foo", 3) == "bar"
        assert tm.get("foo", 2) == "bar"
        assert tm.get("foo", 1) == "bar"

        tm2 = TimeMap()
        tm2.set("love", "high", 10)
        tm2.set("love", "low", 20)
        assert tm2.get("love", 5) == ""
        assert tm2.get("love", 10) == "high"
        assert tm2.get("love", 15) == "high"
        assert tm2.get("love", 20) == "low"
        assert tm2.get("love", 25) == "low"

        tm3 = TimeMap()
        tm3.set("a", "b", 1)
        tm3.set("b", "c", 2)
        assert tm3.get("a", 2) == "b"



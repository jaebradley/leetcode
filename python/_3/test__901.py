from _901 import StockSpanner


class TestSolution:
    def test(self):
        spanner = StockSpanner()
        assert 1 == spanner.next(100)
        assert 1 == spanner.next(80)
        assert 1 == spanner.next(60)
        assert 2 == spanner.next(70)
        assert 1 == spanner.next(60)
        assert 4 == spanner.next(75)
        assert 6 == spanner.next(85)

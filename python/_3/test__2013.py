from _2013 import DetectSquares


class TestSolution:
    def test(self):
        ds = DetectSquares()
        ds.add([3, 10])
        ds.add([11, 2])
        ds.add([3, 2])
        assert ds.count([11, 10]) == 1
        assert ds.count([14, 8]) == 0
        ds.add([11, 2])
        assert ds.count([11, 10]) == 2

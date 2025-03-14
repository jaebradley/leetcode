from _303 import NumArray


class TestSolution:
    def test(self):
        num_array = NumArray([-2, 0, 3, -5, 2, -1])
        assert 1 == num_array.sumRange(0, 2)
        assert -1 == num_array.sumRange(2, 5)
        assert -3 == num_array.sumRange(0, 5)

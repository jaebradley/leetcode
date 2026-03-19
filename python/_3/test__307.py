from _307 import NumArray


class TestNumArray:
    def test_num_array(self):
        query = NumArray(nums=[1])
        assert 1 == query.sumRange(0, 0)

        query.update(0, 0)
        assert 0 == query.sumRange(0, 0)

        query2 = NumArray(nums=[1, 2])
        assert 3 == query2.sumRange(0, 1)

        assert 2 == query2.sumRange(1, 1)

        query2.update(0, 2)
        assert 4 == query2.sumRange(0, 1)

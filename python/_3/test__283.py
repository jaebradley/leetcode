from _283 import Solution


class TestSolution:
    def test(self):
        single_zero = [0]
        Solution().moveZeroes(single_zero)

        assert single_zero == [0]

        multiple = [0, 1, 0, 3, 12]
        Solution().moveZeroes(multiple)
        assert multiple == [1, 3, 12, 0, 0]

        single_non_zero = [1]
        Solution().moveZeroes(single_non_zero)
        assert single_non_zero == [1]

        one_then_zero = [1, 0]
        Solution().moveZeroes(one_then_zero)
        assert one_then_zero == [1, 0]

        zero_then_one = [0, 1]
        Solution().moveZeroes(zero_then_one)
        assert zero_then_one == [1, 0]

        another = [4, 2, 4, 0, 0, 3, 0, 5, 1, 0]
        Solution().moveZeroes(another)
        assert another == [4, 2, 4, 3, 5, 1, 0, 0, 0, 0]

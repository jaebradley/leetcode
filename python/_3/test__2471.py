import pytest

from _2471 import Solution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "input, expected",
        [
            (
                    TreeNode(
                        1,
                        TreeNode(
                            4,
                            TreeNode(7),
                            TreeNode(6)
                        ),
                        TreeNode(
                            3,
                            TreeNode(8, TreeNode(9)),
                            TreeNode(5, TreeNode(10))
                        )),
                    3),
            (
                    TreeNode(
                        1,
                        TreeNode(
                            3,
                            TreeNode(7),
                            TreeNode(6)
                        ),
                        TreeNode(
                            2,
                            TreeNode(5),
                            TreeNode(4)
                        )),
                    3),
            (
                    TreeNode(
                        1,
                        TreeNode(
                            2,
                            TreeNode(4),
                            TreeNode(5)
                        ),
                        TreeNode(
                            3,
                            TreeNode(6),
                            TreeNode(7)
                        )),
                    0)
        ])
    def test(self, input, expected):
        assert Solution().minimumOperations(input) == expected

import pytest

from _1028 import Solution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            (
                    ["1-2--3--4-5--6--7"],
                    TreeNode(
                        1,
                        TreeNode(
                            2,
                            TreeNode(3),
                            TreeNode(4)
                        ),
                        TreeNode(
                            5,
                            TreeNode(6),
                            TreeNode(7)
                        )
                    )
            ),
            (
                    ["1-2--3---4-5--6---7"],
                    TreeNode(
                        1,
                        TreeNode(
                            2,
                            TreeNode(
                                3,
                                TreeNode(4)
                            )
                        ),
                        TreeNode(
                            5,
                            TreeNode(
                                6,
                                TreeNode(7)
                            )
                        )
                    )
            ),
            (
                    ["1-401--349---90--88"],
                    TreeNode(
                        1,
                        TreeNode(
                            401,
                            TreeNode(
                                349,
                                TreeNode(90)
                            ),
                            TreeNode(88)
                        )
                    )
            ),
        ])
    def test(self, inputs, expected):
        assert Solution().recoverFromPreorder(*inputs) == expected

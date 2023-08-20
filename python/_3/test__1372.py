import pytest

from _1372 import Solution, TreeNode


class TestSolution:
    @pytest.mark.parametrize(
        "inputs, expected",
        [
            ([
                 TreeNode(
                     1,
                     None,
                     TreeNode(1,
                              TreeNode(1),
                              TreeNode(1,
                                       TreeNode(1,
                                                None,
                                                TreeNode(1,
                                                         None,
                                                         TreeNode(1,
                                                                  None,
                                                                  TreeNode(1)))),
                                       TreeNode(1)))
                 )
             ],
             3),
        ])
    def test(self, inputs, expected):
        assert Solution().longestZigZag(*inputs) == expected

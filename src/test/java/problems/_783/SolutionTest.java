package problems._783;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                1,
                new Solution().minDiffInBST(
                        new Solution.TreeNode(
                                4,
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(1),
                                        new Solution.TreeNode(3)
                                ),
                                new Solution.TreeNode(6)
                        )
                )
        );

        assertEquals(
                1,
                new Solution().minDiffInBST(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(0),
                                new Solution.TreeNode(
                                        48,
                                        new Solution.TreeNode(12),
                                        new Solution.TreeNode(49)
                                )
                        )
                )
        );

        assertEquals(
                1,
                new Solution().minDiffInBST(
                        new Solution.TreeNode(
                                90,
                                new Solution.TreeNode(
                                        69,
                                        new Solution.TreeNode(
                                                49,
                                                null,
                                                new Solution.TreeNode(59)
                                        ),
                                        new Solution.TreeNode(89)
                                ),
                                null
                        )
                )
        );
    }
}
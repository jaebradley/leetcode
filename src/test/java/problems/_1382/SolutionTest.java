package problems._1382;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    public void test() {
        assertEquals(
                new Solution.TreeNode(
                        2,
                        new Solution.TreeNode(1),
                        new Solution.TreeNode(
                                3,
                                null,
                                new Solution.TreeNode(4)
                        )
                ),
                new Solution().balanceBST(
                        new Solution.TreeNode(
                                1,
                                null,
                                new Solution.TreeNode(
                                        2,
                                        null,
                                        new Solution.TreeNode(
                                                3,
                                                null,
                                                new Solution.TreeNode(4)
                                        )
                                )
                        )
                )
        );

        assertEquals(
                new Solution.TreeNode(
                        2,
                        new Solution.TreeNode(1),
                        new Solution.TreeNode(3)
                ),
                new Solution().balanceBST(
                        new Solution.TreeNode(
                                2,
                                new Solution.TreeNode(1),
                                new Solution.TreeNode(3)
                        )
                )
        );

        assertEquals(
                new Solution.TreeNode(
                        2,
                        new Solution.TreeNode(1),
                        new Solution.TreeNode(
                                3,
                                null,
                                new Solution.TreeNode(4)
                        )
                ),
                new Solution().balanceBST(
                        new Solution.TreeNode(
                                4,
                                new Solution.TreeNode(
                                        3,
                                        new Solution.TreeNode(
                                                2,
                                                new Solution.TreeNode(1),
                                                null
                                        ),
                                        null
                                ),
                                null
                        )
                )
        );
    }
}
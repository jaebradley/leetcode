package problems._958;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertTrue(
                new Solution().isCompleteTree(
                        new Solution.TreeNode(1)
                )
        );

        assertTrue(
                new Solution().isCompleteTree(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(2),
                                null
                        )
                )
        );

        assertTrue(
                new Solution().isCompleteTree(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(2),
                                new Solution.TreeNode(3)
                        )
                )
        );

        assertFalse(
                new Solution().isCompleteTree(
                        new Solution.TreeNode(
                                1,
                                null,
                                new Solution.TreeNode(2)
                        )
                )
        );

        assertFalse(
                new Solution().isCompleteTree(
                        new Solution.TreeNode(
                                1,
                                null,
                                new Solution.TreeNode(
                                        2,
                                        null,
                                        new Solution.TreeNode(3)
                                )
                        )
                )
        );

        assertFalse(
                new Solution().isCompleteTree(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(2),
                                new Solution.TreeNode(
                                        3,
                                        null,
                                        new Solution.TreeNode(4)
                                )
                        )
                )
        );
    }
}
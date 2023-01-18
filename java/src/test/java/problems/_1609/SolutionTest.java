package problems._1609;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertTrue(
                new Solution().isEvenOddTree(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        10,
                                        new Solution.TreeNode(
                                                3,
                                                new Solution.TreeNode(12),
                                                new Solution.TreeNode(8)
                                        ),
                                        null
                                ),
                                new Solution.TreeNode(
                                        4,
                                        new Solution.TreeNode(7, new Solution.TreeNode(6), null),
                                        new Solution.TreeNode(9, null, new Solution.TreeNode(2))
                                )
                        )
                )
        );

        assertFalse(
                new Solution().isEvenOddTree(
                        new Solution.TreeNode(
                                5,
                                new Solution.TreeNode(
                                        4,
                                        new Solution.TreeNode(3),
                                        new Solution.TreeNode(3)
                                ),
                                new Solution.TreeNode(2, new Solution.TreeNode(7), null)
                        )
                )
        );
    }
}
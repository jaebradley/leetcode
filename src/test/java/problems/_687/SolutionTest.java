package problems._687;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                2,
                new Solution().longestUnivaluePath(
                        new Solution.TreeNode(
                                5,
                                new Solution.TreeNode(
                                        4,
                                        new Solution.TreeNode(1),
                                        new Solution.TreeNode(1)
                                ),
                                new Solution.TreeNode(
                                        5,
                                        null,
                                        new Solution.TreeNode(5)
                                )
                        )
                )
        );

        assertEquals(
                2,
                new Solution().longestUnivaluePath(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        4,
                                        new Solution.TreeNode(4),
                                        new Solution.TreeNode(4)
                                ),
                                new Solution.TreeNode(
                                        5,
                                        null,
                                        new Solution.TreeNode(5)
                                )
                        )
                )
        );
    }
}
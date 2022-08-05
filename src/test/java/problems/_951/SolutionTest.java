package problems._951;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertTrue(new Solution().flipEquiv(new Solution.TreeNode(), new Solution.TreeNode()));
        assertFalse(new Solution().flipEquiv(new Solution.TreeNode(), new Solution.TreeNode(1)));
        assertTrue(
                new Solution().flipEquiv(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(4),
                                        new Solution.TreeNode(
                                                5,
                                                new Solution.TreeNode(7),
                                                new Solution.TreeNode(8)
                                        )
                                ),
                                new Solution.TreeNode(
                                        3,
                                        new Solution.TreeNode(6),
                                        null
                                )
                        ),
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        3,
                                        null,
                                        new Solution.TreeNode(6)
                                ),
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(
                                                5,
                                                new Solution.TreeNode(7),
                                                new Solution.TreeNode(8)
                                        ),
                                        new Solution.TreeNode(4)
                                )
                        )
                )
        );
    }
}
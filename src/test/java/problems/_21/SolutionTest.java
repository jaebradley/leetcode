package problems._21;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertTrue(
                new Solution().findTarget(
                        new Solution.TreeNode(
                                5,
                                new Solution.TreeNode(
                                        3,
                                        new Solution.TreeNode(2),
                                        new Solution.TreeNode(4)
                                ),
                                new Solution.TreeNode(6, null, new Solution.TreeNode(7))
                        ),
                        9
                )
        );

        assertFalse(
                new Solution().findTarget(
                        new Solution.TreeNode(
                                5,
                                new Solution.TreeNode(
                                        3,
                                        new Solution.TreeNode(2),
                                        new Solution.TreeNode(4)
                                ),
                                new Solution.TreeNode(6, null, new Solution.TreeNode(7))
                        ),
                        28
                )
        );
    }
}
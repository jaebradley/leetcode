package problems._965;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertTrue(
                new Solution().isUnivalTree(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(1),
                                new Solution.TreeNode(1)
                        )
                )
        );

        assertFalse(
                new Solution().isUnivalTree(
                        new Solution.TreeNode(1, new Solution.TreeNode(2), null)
                )
        );
    }
}
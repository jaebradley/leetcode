package problems._39;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void testEmptyRoot() {
        assertNull(new Solution().removeLeafNodes(null, 1));
    }

    public void testRootHasTargetValue() {
        assertNull(new Solution().removeLeafNodes(new Solution.TreeNode(1), 1));
    }

    public void testLeftSideHasTargetValue() {
        assertEquals(
                new Solution.TreeNode(
                        2,
                        null,
                        new Solution.TreeNode(
                                3,
                                new Solution.TreeNode(4),
                                new Solution.TreeNode(5)
                        )
                ),
                new Solution().removeLeafNodes(
                        new Solution.TreeNode(
                                2,
                                new Solution.TreeNode(
                                        1,
                                        new Solution.TreeNode(1),
                                        null
                                ),
                                new Solution.TreeNode(
                                        3,
                                        new Solution.TreeNode(4),
                                        new Solution.TreeNode(5)
                                )
                        ),
                        1
                )
        );
    }
}
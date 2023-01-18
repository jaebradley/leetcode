package problems._1026;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                7,
                new Solution().maxAncestorDiff(
                        new Solution.TreeNode(
                                8,
                                new Solution.TreeNode(
                                        3,
                                        new Solution.TreeNode(1),
                                        new Solution.TreeNode(
                                                6,
                                                new Solution.TreeNode(4),
                                                new Solution.TreeNode(7)
                                        )
                                ),
                                new Solution.TreeNode(
                                        10,
                                        null,
                                        new Solution.TreeNode(
                                                14,
                                                new Solution.TreeNode(13),
                                                null
                                        )
                                )
                        )
                )
        );

        assertEquals(0, new Solution().maxAncestorDiff(new Solution.TreeNode(1)));
        assertEquals(0, new Solution().maxAncestorDiff(new Solution.TreeNode(1, new Solution.TreeNode(1), null)));
        assertEquals(
                3,
                new Solution().maxAncestorDiff(
                        new Solution.TreeNode(
                                1,
                                null,
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(0, new Solution.TreeNode(3), null),
                                        null
                                )
                        )
                )
        );
    }
}
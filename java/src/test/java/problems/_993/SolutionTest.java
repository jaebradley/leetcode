package problems._993;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertFalse(
                new Solution().isCousins(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(4),
                                        null
                                ),
                                new Solution.TreeNode(3)
                        ),
                        4,
                        3
                )
        );

        assertTrue(
                new Solution().isCousins(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        2,
                                        null,
                                        new Solution.TreeNode(4)
                                ),
                                new Solution.TreeNode(
                                        3,
                                        null,
                                        new Solution.TreeNode(5)
                                )
                        ),
                        5,
                        4
                )
        );

        assertFalse(
                new Solution().isCousins(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        2,
                                        null,
                                        new Solution.TreeNode(4)
                                ),
                                new Solution.TreeNode(
                                        3,
                                        null,
                                        new Solution.TreeNode(5)
                                )
                        ),
                        6,
                        4
                )
        );

        assertFalse(
                new Solution().isCousins(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        2,
                                        null,
                                        new Solution.TreeNode(4)
                                ),
                                new Solution.TreeNode(3)
                        ),
                        2,
                        3
                )
        );

        assertTrue(
                new Solution().isCousins(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(3, null, new Solution.TreeNode(7)),
                                        new Solution.TreeNode(8)
                                ),
                                new Solution.TreeNode(
                                        4,
                                        new Solution.TreeNode(6),
                                        new Solution.TreeNode(8)
                                )
                        ),
                        5,
                        8
                )
        );
    }
}
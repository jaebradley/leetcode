package problems._988;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                "dba",
                new Solution().smallestFromLeaf(
                        new Solution.TreeNode(
                                0,
                                new Solution.TreeNode(
                                        1,
                                        new Solution.TreeNode(3),
                                        new Solution.TreeNode(4)
                                ),
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(5),
                                        new Solution.TreeNode(6)
                                )
                        )
                )
        );

        assertEquals(
                "adz",
                new Solution().smallestFromLeaf(
                        new Solution.TreeNode(
                                25,
                                new Solution.TreeNode(
                                        1,
                                        new Solution.TreeNode(1),
                                        new Solution.TreeNode(3)
                                ),
                                new Solution.TreeNode(
                                        3,
                                        new Solution.TreeNode(0),
                                        new Solution.TreeNode(2)
                                )
                        )
                )
        );

        assertEquals(
                "abc",
                new Solution().smallestFromLeaf(
                        new Solution.TreeNode(
                                2,
                                new Solution.TreeNode(
                                        2,
                                        null,
                                        new Solution.TreeNode(1, new Solution.TreeNode(0), null)
                                ),
                                new Solution.TreeNode(
                                        1,
                                        new Solution.TreeNode(0),
                                        null
                                )
                        )
                )
        );

        assertEquals(
                "bae",
                new Solution().smallestFromLeaf(
                        new Solution.TreeNode(
                                4,
                                new Solution.TreeNode(
                                        0,
                                        new Solution.TreeNode(1),
                                        null
                                ),
                                new Solution.TreeNode(1)
                        )
                )
        );
    }
}
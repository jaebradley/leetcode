package problems._865;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                new Solution.TreeNode(
                        2,
                        new Solution.TreeNode(7),
                        new Solution.TreeNode(4)
                ),
                new Solution().subtreeWithAllDeepest(
                        new Solution.TreeNode(
                                3,
                                new Solution.TreeNode(
                                        5,
                                        new Solution.TreeNode(6),
                                        new Solution.TreeNode(
                                                2,
                                                new Solution.TreeNode(7),
                                                new Solution.TreeNode(4)
                                        )
                                ),
                                new Solution.TreeNode(
                                        1,
                                        new Solution.TreeNode(0),
                                        new Solution.TreeNode(8)
                                )
                        )
                )
        );

        assertEquals(new Solution.TreeNode(1), new Solution().subtreeWithAllDeepest(new Solution.TreeNode(1)));
        assertEquals(
                new Solution.TreeNode(2),
                new Solution().subtreeWithAllDeepest(
                        new Solution.TreeNode(
                                0,
                                new Solution.TreeNode(1),
                                new Solution.TreeNode(
                                        3,
                                        null,
                                        new Solution.TreeNode(2)
                                )
                        )
                )
        );
    }
}
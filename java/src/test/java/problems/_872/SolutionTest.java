package problems._872;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    public void test() {
        assertTrue(
                new Solution().leafSimilar(
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
                                        new Solution.TreeNode(9),
                                        new Solution.TreeNode(8)
                                )
                        ),
                        new Solution.TreeNode(
                                3,
                                new Solution.TreeNode(
                                        5,
                                        new Solution.TreeNode(6),
                                        new Solution.TreeNode(7)
                                ),
                                new Solution.TreeNode(
                                        1,
                                        new Solution.TreeNode(4),
                                        new Solution.TreeNode(
                                                2,
                                                new Solution.TreeNode(9),
                                                new Solution.TreeNode(8)
                                        )
                                )
                        )

                )
        );
    }
}
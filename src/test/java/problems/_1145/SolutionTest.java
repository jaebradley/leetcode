package problems._1145;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertTrue(
                new Solution().btreeGameWinningMove(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(
                                                4,
                                                new Solution.TreeNode(8),
                                                new Solution.TreeNode(9)
                                        ),
                                        new Solution.TreeNode(
                                                5,
                                                new Solution.TreeNode(10),
                                                new Solution.TreeNode(11)
                                        )
                                ),
                                new Solution.TreeNode(
                                        3,
                                        new Solution.TreeNode(6),
                                        new Solution.TreeNode(7)
                                )
                        ),
                        11,
                        3
                )
        );

        assertFalse(
                new Solution().btreeGameWinningMove(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(2),
                                new Solution.TreeNode(3)
                        ),
                        3,
                        1
                )
        );
    }
}
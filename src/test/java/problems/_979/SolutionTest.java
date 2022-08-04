package problems._979;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(2, new Solution().distributeCoins(new Solution.TreeNode(3, new Solution.TreeNode(0), new Solution.TreeNode(0))));
        assertEquals(
                3,
                new Solution().distributeCoins(
                        new Solution.TreeNode(
                                0,
                                new Solution.TreeNode(3),
                                new Solution.TreeNode(0)
                        )
                )
        );
        assertEquals(
                6,
                new Solution().distributeCoins(
                        new Solution.TreeNode(
                                4,
                                new Solution.TreeNode(
                                        0,
                                        null,
                                        new Solution.TreeNode(
                                                0,
                                                null,
                                                new Solution.TreeNode(0)
                                        )
                                ),
                                null
                        )
                )
        );
    }
}
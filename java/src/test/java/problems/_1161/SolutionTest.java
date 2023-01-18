package problems._1161;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                1,
                new Solution().maxLevelSum(new Solution.TreeNode(1))
        );

        assertEquals(
                2,
                new Solution().maxLevelSum(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        7,
                                        new Solution.TreeNode(7),
                                        new Solution.TreeNode(-8)
                                ),
                                new Solution.TreeNode(0)
                        )
                )
        );

        assertEquals(
                3,
                new Solution().maxLevelSum(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(3),
                                        null
                                ),
                                new Solution.TreeNode(
                                        2,
                                        null,
                                        new Solution.TreeNode(3)
                                )
                        )
                )
        );
    }
}
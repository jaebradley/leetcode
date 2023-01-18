package problems._1339;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                110,
                new Solution().maxProduct(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(4),
                                        new Solution.TreeNode(5)
                                ),
                                new Solution.TreeNode(
                                        3,
                                        new Solution.TreeNode(6),
                                        null
                                )
                        )
                )
        );

        assertEquals(
                90,
                new Solution().maxProduct(
                        new Solution.TreeNode(
                                1,
                                null,
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(3),
                                        new Solution.TreeNode(
                                                4,
                                                new Solution.TreeNode(5),
                                                new Solution.TreeNode(6)
                                        )
                                )
                        )
                )
        );
    }
}
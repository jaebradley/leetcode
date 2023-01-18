package problems._2096;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    public void test() {
        assertEquals(
                "L",
                new Solution()
                        .getDirections(
                                new Solution.TreeNode(2, new Solution.TreeNode(1), null),
                                2,
                                1
                        )
        );

        assertEquals(
                "UURL",
                new Solution().getDirections(
                        new Solution.TreeNode(
                                5,
                                new Solution.TreeNode(
                                        1,
                                        new Solution.TreeNode(3),
                                        null
                                ),
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(6),
                                        new Solution.TreeNode(4)
                                )
                        ),
                        3,
                        6
                )
        );
    }
}
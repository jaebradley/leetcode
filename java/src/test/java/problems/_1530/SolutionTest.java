package problems._1530;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(
                1,
                new Solution().countPairs(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        2,
                                        null,
                                        new Solution.TreeNode(4)
                                ),
                                new Solution.TreeNode(3)
                        ),
                        3
                )
        );

        assertEquals(
                2,
                new Solution().countPairs(
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
                                        new Solution.TreeNode(7)
                                )
                        ),
                        3
                )
        );

        assertEquals(
                0,
                new Solution().countPairs(
                        new Solution.TreeNode(1),
                        1
                )
        );
    }
}
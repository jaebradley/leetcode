package problems._889;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    public void test() {
        assertEquals(
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
                new Solution().constructFromPrePost(
                        new int[]{1,2,4,5,3,6,7},
                        new int[]{4,5,2,6,7,3,1}
                )
        );

        assertEquals(
                new Solution.TreeNode(1),
                new Solution().constructFromPrePost(
                        new int[]{1},
                        new int[]{1}
                )
        );

        assertEquals(
                new Solution.TreeNode(
                        2,
                        new Solution.TreeNode(1),
                        null
                ),
                new Solution().constructFromPrePost(
                        new int[]{2, 1},
                        new int[]{1, 2}
                )
        );
    }
}
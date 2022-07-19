package problems._501;

import junit.framework.TestCase;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest extends TestCase {

    public void test() {
        assertArrayEquals(
                new int[]{2},
                new Solution().findMode(
                        new Solution.TreeNode(
                                1,
                                null,
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(2),
                                        null
                                )
                        )
                )
        );

        assertArrayEquals(
                new int[]{0},
                new Solution().findMode(new Solution.TreeNode(0))
        );

        assertArrayEquals(
                new int[]{-1, 0},
                new Solution().findMode(new Solution.TreeNode(0, new Solution.TreeNode(-1), null))
        );
    }
}
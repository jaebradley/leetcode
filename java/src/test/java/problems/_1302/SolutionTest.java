package problems._1302;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {
    public void test() {
        assertEquals(
                15,
                new Solution().deepestLeavesSum(
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(4, new Solution.TreeNode(7), null),
                                        new Solution.TreeNode(5)
                                ),
                                new Solution.TreeNode(
                                        3,
                                        null,
                                        new Solution.TreeNode(6, null, new Solution.TreeNode(8))
                                )
                        )
                )
        );
    }
}
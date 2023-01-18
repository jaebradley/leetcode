package problems._1315;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        assertEquals(0, new Solution().sumEvenGrandparent(new Solution.TreeNode(1)));
        assertEquals(
                18,
                new Solution().sumEvenGrandparent(
                        new Solution.TreeNode(
                                6,
                                new Solution.TreeNode(
                                        7,
                                        new Solution.TreeNode(
                                                2,
                                                new Solution.TreeNode(9),
                                                null
                                        ),
                                        new Solution.TreeNode(
                                                7,
                                                new Solution.TreeNode(1),
                                                new Solution.TreeNode(4)
                                        )
                                ),
                                new Solution.TreeNode(
                                        8,
                                        new Solution.TreeNode(1),
                                        new Solution.TreeNode(
                                                3,
                                                null,
                                                new Solution.TreeNode(5)
                                        )
                                )
                        )
                )
        );
    }
}
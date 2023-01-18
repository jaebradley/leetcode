package problems._623;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void test() {
        assertEquals(
                new Solution.TreeNode(
                        4,
                        new Solution.TreeNode(
                                1,
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(3),
                                        new Solution.TreeNode(1)
                                ),
                                null
                        ),
                        new Solution.TreeNode(
                                1,
                                null,
                                new Solution.TreeNode(
                                        6,
                                        new Solution.TreeNode(5),
                                        null
                                )
                        )
                ),
                new Solution().addOneRow(
                        new Solution.TreeNode(
                                4,
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(3),
                                        new Solution.TreeNode(1)
                                ),
                                new Solution.TreeNode(
                                        6,
                                        new Solution.TreeNode(5),
                                        null
                                )
                        ),
                        1,
                        2
                )
        );

        assertEquals(
                new Solution.TreeNode(
                        4,
                        new Solution.TreeNode(
                                2,
                                new Solution.TreeNode(
                                        1,
                                        new Solution.TreeNode(3),
                                        null
                                ),
                                new Solution.TreeNode(
                                        1,
                                        null,
                                        new Solution.TreeNode(1)
                                )
                        ),
                        null
                ),
                new Solution().addOneRow(
                        new Solution.TreeNode(
                                4,
                                new Solution.TreeNode(
                                        2,
                                        new Solution.TreeNode(3),
                                        new Solution.TreeNode(1)
                                ),
                                null
                        ),
                        1,
                        3
                )
        );
    }
}
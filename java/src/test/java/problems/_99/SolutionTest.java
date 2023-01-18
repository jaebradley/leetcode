package problems._99;

import junit.framework.TestCase;

public class SolutionTest extends TestCase {

    public void test() {
        {
            final Solution.TreeNode tree = new Solution.TreeNode(
                    1,
                    new Solution.TreeNode(
                            3,
                            null,
                            new Solution.TreeNode(2)
                    ),
                    null
            );

            new Solution().recoverTree(tree);

            assertEquals(
                    new Solution.TreeNode(
                            3,
                            new Solution.TreeNode(
                                    1,
                                    null,
                                    new Solution.TreeNode(2)
                            ),
                            null
                    ),
                    tree
            );
        }

        {
            final Solution.TreeNode tree = new Solution.TreeNode(
                    3,
                    new Solution.TreeNode(1),
                    new Solution.TreeNode(
                            4,
                            new Solution.TreeNode(2),
                            null
                    )
            );

            new Solution().recoverTree(tree);

            assertEquals(
                    new Solution.TreeNode(
                            2,
                            new Solution.TreeNode(1),
                            new Solution.TreeNode(
                                    4,
                                    new Solution.TreeNode(3),
                                    null
                            )
                    ),
                    tree
            );
        }
    }
}
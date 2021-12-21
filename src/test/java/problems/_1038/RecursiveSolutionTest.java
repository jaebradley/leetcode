package problems._1038;

import junit.framework.TestCase;

public class RecursiveSolutionTest extends TestCase {

    public void test() {
        assertEquals(
                new RecursiveSolution.TreeNode(1),
                new RecursiveSolution().bstToGst(new RecursiveSolution.TreeNode(1))
        );

        assertEquals(
                new RecursiveSolution.TreeNode(3, null, new RecursiveSolution.TreeNode(2)),
                new RecursiveSolution().bstToGst(new RecursiveSolution.TreeNode(1, null, new RecursiveSolution.TreeNode(2)))
        );

        assertEquals(
                new RecursiveSolution.TreeNode(2, new RecursiveSolution.TreeNode(3), null),
                new RecursiveSolution().bstToGst(new RecursiveSolution.TreeNode(2, new RecursiveSolution.TreeNode(1), null))
        );

        assertEquals(
                new RecursiveSolution.TreeNode(
                        30,
                        new RecursiveSolution.TreeNode(
                                36,
                                new RecursiveSolution.TreeNode(36),
                                new RecursiveSolution.TreeNode(35, null, new RecursiveSolution.TreeNode(33))
                        ),
                        new RecursiveSolution.TreeNode(
                                21,
                                new RecursiveSolution.TreeNode(26),
                                new RecursiveSolution.TreeNode(15, null, new RecursiveSolution.TreeNode(8))
                        )
                ),
                new RecursiveSolution().bstToGst(
                        new RecursiveSolution.TreeNode(
                                4,
                                new RecursiveSolution.TreeNode(
                                        1,
                                        new RecursiveSolution.TreeNode(0),
                                        new RecursiveSolution.TreeNode(2, null, new RecursiveSolution.TreeNode(3))
                                ),
                                new RecursiveSolution.TreeNode(
                                        6,
                                        new RecursiveSolution.TreeNode(5),
                                        new RecursiveSolution.TreeNode(7, null, new RecursiveSolution.TreeNode(8))
                                )
                        )
                )
        );
    }
}
package problems._1038;

import junit.framework.TestCase;

public class IterativeSolutionTest extends TestCase {

    public void test() {
        assertEquals(
                new IterativeSolution.TreeNode(1),
                new IterativeSolution().bstToGst(new IterativeSolution.TreeNode(1))
        );

        assertEquals(
                new IterativeSolution.TreeNode(3, null, new IterativeSolution.TreeNode(2)),
                new IterativeSolution().bstToGst(new IterativeSolution.TreeNode(1, null, new IterativeSolution.TreeNode(2)))
        );

        assertEquals(
                new IterativeSolution.TreeNode(2, new IterativeSolution.TreeNode(3), null),
                new IterativeSolution().bstToGst(new IterativeSolution.TreeNode(2, new IterativeSolution.TreeNode(1), null))
        );

        assertEquals(
                new IterativeSolution.TreeNode(
                        30,
                        new IterativeSolution.TreeNode(
                                36,
                                new IterativeSolution.TreeNode(36),
                                new IterativeSolution.TreeNode(35, null, new IterativeSolution.TreeNode(33))
                        ),
                        new IterativeSolution.TreeNode(
                                21,
                                new IterativeSolution.TreeNode(26),
                                new IterativeSolution.TreeNode(15, null, new IterativeSolution.TreeNode(8))
                        )
                ),
                new IterativeSolution().bstToGst(
                        new IterativeSolution.TreeNode(
                                4,
                                new IterativeSolution.TreeNode(
                                        1,
                                        new IterativeSolution.TreeNode(0),
                                        new IterativeSolution.TreeNode(2, null, new IterativeSolution.TreeNode(3))
                                ),
                                new IterativeSolution.TreeNode(
                                        6,
                                        new IterativeSolution.TreeNode(5),
                                        new IterativeSolution.TreeNode(7, null, new IterativeSolution.TreeNode(8))
                                )
                        )
                )
        );
    }
}
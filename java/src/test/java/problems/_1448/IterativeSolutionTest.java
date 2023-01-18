package problems._1448;

import org.junit.Test;

import static org.junit.Assert.*;

public class IterativeSolutionTest {
    @Test
    public void test() {
        assertEquals(
                4,
                new IterativeSolution().goodNodes(
                        new IterativeSolution.TreeNode(
                                3,
                                new IterativeSolution.TreeNode(
                                        1,
                                        new IterativeSolution.TreeNode(
                                                3,
                                                null,
                                                null
                                        ),
                                        null
                                ),
                                new IterativeSolution.TreeNode(
                                        4,
                                        new IterativeSolution.TreeNode(
                                                1,
                                                null,
                                                null
                                        ),
                                        new IterativeSolution.TreeNode(
                                                5,
                                                null,
                                                null
                                        )
                                )
                        )
                )
        );

        assertEquals(
                1,
                new IterativeSolution().goodNodes(new IterativeSolution.TreeNode(1, null, null))
        );

        assertEquals(
                3,
                new IterativeSolution().goodNodes(
                        new IterativeSolution.TreeNode(
                                3,
                                new IterativeSolution.TreeNode(
                                        3,
                                        new IterativeSolution.TreeNode(4),
                                        new IterativeSolution.TreeNode(2)
                                ),
                                null
                        )
                )
        );
    }
}
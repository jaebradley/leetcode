package problems._1448;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecursiveSolutionTest {
    @Test
    public void test() {
        assertEquals(
                4,
                new RecursiveSolution().goodNodes(
                        new RecursiveSolution.TreeNode(
                                3,
                                new RecursiveSolution.TreeNode(
                                        1,
                                        new RecursiveSolution.TreeNode(
                                                3,
                                                null,
                                                null
                                        ),
                                        null
                                ),
                                new RecursiveSolution.TreeNode(
                                        4,
                                        new RecursiveSolution.TreeNode(
                                                1,
                                                null,
                                                null
                                        ),
                                        new RecursiveSolution.TreeNode(
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
                new RecursiveSolution().goodNodes(new RecursiveSolution.TreeNode(1, null, null))
        );

        assertEquals(
                3,
                new RecursiveSolution().goodNodes(
                        new RecursiveSolution.TreeNode(
                                3,
                                new RecursiveSolution.TreeNode(
                                        3,
                                        new RecursiveSolution.TreeNode(4),
                                        new RecursiveSolution.TreeNode(2)
                                ),
                                null
                        )
                )
        );
    }

}
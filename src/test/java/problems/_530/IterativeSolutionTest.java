package problems._530;

import org.junit.Assert;
import org.junit.Test;

public class IterativeSolutionTest {

    @Test
    public void test() {
        Assert.assertEquals(
                1,
                new IterativeSolution().getMinimumDifference(
                        new IterativeSolution.TreeNode(
                                4,
                                new IterativeSolution.TreeNode(
                                        2,
                                        new IterativeSolution.TreeNode(
                                                1,
                                                null,
                                                null
                                        ),
                                        new IterativeSolution.TreeNode(
                                                3,
                                                null,
                                                null
                                        )
                                ),
                                new IterativeSolution.TreeNode(
                                        6,
                                        null,
                                        null
                                )
                        )
                )
        );
    }
}
package problems._894;

import junit.framework.TestCase;

import java.util.List;

public class RecursiveSolutionTest extends TestCase {

    public void test() {
        assertTrue(
                List.of(
                        new RecursiveSolution.TreeNode(
                                0,
                                new RecursiveSolution.TreeNode(0),
                                new RecursiveSolution.TreeNode(0)
                        )
                ).containsAll(
                        new RecursiveSolution().allPossibleFBT(3)
                )
        );

        assertTrue(
                List.of(
                        new RecursiveSolution.TreeNode(
                                0,
                                null,
                                null
                        )
                ).containsAll(
                        new RecursiveSolution().allPossibleFBT(1)
                )
        );
    }
}
package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.BinaryTreeMaximumPathSum.*;

public class BinaryTreeMaximumPathSumTest {
    @Test
    public void testSingleNode() {
        assertEquals(1, new BinaryTreeMaximumPathSum().maxPathSum(new TreeNode(1)));
    }

    @Test
    public void testThreePositiveNodes() {
        assertEquals(6,
                new BinaryTreeMaximumPathSum()
                        .maxPathSum(
                                new TreeNode(
                                        1,
                                        new TreeNode(2),
                                        new TreeNode(3)
                                )
                        )
        );
    }

    @Test
    public void testLeftPositiveChildNegativeRightChild() {
        assertEquals(3,
                new BinaryTreeMaximumPathSum()
                        .maxPathSum(
                                new TreeNode(
                                        1,
                                        new TreeNode(2),
                                        new TreeNode(-1)
                                )
                        )
        );
    }

    @Test
    public void testRightPositiveChildNegativeLeftChild() {
        assertEquals(3,
                new BinaryTreeMaximumPathSum()
                        .maxPathSum(
                                new TreeNode(
                                        1,
                                        new TreeNode(-1),
                                        new TreeNode(2)
                                )
                        )
        );
    }

    @Test
    public void testLeastNegativeValueInTreeOfOnlyNegativeValues() {
        assertEquals(-1,
                new BinaryTreeMaximumPathSum()
                .maxPathSum(
                        new TreeNode(
                                -10,
                                new TreeNode(
                                        -9,
                                        new TreeNode(-8),
                                        new TreeNode(-1)
                                ),
                                new TreeNode(
                                        -7,
                                        new TreeNode(-6),
                                        new TreeNode(-5)
                                )
                        )
                )
        );
    }
}
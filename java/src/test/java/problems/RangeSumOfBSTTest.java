package problems;

import org.junit.Test;
import problems.RangeSumOfBST.TreeNode;

import static org.junit.Assert.*;

public class RangeSumOfBSTTest {
    
    @Test
    public void testEmptyTree() {
        assertEquals(
                0,
                new RangeSumOfBST().rangeSumBST(null, 0, 10)
        );
    }

    @Test
    public void testRootNodeTreeWithinRange() {
        assertEquals(
                1,
                new RangeSumOfBST().rangeSumBST(new TreeNode(1, null, null), 0, 10)
        );
    }

    @Test
    public void testRootNodeLessThanFloor() {
        assertEquals(
                0,
                new RangeSumOfBST().rangeSumBST(new TreeNode(1, null, null), 5, 10)
        );
    }

    @Test
    public void testRootNodeGreaterThanFloor() {
        assertEquals(
                0,
                new RangeSumOfBST().rangeSumBST(new TreeNode(10, null, null), 1, 5)
        );
    }

    @Test
    public void testLeftChildWithinRange() {
        assertEquals(
                3,
                new RangeSumOfBST().rangeSumBST(
                        new TreeNode(
                                2,
                                new TreeNode(1, null, null),
                                null
                        ),
                        0,
                        10
                )
        );
    }

    @Test
    public void testRightChildWithinRange() {
        assertEquals(
                10,
                new RangeSumOfBST().rangeSumBST(
                        new TreeNode(
                                2,
                                null,
                                new TreeNode(8, null, null)
                        ),
                        0,
                        10
                )
        );
    }

    @Test
    public void testOutOfRangeLeftChildWithInRangeRightChild() {
        assertEquals(
                10,
                new RangeSumOfBST().rangeSumBST(
                        new TreeNode(
                                8,
                                new TreeNode(
                                        -10,
                                        null,
                                        new TreeNode(2, null, null)
                                ),
                                null
                        ),
                        0, 10
                )
        );
    }

    @Test
    public void testOutOfRangeRightChildWithInRangeLeftChild() {
        assertEquals(
                10,
                new RangeSumOfBST().rangeSumBST(
                        new TreeNode(
                                2,
                                null,
                                new TreeNode(
                                        20,
                                        new TreeNode(8, null, null),
                                        null
                                )
                        ),
                        0,
                        10
                )
        );
    }

}
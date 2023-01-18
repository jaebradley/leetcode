package problems;

import org.junit.Test;
import problems.SumOfLeftLeaves.TreeNode;

import static org.junit.Assert.assertEquals;

public class SumOfLeftLeavesTest {

    @Test
    public void testEmptyTree() {
        assertEquals(
                0,
                new SumOfLeftLeaves().sumOfLeftLeaves(null)
        );
    }

    @Test
    public void testTreeWithSingleRoot() {
        assertEquals(
                1,
                new SumOfLeftLeaves().sumOfLeftLeaves(
                        new TreeNode(
                                0,
                                new TreeNode(
                                        1,
                                        null,
                                        null
                                ),
                                new TreeNode(
                                        2,
                                        null,
                                        null
                                )
                        )
                )
        );

    }

    @Test
    public void testTreeWithSingleLeftChildLeaf() {
        assertEquals(
                1,
                new SumOfLeftLeaves().sumOfLeftLeaves(
                        new TreeNode(
                                0,
                                new TreeNode(
                                        1,
                                        null,
                                        null
                                ),
                                null
                        )
                )
        );

    }

    @Test
    public void testTreeWithSingleRightChildLeaf() {
        assertEquals(
                0,
                new SumOfLeftLeaves().sumOfLeftLeaves(
                        new TreeNode(
                                0,
                                null,
                                new TreeNode(
                                        2,
                                        null,
                                        null
                                )
                        )
                )
        );
    }

    @Test
    public void testTreeWithLeftAndRightChildLeaves() {
        assertEquals(
                1,
                new SumOfLeftLeaves().sumOfLeftLeaves(
                        new TreeNode(
                                0,
                                new TreeNode(
                                        1,
                                        null,
                                        null
                                ),
                                new TreeNode(
                                        2,
                                        null,
                                        null
                                )
                        )
                )
        );
    }

    @Test
    public void testTreeWithALeftChildThatHasASingleLeftLeaf() {
        assertEquals(
                2,
                new SumOfLeftLeaves().sumOfLeftLeaves(
                        new TreeNode(
                                0,
                                new TreeNode(
                                        1,
                                        new TreeNode(2, null, null),
                                        null
                                ),
                                null
                        )
                )
        );
    }

    @Test
    public void testTreeWithALeftChildThatHasLeftAndRightLeaves() {
        assertEquals(
                2,
                new SumOfLeftLeaves().sumOfLeftLeaves(
                        new TreeNode(
                                0,
                                new TreeNode(
                                        1,
                                        new TreeNode(2, null, null),
                                        new TreeNode(3, null, null)
                                ),
                                null
                        )
                )
        );

    }

    @Test
    public void testTreeWithALeftChildThatOnlyHasARightLeaf() {
        assertEquals(
                0,
                new SumOfLeftLeaves().sumOfLeftLeaves(
                        new TreeNode(
                                0,
                                new TreeNode(
                                        1,
                                        null,
                                        new TreeNode(3, null, null)
                                ),
                                null
                        )
                )
        );

    }

    @Test
    public void testTreeWithARightChildWithASingleLeftLeaf() {
        assertEquals(
                3,
                new SumOfLeftLeaves().sumOfLeftLeaves(
                        new TreeNode(
                                0,
                                null,
                                new TreeNode(
                                        2,
                                        new TreeNode(3, null, null),
                                        null
                                )
                        )
                )
        );
    }

    @Test
    public void testTreeWithARightChildWithASingleRightLeaf() {
        assertEquals(
                0,
                new SumOfLeftLeaves().sumOfLeftLeaves(
                        new TreeNode(
                                0,
                                null,
                                new TreeNode(
                                        2,
                                        null,
                                        new TreeNode(3, null, null)
                                )
                        )
                )
        );
    }

    @Test
    public void testTreeWithARightChildWithALeftAndRightLeaves() {
        assertEquals(
                2,
                new SumOfLeftLeaves().sumOfLeftLeaves(
                        new TreeNode(
                                0,
                                null,
                                new TreeNode(
                                        1,
                                        new TreeNode(2, null, null),
                                        new TreeNode(3, null, null)
                                )
                        )
                )
        );
    }
}
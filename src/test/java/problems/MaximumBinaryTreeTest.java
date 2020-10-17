package problems;

import org.junit.Test;
import problems.MaximumBinaryTree.TreeNode;

import static org.junit.Assert.*;

public class MaximumBinaryTreeTest {
    @Test
    public void testEmptyNumbers() {
        assertNull(new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{}));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(
                new TreeNode(1, null, null),
                new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{ 1 })
        );
    }

    @Test
    public void testSingleLeftSubtree() {
        assertEquals(
                new TreeNode(
                        2,
                        new TreeNode(1, null, null),
                        null
                ),
                new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{ 1, 2 })
        );
    }

    @Test
    public void testLeftAndRightSubtree() {
        assertEquals(
                new TreeNode(
                        3,
                        new TreeNode(2, new TreeNode(1, null, null), null),
                        null
                ),
                new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{ 1, 2, 3 })
        );
    }

    @Test
    public void testSingleRightSubtree() {
        assertEquals(
                new TreeNode(
                        2,
                        null,
                        new TreeNode(1, null, null)
                ),
                new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{ 2, 1 })
        );
    }

    @Test
    public void testRightSubtreeWithLeftBranch() {
        assertEquals(
                new TreeNode(
                        5,
                        null,
                        new TreeNode(
                                4,
                                new TreeNode(3, null, null),
                                new TreeNode(2, null, null)
                        )
                ),
                new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{ 5, 3, 4, 2 })
        );
    }

    @Test
    public void testLeftSubtreeWithLeftBranch() {
        assertEquals(
                new TreeNode(
                        5,
                        new TreeNode(
                                4,
                                new TreeNode(2, null, null),
                                new TreeNode(3, null, null)
                        ),
                        null
                ),
                new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{ 2, 4, 3, 5 })
        );
    }
}
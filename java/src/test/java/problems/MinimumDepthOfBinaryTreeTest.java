package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.MinimumDepthOfBinaryTree.*;

public class MinimumDepthOfBinaryTreeTest {
    @Test
    public void depthOfZeroForEmptyTree() {
        assertEquals(0, minDepth(null));
    }

    @Test
    public void depthOfOneForTreeWithNoChildren() {
        assertEquals(1, minDepth(new TreeNode(0)));
    }

    @Test
    public void depthOfTwoForTreeWithOnlyRightChild() {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(1);
        assertEquals(2, minDepth(root));
    }

    @Test
    public void depthOfTwoForTreeWithOnlyLeftChild() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        assertEquals(2, minDepth(root));
    }

    @Test
    public void depthOfTwoForTreeWithTwoChildren() {
        TreeNode root = new TreeNode(0);
        root.right = new TreeNode(2);
        root.left = new TreeNode(1);
        assertEquals(2, minDepth(root));
    }
}
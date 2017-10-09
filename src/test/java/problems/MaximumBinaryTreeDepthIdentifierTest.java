package problems;

import data.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumBinaryTreeDepthIdentifierTest {
    TreeNode rightRight1 = new TreeNode(4, null, null);
    TreeNode rightLeft1 = new TreeNode(5, null, null);
    TreeNode left0 = new TreeNode(2, null, null);
    TreeNode right0 = new TreeNode(3, rightLeft1, rightRight1);
    TreeNode root = new TreeNode(1, left0, right0);

    @Test
    public void itShouldReturnDepthOf0() {
        assertEquals(0, MaximumBinaryTreeDepthIdentifier.identifyMaxDepth(null));
    }

    @Test
    public void itShouldReturnDepthOf3() {
        assertEquals(3, MaximumBinaryTreeDepthIdentifier.identifyMaxDepth(root));
    }

    @Test
    public void itShouldReturnDepthOf1() {
        assertEquals(1, MaximumBinaryTreeDepthIdentifier.identifyMaxDepth(new TreeNode(1, null, null)));
    }

    @Test
    public void itShouldReturnCurrentDepthForNullNode() {
        assertEquals(1, MaximumBinaryTreeDepthIdentifier.identifyMaxDepthForNode(null, 1));
    }

    @Test
    public void itShouldReturnCurrentDepthPlus1ForNullChildren() {
        int currentDepth = 1;
        TreeNode nodeWithNullChildren = new TreeNode(1, null, null);
        assertEquals(currentDepth + 1, MaximumBinaryTreeDepthIdentifier.identifyMaxDepthForNode(nodeWithNullChildren, currentDepth));
    }

    @Test
    public void itShouldReturnDepthForNonNullLeftChild() {
        int currentDepth = 1;
        TreeNode leftChild = new TreeNode(1, null, null);
        TreeNode root = new TreeNode(2, leftChild, null);
        assertEquals(currentDepth + 2, MaximumBinaryTreeDepthIdentifier.identifyMaxDepthForNode(root, currentDepth));
    }
}
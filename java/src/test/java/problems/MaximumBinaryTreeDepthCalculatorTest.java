package problems;

import data.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumBinaryTreeDepthCalculatorTest {
    TreeNode emptyNode = new TreeNode(1, null, null);

    @Test
    public void itShouldReturnDepthOf0() {
        assertEquals(0, MaximumBinaryTreeDepthCalculator.calculateMaxDepth(null));
    }

    @Test
    public void itShouldReturnDepthOf3() {
        TreeNode rightRight1 = new TreeNode(4, null, null);
        TreeNode rightLeft1 = new TreeNode(5, null, null);
        TreeNode left0 = new TreeNode(2, null, null);
        TreeNode right0 = new TreeNode(3, rightLeft1, rightRight1);
        TreeNode root = new TreeNode(1, left0, right0);
        assertEquals(3, MaximumBinaryTreeDepthCalculator.calculateMaxDepth(root));
    }

    @Test
    public void itShouldReturnDepthOf1() {
        assertEquals(1, MaximumBinaryTreeDepthCalculator.calculateMaxDepth(emptyNode));
    }

    @Test
    public void itShouldReturnCurrentDepthForNullNode() {
        assertEquals(1, MaximumBinaryTreeDepthCalculator.calculateMaxDepthForNode(null, 1));
    }

    @Test
    public void itShouldReturnCurrentDepthPlus1ForNullChildren() {
        int currentDepth = 1;
        assertEquals(currentDepth + 1, MaximumBinaryTreeDepthCalculator.calculateMaxDepthForNode(emptyNode, currentDepth));
    }

    @Test
    public void itShouldReturnDepthForNonNullLeftChild() {
        int currentDepth = 1;
        TreeNode root = new TreeNode(2, emptyNode, null);
        assertEquals(currentDepth + 2, MaximumBinaryTreeDepthCalculator.calculateMaxDepthForNode(root, currentDepth));
    }
}
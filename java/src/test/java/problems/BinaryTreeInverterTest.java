package problems;

import data.TreeNode;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeInverterTest {
    @Test
    public void itShouldDoNothingForNullRoot() {
        assertNull(BinaryTreeInverter.createInvertedTree(null));
    }

    @Test
    public void itShouldCreateInvertedTree() {
        TreeNode rightRight1 = new TreeNode(4, null, null);
        TreeNode rightLeft1 = new TreeNode(5, null, null);
        TreeNode left0 = new TreeNode(2, null, null);
        TreeNode right0 = new TreeNode(3, rightLeft1, rightRight1);
        TreeNode root = new TreeNode(1, left0, right0);
        TreeNode expectedRightRight1 = new TreeNode(5, null, null);
        TreeNode expectedRightLeft1 = new TreeNode(4, null, null);
        TreeNode expectedLeft0 = new TreeNode(3, expectedRightLeft1, expectedRightRight1);
        TreeNode expectedRight0 = new TreeNode(2, null, null);
        TreeNode expected = new TreeNode(1, expectedLeft0, expectedRight0);
        assertEquals(expected, BinaryTreeInverter.createInvertedTree(root));
    }
}
package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.DiameterOfBinaryTree.*;

public class DiameterOfBinaryTreeTest {
    DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();

    @Test
    public void emptyTreeHasDiameterOfZero() {
        assertEquals(0, diameterOfBinaryTree.diameterOfBinaryTree(null));
    }

    @Test
    public void maxDepthDoesNotPassThroughRoot() {
        TreeNode three1 = new TreeNode(1);
        TreeNode four2 = new TreeNode(2);
        three1.left = four2;

        TreeNode three0 = new TreeNode(3);
        TreeNode four0 = new TreeNode(4);
        three0.left = four0;

        TreeNode two0 = new TreeNode(5);
        two0.left = three0;
        two0.right = three1;

        TreeNode root = new TreeNode(7);
        root.left = two0;

        assertEquals(4, diameterOfBinaryTree.diameterOfBinaryTree(root));
    }
}
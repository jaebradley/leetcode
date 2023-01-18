package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.BalancedBinaryTree.*;

public class BalancedBinaryTreeTest {

    @Test
    public void emptyTreeIsBalanced() {
        assertTrue(BalancedBinaryTree.isBalanced(null));
    }

    @Test
    public void isBalanced() {
        TreeNode second2 = new TreeNode(4);
        TreeNode second3 = new TreeNode(5);
        TreeNode first0 = new TreeNode(1);
        TreeNode first1 = new TreeNode(2);
        TreeNode root = new TreeNode(0);

        root.left = first0;
        root.right = first1;
        first1.left = second2;
        first1.right = second3;

        assertTrue(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    public void isNotBalanced() {
        TreeNode third5 = new TreeNode(7);
        TreeNode third4 = new TreeNode(6);
        TreeNode second2 = new TreeNode(4);
        TreeNode second3 = new TreeNode(5);
        TreeNode first0 = new TreeNode(1);
        TreeNode first1 = new TreeNode(2);
        TreeNode root = new TreeNode(0);

        root.left = first0;
        root.right = first1;
        first1.left = second2;
        first1.right = second3;
        second3.left = third4;
        second3.right = third5;

        assertFalse(BalancedBinaryTree.isBalanced(root));
    }

    @Test
    public void isNotBalancedForSingleNonNullSubtree() {
        TreeNode third5 = new TreeNode(7);
        TreeNode second3 = new TreeNode(5);
        TreeNode first1 = new TreeNode(2);
        TreeNode root = new TreeNode(0);

        root.right = first1;
        first1.right = second3;
        second3.right = third5;

        assertFalse(BalancedBinaryTree.isBalanced(root));
    }
}
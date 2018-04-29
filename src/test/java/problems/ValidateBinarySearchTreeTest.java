package problems;

import org.junit.Test;
import problems.ValidateBinarySearchTree.TreeNode;

import static org.junit.Assert.*;

public class ValidateBinarySearchTreeTest {
    @Test
    public void trueForEmptyBST() {
        assertTrue(ValidateBinarySearchTree.isValidBSTRecursive(null));
    }

    @Test
    public void falseForInvalidLeftSingleLevelBST() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);

        root.left = left;
        root.right = right;

        assertFalse(ValidateBinarySearchTree.isValidBSTRecursive(root));
    }

    @Test
    public void falseForInvalidRightSingleLevelBST() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(-1);
        TreeNode right = new TreeNode(-1);

        root.left = left;
        root.right = right;

        assertFalse(ValidateBinarySearchTree.isValidBSTRecursive(root));
    }

    @Test
    public void trueForValidTwoLevelBST() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(-5);
        TreeNode right = new TreeNode(5);
        TreeNode leftLeft = new TreeNode(-10);
        TreeNode leftRight = new TreeNode(-2);
        TreeNode rightLeft = new TreeNode(2);
        TreeNode rightRight = new TreeNode(10);

        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;
        right.right = rightRight;

        assertTrue(ValidateBinarySearchTree.isValidBSTRecursive(root));
    }

    @Test
    public void falseForInvalidLeftTwoLevelBST() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(-5);
        TreeNode right = new TreeNode(5);
        TreeNode leftLeft = new TreeNode(-3);
        TreeNode leftRight = new TreeNode(-2);
        TreeNode rightLeft = new TreeNode(2);
        TreeNode rightRight = new TreeNode(10);

        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;
        right.right = rightRight;

        assertFalse(ValidateBinarySearchTree.isValidBSTRecursive(root));
    }

    @Test
    public void falseForInvalidRightTwoLevelBST() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(-5);
        TreeNode right = new TreeNode(5);
        TreeNode leftLeft = new TreeNode(-3);
        TreeNode leftRight = new TreeNode(-10);
        TreeNode rightLeft = new TreeNode(2);
        TreeNode rightRight = new TreeNode(2);

        root.left = left;
        root.right = right;
        left.left = leftLeft;
        left.right = leftRight;
        right.left = rightLeft;
        right.right = rightRight;

        assertFalse(ValidateBinarySearchTree.isValidBSTRecursive(root));
    }
}
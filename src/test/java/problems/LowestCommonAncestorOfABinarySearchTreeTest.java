package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.LowestCommonAncestorOfABinarySearchTree.*;

public class LowestCommonAncestorOfABinarySearchTreeTest {

    @Test
    public void lowestCommonAncestorForChildrenInLeftAndRightSubtreesIsRoot() {
        TreeNode root = new TreeNode(6);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(8);
        TreeNode leftLeft = new TreeNode(0);
        TreeNode leftRight = new TreeNode(4);
        TreeNode rightLeft = new TreeNode(7);
        TreeNode rightRight = new TreeNode(9 );

        root.left = left;
        root.right = right;

        root.left.left = leftLeft;
        root.left.right = leftRight;

        root.right.left = rightLeft;
        root.right.right = rightRight;

        assertEquals(root, LowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor(root, leftLeft, rightRight));
    }

    @Test
    public void lowestCommonAncestorIsDirectParent() {
        TreeNode root = new TreeNode(6);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(8);
        TreeNode leftLeft = new TreeNode(0);
        TreeNode leftRight = new TreeNode(4);
        TreeNode rightLeft = new TreeNode(7);
        TreeNode rightRight = new TreeNode(9 );

        root.left = left;
        root.right = right;

        left.left = leftLeft;
        left.right = leftRight;

        right.left = rightLeft;
        right.right = rightRight;

        assertEquals(left, LowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor(root, leftLeft, leftRight));
    }

    @Test
    public void lowestCommonAncestorForChildAndParentIsParent() {
        TreeNode root = new TreeNode(6);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(8);
        TreeNode leftLeft = new TreeNode(0);
        TreeNode leftRight = new TreeNode(4);
        TreeNode rightLeft = new TreeNode(7);
        TreeNode rightRight = new TreeNode(9 );

        root.left = left;
        root.right = right;

        left.left = leftLeft;
        left.right = leftRight;

        right.left = rightLeft;
        right.right = rightRight;

        assertEquals(left, LowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor(root, left, leftRight));
    }
}
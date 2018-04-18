package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.LowestCommonAncestorOfABinaryTree.*;

public class LowestCommonAncestorOfABinaryTreeTest {

    @Test
    public void lowestCommonAncestorForChildrenInLeftAndRightSubtreesIsRoot() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7 );

        root.left = left;
        root.right = right;

        root.left.left = leftLeft;
        root.left.right = leftRight;

        root.right.left = rightLeft;
        root.right.right = rightRight;

        assertEquals(root, LowestCommonAncestorOfABinaryTree.lowestCommonAncestor(root, leftLeft, rightRight));
    }

    @Test
    public void lowestCommonAncestorIsDirectParent() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7 );

        root.left = left;
        root.right = right;

        left.left = leftLeft;
        left.right = leftRight;

        right.left = rightLeft;
        right.right = rightRight;

        assertEquals(left, LowestCommonAncestorOfABinaryTree.lowestCommonAncestor(root, leftLeft, leftRight));
    }

    @Test
    public void lowestCommonAncestorForChildAndParentIsParent() {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leftLeft = new TreeNode(4);
        TreeNode leftRight = new TreeNode(5);
        TreeNode rightLeft = new TreeNode(6);
        TreeNode rightRight = new TreeNode(7 );

        root.left = left;
        root.right = right;

        left.left = leftLeft;
        left.right = leftRight;

        right.left = rightLeft;
        right.right = rightRight;

        assertEquals(left, LowestCommonAncestorOfABinaryTree.lowestCommonAncestor(root, left, leftRight));
    }
}
package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.FlattenBinaryTreeToLinkedList.*;

public class FlattenBinaryTreeToLinkedListTest {

    @Test
    public void shouldBeNullForEmptyTree() {
        TreeNode root = null;
        FlattenBinaryTreeToLinkedList.flatten(root);
        assertNull(root);
    }

    @Test
    public void shouldBeOneRightChildForLeftOnlyTree() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);

        root.left = left;

        FlattenBinaryTreeToLinkedList.flatten(root);

        assertEquals(0, root.val);
        assertNull(root.left);
        assertEquals(1, root.right.val);
    }

    @Test
    public void shouldBeOneRightChildForRightOnlyTree() {
        TreeNode root = new TreeNode(0);
        TreeNode right = new TreeNode(1);

        root.right = right;

        FlattenBinaryTreeToLinkedList.flatten(root);

        assertEquals(0, root.val);
        assertNull(root.left);
        assertEquals(1, root.right.val);
    }

    @Test
    public void shouldBeLeftRightForTwoChildren() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);

        root.left = left;
        root.right = right;

        FlattenBinaryTreeToLinkedList.flatten(root);

        assertEquals(0, root.val);
        assertNull(root.left);
        assertEquals(1, root.right.val);
        assertNull(root.right.left);
        assertEquals(2, root.right.right.val);
    }

    @Test
    public void twoLevelBalancedBinaryTree() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(4);
        TreeNode leftLeft = new TreeNode(2);
        TreeNode leftRight = new TreeNode(3);
        TreeNode rightLeft = new TreeNode(5);
        TreeNode rightRight = new TreeNode(6);

        root.left = left;
        root.right = right;
        root.left.left = leftLeft;
        root.left.right = leftRight;
        root.right.left = rightLeft;
        root.right.right = rightRight;

        FlattenBinaryTreeToLinkedList.flatten(root);

        assertEquals(0, root.val);
        assertNull(root.left);
        assertEquals(1, root.right.val);
        assertNull(root.right.left);
        assertEquals(2, root.right.right.val);
        assertNull(root.right.right.left);
        assertEquals(3, root.right.right.right.val);
        assertNull(root.right.right.right.left);
        assertEquals(4, root.right.right.right.right.val);
        assertNull(root.right.right.right.right.left);
        assertEquals(5, root.right.right.right.right.right.val);
        assertNull(root.right.right.right.right.right.left);
        assertEquals(6, root.right.right.right.right.right.right.val);
        assertNull(root.right.right.right.right.right.right.left);
    }

    @Test
    public void twoLevelUnbalancedBinaryTree() {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode leftLeft = new TreeNode(2);
        TreeNode leftRight = new TreeNode(3);

        root.left = left;
        root.left.left = leftLeft;
        root.left.right = leftRight;

        FlattenBinaryTreeToLinkedList.flatten(root);

        assertEquals(0, root.val);
        assertNull(root.left);
        assertEquals(1, root.right.val);
        assertNull(root.right.left);
        assertEquals(2, root.right.right.val);
        assertNull(root.right.right.left);
        assertEquals(3, root.right.right.right.val);
        assertNull(root.right.right.right.left);
    }
}
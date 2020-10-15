package problems;

import org.junit.Test;
import problems.InsertIntoABinarySearchTree.TreeNode;

import static org.junit.Assert.*;

public class InsertIntoABinarySearchTreeTest {

    @Test
    public void testEmptyTree() {
        TreeNode nextTree = new InsertIntoABinarySearchTree().insertIntoBST(null, 5);
        assertEquals(5, nextTree.val);
    }

    @Test
    public void testSingleNodeTreeWithGreaterValue() {
        TreeNode nextTree = new InsertIntoABinarySearchTree().insertIntoBST(
                new TreeNode(1),
                5
        );
        assertEquals(1, nextTree.val);
        assertEquals(5, nextTree.right.val);
        assertNull(nextTree.left);
    }

    @Test
    public void testSingleNodeTreeWithSmallerValue() {
        TreeNode nextTree = new InsertIntoABinarySearchTree().insertIntoBST(
                new TreeNode(1),
                0
        );
        assertEquals(1, nextTree.val);
        assertEquals(0, nextTree.left.val);
        assertNull(nextTree.right);
    }

    @Test
    public void testTwoLevelTreeWithSmallerValue() {
        TreeNode nextTree = new InsertIntoABinarySearchTree().insertIntoBST(
                new TreeNode(
                        1,
                        new TreeNode(-1, null, null),
                        new TreeNode(2, null, null)
                ),
                -2
        );
        assertEquals(1, nextTree.val);
        assertEquals(-1, nextTree.left.val);
        assertEquals(-2, nextTree.left.left.val);
        assertNull(nextTree.left.right);
        assertEquals(2, nextTree.right.val);
        assertNull(nextTree.right.left);
        assertNull(nextTree.right.right);
    }


    @Test
    public void testTwoLevelTreeWithGreaterValue() {
        TreeNode nextTree = new InsertIntoABinarySearchTree().insertIntoBST(
                new TreeNode(
                        1,
                        new TreeNode(-1, null, null),
                        new TreeNode(2, null, null)
                ),
                10
        );
        assertEquals(1, nextTree.val);
        assertEquals(-1, nextTree.left.val);
        assertNull(nextTree.left.left);
        assertNull(nextTree.left.right);
        assertEquals(2, nextTree.right.val);
        assertNull(nextTree.right.left);
        assertEquals(10, nextTree.right.right.val);
    }
}
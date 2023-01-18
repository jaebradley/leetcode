package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.ConstructBinaryTreeFromInorderAndPostorderTraversal.*;

public class ConstructBinaryTreeFromInorderAndPostorderTraversalTest {

    @Test
    public void itShouldBuildTree() {
        int[] postorder =  new int[]{9, 15, 7, 20, 3};
        int[] inorder = new int[]{9,3,15,20,7};

        TreeNode root = buildTree(inorder, postorder);

        assertEquals(root.val, 3);
        assertEquals(root.left.val, 9);
        assertNull(root.left.left);
        assertNull(root.left.right);
        assertEquals(root.right.val, 20);
        assertEquals(root.right.left.val, 15);
        assertNull(root.right.left.left);
        assertNull(root.right.left.right);
        assertEquals(root.right.right.val, 7);
        assertNull(root.right.right.left);
        assertNull(root.right.right.right);
    }
}
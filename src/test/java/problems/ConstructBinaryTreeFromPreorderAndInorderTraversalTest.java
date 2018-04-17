package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.ConstructBinaryTreeFromPreorderAndInorderTraversal.*;

public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

    @Test
    public void itShouldBuildTree() {
        int[] preorder =  new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};

        TreeNode root = ConstructBinaryTreeFromPreorderAndInorderTraversal.buildTree(preorder, inorder);

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
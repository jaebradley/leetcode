package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.ConvertSortedArrayToBinaryTree.*;

public class ConvertSortedArrayToBinaryTreeTest {

    @Test
    public void nullArrayShouldReturnNull() {
        assertNull(sortedArrayToBST(null));
    }

    @Test
    public void emptyArrayShouldBeNull() {
        assertNull(sortedArrayToBST(new int[]{}));
    }

    @Test
    public void sortedArrayShouldReturnBST() {
        TreeNode output = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});

        assertEquals(output.val, 0);
        assertEquals(output.right.val, 5);
        assertNull(output.right.left);
        assertEquals(output.right.right.val, 9);
        assertEquals(output.left.val, -10);
        assertNull(output.left.left);
        assertEquals(output.left.right.val, -3);
    }
}
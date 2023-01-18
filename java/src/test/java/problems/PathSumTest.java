package problems;

import org.junit.Test;
import problems.PathSum.TreeNode;

import static org.junit.Assert.*;

public class PathSumTest {

    @Test
    public void itHasPathSum() {
        TreeNode one0 = new TreeNode(4);
        TreeNode one1 = new TreeNode(8);
        TreeNode root = new TreeNode(5);

        root.left = one0;
        root.right = one1;

        assertTrue(PathSum.hasPathSum(root, 9));
        assertTrue(PathSum.hasPathSum(root, 13));
        assertFalse(PathSum.hasPathSum(root, 12));
    }

    @Test
    public void itDoesNotHavePathSum() {
        TreeNode one0 = new TreeNode(4);
        TreeNode one1 = new TreeNode(8);
        TreeNode root = new TreeNode(5);

        root.left = one0;
        root.right = one1;

        assertFalse(PathSum.hasPathSum(root, 12));
        assertFalse(PathSum.hasPathSum(root, 0));
    }

    @Test
    public void emptyTreeDoesNotHavePathSum() {
        assertFalse(PathSum.hasPathSum(null, 0));
    }

    @Test
    public void rootIsNotPathSum() {
        TreeNode one0 = new TreeNode(4);
        TreeNode root = new TreeNode(1);

        root.left = one0;

        assertFalse(PathSum.hasPathSum(root, 1));
    }
}
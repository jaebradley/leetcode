package problems;

import org.junit.Test;

import static org.junit.Assert.*;
import static problems.SameTree.*;

public class SameTreeTest {

    @Test
    public void trueForEmptyTrees() {
        assertTrue(isSameTree(null, null));
    }

    @Test
    public void falseForOnlyOneEmptyTree() {
        assertFalse(isSameTree(null, new TreeNode(1)));
    }

    @Test
    public void trueForTreesWithSameChildren() {
        TreeNode root1 = new TreeNode(0);
        TreeNode root1First0 = new TreeNode(1);
        TreeNode root1First1 = new TreeNode(2);
        root1.left = root1First0;
        root1.right = root1First1;

        TreeNode root2 = new TreeNode(0);
        TreeNode root2First0 = new TreeNode(1);
        TreeNode root2First1 = new TreeNode(2);
        root2.left = root2First0;
        root2.right = root2First1;

        assertTrue(isSameTree(root1, root2));
    }

    @Test
    public void falseForTreesWithoutSameChildren() {
        TreeNode root1 = new TreeNode(0);
        TreeNode root1First0 = new TreeNode(1);
        TreeNode root1First1 = new TreeNode(2);
        root1.left = root1First0;
        root1.right = root1First1;

        TreeNode root2 = new TreeNode(0);
        TreeNode root2First0 = new TreeNode(1);
        TreeNode root2First1 = new TreeNode(3);
        root2.left = root2First0;
        root2.right = root2First1;

        assertFalse(isSameTree(root1, root2));
    }
}